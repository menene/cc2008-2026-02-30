/*
 * Universidad del Valle de Guatemala
 * CC2008 - Programación Orientada a Objetos
 * Ejercicio 6 - Polimorfismo vía interfaces
 * Autor: David Maximiliano Pablo Cuy (261341)
 *
 * GestorIntegraciones (Controlador): administra la única lista polimórfica
 * del sistema y contiene la lógica central de checkout. Trabaja con las
 * integraciones a través de sus contratos (Transaccional, Documentable,
 * Consultable, Auditable), así que una integración nueva funciona sin
 * modificar esta clase. No imprime nada: devuelve resultados a la vista.
 */

import java.util.ArrayList;
import java.util.Collections;

public class GestorIntegraciones {

    //Única lista polimórfica que guarda todas las integraciones con el tipo común
    private ArrayList<IntegracionAPI> catalogo;
    private int siguienteOrden;

    //Constructor: catálogo vacío y correlativo de órdenes en 1
    public GestorIntegraciones() {
        this.catalogo = new ArrayList<>();
        this.siguienteOrden = 1;
    }

    public void agregarIntegracion(IntegracionAPI integracion) {
        if (integracion == null) {
            throw new IllegalArgumentException("La integración no puede ser null.");
        }
        if (catalogo.contains(integracion)) {
            throw new IllegalArgumentException("Ya existe una integración con el identificador '"
                    + integracion.getIdentificador() + "'.");
        }
        catalogo.add(integracion);
    }

    //Copia del catálogo completo
    public ArrayList<IntegracionAPI> listarIntegraciones() {
        return new ArrayList<>(catalogo);
    }

    public ArrayList<IntegracionAPI> listarIntegraciones(EstadoConexion estado) {
        ArrayList<IntegracionAPI> filtradas = new ArrayList<>();
        for (IntegracionAPI integracion : catalogo) {
            if (integracion.getEstadoConexion() == estado) {
                filtradas.add(integracion);
            }
        }
        return filtradas;
    }

    public IntegracionAPI buscarPorId(String identificador) {
        IntegracionAPI encontrada = null;
        if (identificador != null) {
            for (IntegracionAPI integracion : catalogo) {
                if (encontrada == null
                        && integracion.getIdentificador().equalsIgnoreCase(identificador.trim())) {
                    encontrada = integracion;
                }
            }
        }
        return encontrada;
    }

    //Ordena el catálogo con Collections.sort
    public ArrayList<IntegracionAPI> ordenarPorLatencia() {
        Collections.sort(catalogo);
        return new ArrayList<>(catalogo);
    }

    // Overloading: si es true ordena de mayor a menor para ver primero los cuellos de botella
    public ArrayList<IntegracionAPI> ordenarPorLatencia(boolean descendente) {
        if (descendente) {
            Collections.sort(catalogo, Collections.reverseOrder());
            return new ArrayList<>(catalogo);
        }
        return ordenarPorLatencia();
    }

    public ArrayList<ResultadoOperacion> procesarCompra(String idPasarela, String idLogistica,
                                                        String idCertificador, double monto,
                                                        double pesoKg, String destino) {
        ArrayList<ResultadoOperacion> resultados = new ArrayList<>();
        String referencia = generarReferencia();

        // 1. Cotización del envío - contrato Consultable
        IntegracionAPI logistica = buscarPorId(idLogistica);
        ResultadoOperacion cotizacion;
        if (logistica == null) {
            cotizacion = noEncontrada(idLogistica, "Cotización de envío");
        } else if (logistica instanceof Consultable proveedor) {
            cotizacion = cotizarCon(proveedor, pesoKg, destino);
        } else {
            cotizacion = ignorar(idLogistica, "Cotización de envío");
        }
        resultados.add(cotizacion);

        if (cotizacion.fueExitosa()) {
            double costoEnvio = cotizacion.getMonto();
            double total = monto + costoEnvio;

            // 2. Cobro - contrato Transaccional
            IntegracionAPI pasarela = buscarPorId(idPasarela);
            ResultadoOperacion cobro;
            if (pasarela == null) {
                cobro = noEncontrada(idPasarela, "Cobro");
            } else if (pasarela instanceof Transaccional transaccional) {
                cobro = cobrarCon(transaccional, total, referencia);
            } else {
                cobro = ignorar(idPasarela, "Cobro");
            }
            resultados.add(cobro);

            if (cobro.fueExitosa()) {
                // 3. Factura - contrato Documentable
                IntegracionAPI certificador = buscarPorId(idCertificador);
                if (certificador == null) {
                    resultados.add(noEncontrada(idCertificador, "Factura FEL"));
                } else if (certificador instanceof Documentable emisor) {
                    resultados.add(documentarCon(emisor, referencia, total));
                } else {
                    resultados.add(ignorar(idCertificador, "Factura FEL"));
                }

                if (logistica instanceof Documentable emisorGuia) {
                    resultados.add(documentarCon(emisorGuia, referencia, costoEnvio));
                } else {
                    resultados.add(ignorar(idLogistica, "Guía de envío"));
                }
            }
        }
        return resultados;
    }

    public ResultadoOperacion procesarReintegro(String idIntegracion, double monto, String referencia) {
        IntegracionAPI integracion = buscarPorId(idIntegracion);
        if (integracion == null) {
            return noEncontrada(idIntegracion, "Reintegro");
        }
        if (integracion instanceof Transaccional transaccional) {
            return transaccional.reintegrar(monto, referencia);
        }
        return ignorar(idIntegracion, "Reintegro");
    }

    public ResultadoOperacion rastrearEnvio(String idIntegracion, String codigoGuia) {
        IntegracionAPI integracion = buscarPorId(idIntegracion);
        if (integracion == null) {
            return noEncontrada(idIntegracion, "Rastreo de envío");
        }
        if (integracion instanceof Consultable consultable) {
            return consultable.rastrearEnvio(codigoGuia);
        }
        return ignorar(idIntegracion, "Rastreo de envío");
    }

    public ArrayList<String> obtenerBitacora(String idIntegracion) {
        IntegracionAPI integracion = buscarPorId(idIntegracion);
        if (integracion instanceof Auditable auditable) {
            return auditable.getBitacora();
        }
        return new ArrayList<>();
    }

    //Recibe la interfaz como parámetro
    private ResultadoOperacion cobrarCon(Transaccional pasarela, double monto, String referencia) {
        return pasarela.cobrar(monto, referencia);
    }

    //Recibe la interfaz como parámetro
    private ResultadoOperacion documentarCon(Documentable emisor, String referencia, double monto) {
        return emisor.generarDocumento(referencia, monto);
    }

    private ResultadoOperacion cotizarCon(Consultable proveedor, double pesoKg, String destino) {
        return proveedor.cotizarEnvio(pesoKg, destino);
    }

    //Resultado IGNORADA cuando la API no cumple el contrato que se le pide.
    private ResultadoOperacion ignorar(String idIntegracion, String operacion) {
        return new ResultadoOperacion(idIntegracion, operacion, EstadoOperacion.IGNORADA,
                "La integración no soporta esta operación; la petición se ignoró.");
    }

    // Resultado RECHAZADA cuando el identificador no existe en el catálogo.

    private ResultadoOperacion noEncontrada(String idIntegracion, String operacion) {
        return new ResultadoOperacion(idIntegracion, operacion, EstadoOperacion.RECHAZADA,
                "No existe una integración con ese identificador.");
    }

    private String generarReferencia() {
        String referencia = String.format("ORD-%04d", siguienteOrden);
        siguienteOrden++;
        return referencia;
    }
}

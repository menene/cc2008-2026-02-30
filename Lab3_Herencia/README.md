# Laboratorio 3. Herencia - EnviaGT

**Nombre completo:** Nery Javier de la Cruz Huinil
**Carné:** 261233

**Nombre completo:** David Maximiliano Pablo Cuy
**Carné:** 261341

## Descripción
Aplicación de consola para la empresa de mensajería EnviaGT, que recibe envíos en su bodega
central y los reparte con su propia flotilla. Desde un menú de 12 opciones el personal puede
cotizar y registrar envíos de las cuatro categorías, registrar vehículos, crear despachos,
asignar y retirar envíos, hacer salir un despacho, registrar los resultados de entrega,
consultar envíos y vehículos, y ver los reportes de envíos por categoría y estado, de
ingresos y de despachos no cerrados.

El programa usa una jerarquía de herencia:

- `Envio` (abstracta) guarda los datos comunes, controla el estado, los intentos y los
  cobros, y declara `calcularCosto()`, `calcularDiasEntrega()`, `getMaxIntentos()` y
  `getCategoria()`. `requiereRefrigeracion()` devuelve `false` por defecto.
- `Sobre`, `Paquete` y `CargaRefrigerada` heredan de `Envio`. `PaqueteFragil` hereda de
  `Paquete` y reutiliza su costo y sus días con `super`, sumando embalaje, seguro y un día.

Las decisiones que dependen de la categoría se resuelven con métodos sobrescritos.
`Despacho`, `Vehiculo` y `EmpresaMensajeria` trabajan siempre con el tipo `Envio`, sin
`instanceof`. La única parte que conoce las subclases es `Vista.leerDatosEnvio()`, que
pregunta la categoría para saber qué objeto construir.

`Vehiculo.puedeTransportar()` valida la compatibilidad con refrigeración;
`Despacho.asignarEnvio()` revisa estado, capacidad (con peso real) y compatibilidad antes de
cambiar algo; `Despacho.salir()` llama a `Envio.salirARuta()`, que es donde se registra el
cargo de Q15 por reintento. Los ingresos se calculan sumando `montoRegistro` y
`cargosReintento` de cada envío, así que las cotizaciones, los retiros y las operaciones
rechazadas no los modifican.

El programa inicia con dos envíos de cada categoría en bodega (sin ingresos) y tres
vehículos: `P123ABC` (500 kg, no refrigerado), `C456DEF` (800 kg, refrigerado) y
`M789GHI` (5 kg, no refrigerado, para probar la capacidad).

El análisis, el diagrama UML y las pruebas están en `docs/`.

## Cómo ejecutar
Desde la carpeta `EnviaGT`:

```bash
javac -d bin src/*.java
java -cp bin Main
```

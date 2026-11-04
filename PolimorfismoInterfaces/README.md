# Ejercicio 6 - Polimorfismo vía interfaces

**Nombre completo:** David Maximiliano Pablo Cuy
**Carné:** 261341

## Descripción

Sistema central de un backend de comercio electrónico que gestiona las integraciones con APIs externas: pasarelas de pago (tarjeta, transferencia y billetera digital), proveedores de logística (mensajería local y paquetería nacional) y certificadores de Factura Electrónica en Línea (FEL).

Las capacidades de cada API se modelan con los contratos `Transaccional`, `Documentable`, `Auditable` y `Consultable`. Si el sistema pide una operación a una API que no cumple el contrato correspondiente (por ejemplo, un reintegro a un proveedor logístico), la petición se marca como IGNORADA, sin lanzar excepciones ni detener la compra.

Al iniciar se cargan 10 integraciones. El menú de consola permite:

1. Listar las integraciones con su estado de conexión, con filtro opcional por estado.
2. Buscar una integración por identificador y ver su configuración y su bitácora.
3. Ordenar el catálogo por latencia promedio, ascendente o descendente (`Comparable`).
4. Simular una compra: cotización, cobro, factura FEL y guía de envío.
5. Procesar un reintegro.
6. Rastrear un envío.

## Cómo ejecutar

```bash
javac -d bin src/*.java
java -cp bin Principal
```

# Hoja de Trabajo 3 - Sistema de Control de Órdenes de Servicio de un Taller Automotriz

**Nombre completo:** Henry Emanuel Vicente Alvarado
**Carné:** 26275

## Descripción
El programa administra las órdenes de servicio de un taller automotriz. Cada orden almacena número de orden, nombre del propietario, placa del vehículo, descripción del servicio y costo estimado. El sistema permite registrar, consultar, buscar, modificar y cancelar órdenes, así como consultar órdenes por placa y generar reportes (valor total, costo promedio y orden de mayor costo). Las órdenes se almacenan dinámicamente en una colección `List`/`ArrayList`, y las operaciones críticas (entradas inválidas, búsquedas/modificaciones/cancelaciones de órdenes inexistentes) están protegidas con `try-catch` y al menos un bloque `finally`.

El sistema sigue el patrón MVC:
- **Modelo:** `OrdenServicio` (representa una orden individual) y `GestorOrdenes` (administra la colección dinámica de órdenes y la lógica de negocio).
- **Vista:** `VistaTaller` (maneja la interacción con el usuario: menú y mensajes).
- **Controlador:** `ControladorTaller` (coordina la vista y el modelo).
- **Driver:** `Main` (punto de entrada del programa).

## Cómo ejecutar
```bash
javac -d bin src/*.java
java -cp bin Main
```
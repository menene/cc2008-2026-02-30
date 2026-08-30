# Laboratorio 3 - Título de la tarea

**Nombre completo:** Angel Javier Tum González
**Carné:** 26385

## Descripción
Explicación de la tarea: qué problema resuelve el programa, qué clases lo
componen y qué decisiones de diseño se tomaron.

Este proyecto implementa un sistema de gestión de órdenes de servicio para un taller mecánico. La aplicación sigue el patrón MVC con tres componentes principales:

- `GestorOrdenes`: representa el modelo y contiene la lógica de gestión de las órdenes y la lista de datos.
- `VistaTaller`: es la vista, encargada de mostrar menús, pedir datos al usuario y presentar resultados.
- `ControladorTaller`: conecta la vista con el modelo y controla la lógica del flujo del programa.

Además, la clase `OrdenServicio` representa cada orden individual con sus datos como cliente, placa, descripción del servicio y costo estimado.

## Cómo ejecutar
```bash
javac -d bin src/*.java
java -cp bin Main
```

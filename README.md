# Ejercicio 3 - Sistema de Control de Ordenes de Servicio

**Nombre completo:** Roger Yorkaef Mendez Garcia  
**Carne:** 26786

## Descripcion

Programa desarrollado en Java para administrar las ordenes de servicio de un taller.

El sistema permite registrar, consultar, buscar, modificar y cancelar ordenes de servicio. Tambien permite consultar ordenes por placa, calcular el costo total y promedio, determinar la orden de mayor costo y consultar la cantidad de ordenes registradas.

El programa utiliza `List` y `ArrayList` para almacenar dinamicamente objetos de tipo `OrdenServicio`. La solucion se divide en las clases `OrdenServicio`, `VistaConsola`, `SistemaTaller` y `Main`, manteniendo separadas las responsabilidades del modelo, la interaccion con el usuario y el control del sistema (MVC).

Tambien se utiliza manejo de excepciones mediante `try-catch` y `finally` para evitar que entradas u operaciones invalidas finalicen inesperadamente la ejecucion.

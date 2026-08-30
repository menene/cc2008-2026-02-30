# Ejercicio 3 - Arreglos dinámicos

**Nombre completo:** Joel Alejandro Chávez Pérez
**Carné:** 26888

## Descripción
El programa resuelve la necesidad de un taller automotriz de administrar dinámicamente las órdenes de servicio de los vehículos que recibe para mantenimiento o reparación. El sistema permite registrar, consultar, buscar, modificar y cancelar órdenes; también permite consultar las órdenes asociadas a una placa, calcular el costo total y promedio, identificar la orden de mayor costo y mostrar la cantidad de órdenes activas. Para ello, las órdenes se almacenan sin un límite fijo mediante una colección declarada con List e implementada con ArrayList, y se utiliza manejo de excepciones para evitar que entradas u operaciones inválidas finalicen inesperadamente el programa.

De manera preliminar, el sistema estará compuesto por una clase OrdenServicio, que representará los datos de cada orden; una clase encargada de administrar la colección y realizar las operaciones del sistema; una vista para la entrada y salida de información; un controlador para coordinar las acciones del menú; y una clase Main como punto de inicio del programa. Se decidió aplicar encapsulamiento para proteger los atributos, identificar cada orden mediante un número único, separar las responsabilidades siguiendo una estructura MVC sencilla y utilizar try-catch y finally para controlar errores y mantener el programa en funcionamiento.

## Cómo ejecutar
```bash
javac -d bin src/*.java
java -cp bin Main
```
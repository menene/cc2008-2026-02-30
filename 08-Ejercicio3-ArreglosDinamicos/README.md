**Santiago Aguilón Muñoz**
**26199**

Creación y prueba de la nueva entrega de trabajos.

Ejercicio 3: Prueba de arraylists.

El programa simula un sistema de ordenes y servicios de un taller, en donde poder buscar y organizar los pedidos.
- Permite ingresar una nueva orden
- Permite modificar y eliminar las ordenes
- Permite ver el promedio de costos y costo máximo
- Permite ver el reporte de costos y las ordenes registradas

En la clase PrincipalMain se inicia la ejecución mediante el método main(). También se encarga de mostrar el menú, recibir los datos ingresados por el usuario y solicitar a la clase Taller que ejecute cada operación.

En otros ejercicios he usado una clase Main que solamente crea e inicia un controlador. En este caso no se creó una clase controladora independiente porque el programa no es complejo, se ejecuta completamente en consola y sus operaciones se limitan a la administración de órdenes de servicio.

La clase de PrincipalMain Seria la parte de vista (View del modelo MVC) del programa, puesto que muestra la información e interactua con el ususario.

Por otro lado, la clase de taller realiza las operaciones del servicio, siendo esta parte el controlador.

Por último, la clase de OrdenServicio es el modelo, pues con esta se guarda la información de las ordenes creadas por el usuario.

Las funciones del programa son las siguientes:

El menú principal contiene las siguientes opciones:

1. Registrar una orden.

2. Consultar todas las órdenes.

3. Buscar una orden por su número.

4. Modificar una orden.

5. Cancelar una orden.

6. Consultar órdenes por placa.

7. Mostrar el reporte de costos.

8. Mostrar la orden de mayor costo.

9. Mostrar la cantidad de órdenes.

10. Salir del programa.

**COMO EJECUTAR**
javac -d bin src/*.java
java -cp bin PrincipalMain
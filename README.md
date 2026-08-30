# Ejercicio 3 - Arreglos dinámicos

**Nombre completo:** Juan Fernando Santos Mérida
**Carné:** 26693

## Descripción
El programa permite administrar las órdenes de servicio de un taller. Mediante un menú, el usuario puede registrar, consultar, modificar y cancelar órdenes, buscarlas por placa y generar reportes sobre sus costos. Está compuesto por las clases: Main que inicia el programa, OrdenServicio que representa cada orden, ControladorOrdenes que administra las operaciones y la lista de órdenes y VistaOrdenes que maneja la interacción con el usuario. La solución utiliza el modelo-vista-controlador, un array dinámico y manejo de excepciones para controlar datos inválidos y operaciones que no pueden realizarse.

## Cómo ejecutar
```bash
javac -d bin src/*.java
java -cp bin Main
```
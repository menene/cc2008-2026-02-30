# Tarea 3: ArrayList

** Andrea Ramazzini**
**26496**

## Descripcion

Un taller automotriz necesita un sistema para llevar el control de las ordenes de servicio de los vehiculos que recibe.

El objetivo de esta tarea es desarrollar un sistema que permita al taller registrar y consultar ordenes de servicio, realizar busquedas, consultar informacion de propietarios y vehiculos, modificar ordenes y cancelar aquellas que ya no se encuentren activas. De esta manera, se busca mantener un mejor control y organizacion de los servicios realizados por el taller.

## Clases

- `OrdenServicio`: representa cada orden de servicio y almacena su informacion.
- `ControladorOrdenes`: administra la coleccion dinamica de ordenes y realiza las operaciones del sistema.
- `VistaOrdenes`: obtiene informacion del usuario y muestra los resultados.
- `Main`: inicia el programa y coordina la interaccion entre la vista y el controlador.

## Compilar

```bash
javac -d bin src/*.java
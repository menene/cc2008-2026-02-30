# Hoja de Trabajo 3 - Órdenes de servicio

**Nombre:** Nathalia Isabela Escobar Otto
**Carné:** 261136

## Descripción

Este programa sirve para manejar órdenes de servicio. Por medio de un menú, el usuario puede ingresar las opciones disponibles y consultar la información de las órdenes.

Para realizar el programa utilicé diferentes clases, con el objetivo de dividir las funciones y tener el código más ordenado.

## Clases

* **Main:** inicia el programa.
* **Vista:** muestra el menú y recibe los datos ingresados por el usuario.
* **Controlador:** controla las opciones seleccionadas y conecta las demás clases.
* **GestorOrdenes:** se encarga de guardar y manejar las órdenes.
* **OrdenServicio:** contiene la información de cada orden de servicio.

## Diseño del programa

Decidí separar el programa en varias clases para que cada una tenga una función específica. La vista se encarga de comunicarse con el usuario, el controlador procesa las opciones y el gestor administra las órdenes.

De esta manera el código queda más organizado y es más fácil encontrar o modificar alguna función.

## Cómo compilar

Para compilar el programa se debe ejecutar el siguiente comando desde la carpeta principal:

```bash
javac -d bin src/*.java
```

## Cómo ejecutar

Después de compilar, el programa se puede ejecutar con:

```bash
java -cp bin Main
```

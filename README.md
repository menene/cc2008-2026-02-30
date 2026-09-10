# Laboratorio 2 - Festival Universitario de Música

**Integrantes:**  
Laura Suseth Morales Murga - 26281  
Roger Yorkaef Méndez García - 26786

## Descripción

Programa desarrollado en Java para administrar un Festival Universitario de Música. El sistema permite configurar, consultar, modificar y retirar escenarios utilizando un arreglo básico de tamaño fijo.

También permite registrar, consultar, buscar, modificar y cancelar la participación de artistas utilizando un ArrayList. El programa implementa manejo de excepciones mediante try-catch, InputMismatchException, IllegalArgumentException y finally.

El sistema utiliza el patrón Modelo-Vista-Controlador (MVC) para separar la administración de los datos, la interacción con el usuario y el control de las operaciones.

## Cómo ejecutar

bash
javac -d bin src/*.java
java -cp bin Main

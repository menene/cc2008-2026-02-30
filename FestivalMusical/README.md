# Laboratorio 2. Arreglos y excepciones - Programa

**Nombre completo:** Nery Javier de la Cruz Huinil
**Carné:** 261233

**Nombre completo:** David Maximiliano Pablo Cuy
**Carné:** 261341

## Descripción
Programa para administrar el Festival Universitario de Música: permite configurar los
escenarios donde se presentan los artistas, registrar a los artistas participantes y
mostrar un reporte general del festival, todo desde un menú de 13 opciones.

Está compuesto por cinco clases: `Escenario` y `Artista` guardan los datos de cada uno y
validan sus valores, `Festival` administra las dos colecciones y hace los cálculos del
reporte, `Vista` muestra el menú y lee lo que escribe el usuario, y `Main` es el driver
program.

Como decisiones de diseño, los escenarios se guardan en un arreglo básico de 5 objetos
porque la cantidad es fija y las posiciones sin configurar quedan en `null`, mientras que
los artistas se guardan en un `ArrayList` porque no se sabe cuántos serán. Todos los
atributos son `private` y las validaciones de los objetos viven en el modelo, que lanza
`IllegalArgumentException`. La vista maneja `InputMismatchException` con un bloque
`finally` para limpiar la entrada, de modo que el programa nunca se cierra por un dato
incorrecto.

## Cómo ejecutar
```bash
javac -d bin src/*.java
java -cp bin Main
```

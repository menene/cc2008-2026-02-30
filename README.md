# Laboratorio 2 - Arreglos y excepciones

**Daniel Fernando Xiquin Tezén**
**26896**

## Descripción
Programa de consola para administrar un festival musical: escenarios y artistas, con consultas, modificaciones y un reporte.

**Clases:** `Festival`, `Escenario` y `Artista` (modelo); `ControladorFestival`, `ControladorEscenario` y `ControladorArtista` (lógica y validaciones); `VistaFestival` (entradas y salidas a consola); `Main` (punto de partida).

**Diseño:** MVC. Escenarios en arreglo fijo de 5 (`null` = vacío); artistas en `ArrayList`. Errores con `try-catch`/`finally` para no terminar el programa. Validación en los controladores; la vista no conoce el modelo.
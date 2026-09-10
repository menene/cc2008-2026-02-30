# Laboratorio 2 - Sistema de gestión de festivales

*Nombre completo:* Angel Javier Tum González
*Carné:* 26385

## Descripción
Este proyecto implementa un sistema de gestión para un festival universitario. Permite crear un festival, configurar y administrar escenarios, registrar artistas y consultar un reporte general con estadísticas del festival.

La aplicación sigue el patrón MVC con tres componentes principales:

- `Festival`: representa el modelo y almacena la información del festival, sus escenarios y sus artistas.
- `VistaFestival`: es la vista, encargada de mostrar el menú, solicitar datos al usuario y presentar mensajes, consultas y reportes.
- `ControladorFestival`: conecta la vista con el modelo y controla el flujo de las operaciones del sistema.

Además, las clases `Escenario` y `Artista` representan las entidades administradas por el festival. El programa valida datos como la capacidad de los escenarios, el tiempo de presentación y el público estimado. También permite buscar, modificar y retirar registros, así como calcular estadísticas del festival.

## Cómo ejecutar
```bash
javac -d bin src/*.java
java -cp bin Main
```
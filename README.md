# Ejercicio 3 - Arreglos dinámicos, ArrayList, List y Excepciones
	Sistema de Control de Órdenes de Servicio de un Taller Automotriz

**Nombre completo:** Kellie Sophia López Torres
**Carné:** 261551

## Descripción
El programa resuelve la administración de órdenes de servicio de un taller automotriz. Permite registrar, consultar, buscar, modificar y cancelar órdenes, además de generar reportes de costos y realizar búsquedas por placa.

El sistema está compuesto por las clases Orden, GestionOrdenes, OrdenView, OrdenController y Main. Se utilizó el modelo MVC para separar los datos, la interacción con el usuario y el control del programa. Las órdenes se almacenan dinámicamente mediante List y ArrayList, y se emplean try-catch y finally para controlar errores sin finalizar inesperadamente la ejecución.

## Cómo ejecutar
```bash
javac -d bin src/*.java
java -cp bin Main
```
# Laboratorio 2 - Festival Universitario de Música

**Nombre completo:** Henry Emanuel Vicente Alvarado
**Carné:** 26275

**Nombre completo:** Joel Alejandro Chávez Pérez
**Carné:** 26888

## Descripción

Sistema para administrar un festival universitario de música: el coordinador
registra la información general del festival, configura hasta 5 escenarios
físicos y lleva el control de los artistas que se van a presentar.

El programa está dividido en las siguientes clases, siguiendo el patrón MVC:

- **Escenario** (modelo): representa un espacio físico del festival (código,
  nombre, ubicación, capacidad máxima y estado). Se almacena en un **arreglo
  básico de tamaño fijo (5)** dentro de `Festival`, ya que la cantidad de
  escenarios está definida desde el inicio.
- **Artista** (modelo): representa a un artista registrado (código, nombre
  artístico, género musical, duración de la presentación y asistentes
  estimados). Se almacena en un **ArrayList** dentro de `Festival`, ya que la
  cantidad de artistas cambia constantemente durante la organización.
- **Festival** (modelo/gestor): administra el arreglo de `Escenario` y el
  ArrayList de `Artista`; valida datos, realiza las operaciones de
  registro/consulta/modificación/eliminación y calcula el reporte final.
- **VistaFestival** (vista): entrada y salida por consola; no contiene
  lógica de negocio ni recorre colecciones, solo muestra o lee un dato a la
  vez.
- **ControladorFestival** (controlador): media entre `VistaFestival` y
  `Festival`; maneja el menú, el recorrido de colecciones y las excepciones
  con try-catch-finally. Crea su propia instancia de `VistaFestival`.
- **Main**: *driver program*, solo crea `ControladorFestival` y arranca el
  sistema.

### Decisiones de diseño relevantes

- `Escenario` y `Artista` se relacionan con `Festival` por **agregación**
  (no composición): ambos representan entidades con existencia propia (un
  espacio físico, una persona) y no partes que solo tengan sentido dentro de
  un festival.
- Los getters `getEscenarios()` y `getArtistas()` devuelven **copias
  defensivas** del arreglo y del ArrayList para proteger el encapsulamiento.
- Convención de resultados en los métodos que modifican estado: retorno
  `boolean = false` ante una regla de negocio recuperable (posición ocupada,
  código duplicado, elemento no encontrado); `IndexOutOfBoundsException` ante
  una posición fuera de rango (1 a 5, de cara al usuario); `IllegalArgumentException`
  ante datos inválidos.
- Las entradas numéricas incorrectas (texto, decimales, vacías) se manejan
  con `InputMismatchException`, reintentando solo el campo con error sin
  perder los datos ya ingresados.

## Cómo ejecutar

```bash
javac -d bin src/*.java
java -cp bin Main
```
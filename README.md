# cc2008 - 2026 - 02 - 30

Curso que introduce el paradigma de Programación Orientada a Objetos (Java) como complemento a Algoritmos y Programación Básica, cubriendo desde clases y encapsulamiento hasta herencia, polimorfismo y principios de diseño SOLID.

---

## Contenido del repositorio

La rama `main` contiene los ejemplos vistos en clase. Cada carpeta es un proyecto independiente que se compila y ejecuta por su cuenta.

| Carpeta | Tema |
|---|---|
| `00-Hello-World` | Primer programa, compilación y ejecución desde la terminal |
| `01-Perro` | Primera clase: atributos, constructor y métodos |
| `02-Palatino` | Modelo, vista y controlador; menú y encapsulamiento |
| `03-Aliases` | Referencias y alias: `==` contra `equals()`, objetos en memoria |
| `04-Palatino-Plus` | Sobrescritura de `toString()` y búsqueda por nombre o alias |
| `05-Palatino-Pro` | Enums: `NivelRendimiento` y clasificación por efectividad |
| `06-Excepciones` | Manejo, propagación y creación de excepciones propias |
| `07-Palatino-Ultra` | `ArrayList`: agregar y eliminar equipos en tiempo de ejecución |

### Cómo compilar y ejecutar cualquier ejemplo

Desde la carpeta del proyecto:

```bash
javac -d bin src/*.java
java -cp bin Main
```

---

## Entrega de tareas y laboratorios

Cada entrega vive en **su propia rama**, creada desde cero y sin historial de otras entregas, y se entrega abriendo un **Pull Request** hacia `main`. No se trabaja sobre `main` ni sobre la rama de otro compañero.

### 1. Nomenclatura de la rama

```
carnet-nombre-apellido-tarea
```

| Ejemplo | Entrega |
|---|---|
| `12345-alan-turing-lab3` | Laboratorio 3 |
| `12345-alan-turing-hdt1` | Hoja de trabajo 1 |
| `12345-alan-turing-pro1` | Proyecto |

Todo en minúsculas, sin tildes, sin espacios y separado con guiones.

### 2. Crear la rama vacía

Una rama *huérfana* (`--orphan`) nace sin historial y sin archivos: es una hoja en blanco, no una copia de `main`.

```bash
# Partir siempre de main actualizado
git checkout main
git pull

# Crear la rama nueva sin historial
git checkout --orphan 12345-alan-turing-lab3

# Vaciar el árbol de trabajo que se heredó de main
git rm -rf .
```

Después de estos comandos la carpeta queda vacía y lista para la entrega.

### 3. Estructura obligatoria

```
12345-alan-turing-lab3/
├── README.md
├── docs/
│   ├── analisis.pdf        <- el mismo documento que sube a Canvas
│   ├── uml.png             <- diagrama de clases (png o pdf)
│   └── uml.mdj             <- editable del diagrama, si lo tiene
├── src/
│   └── *.java              <- todo el código fuente
└── bin/
    └── *.class             <- los archivos compilados (pueden estar ignorados)
```

```bash
mkdir docs src bin
```

**Git no versiona carpetas vacías.** Si alguna carpeta va a quedar sin archivos al momento del primer commit, agregue dentro un archivo `.gitkeep` vacío:

```bash
touch docs/.gitkeep src/.gitkeep bin/.gitkeep
```

#### Qué va en `docs/`

- **El análisis en PDF**, exactamente el mismo documento que se sube a Canvas.
- **El diagrama de clases (UML)** exportado como `png` o `pdf`.
- **El archivo editable del diagrama**, si su herramienta genera uno: `.mdj` de StarUML, `.drawio`, `.vpp`, etc. Si trabajó a mano o en una herramienta que no exporta editable, este archivo no es necesario.

#### Qué va en `README.md`

En la raíz de la rama, no dentro de `docs/`. Es lo primero que se ve al abrir la entrega:

````markdown
# Laboratorio 3 - Título de la tarea

**Nombre completo:** Alan Mathison Turing
**Carné:** 12345

## Descripción
Explicación de la tarea: qué problema resuelve el programa, qué clases lo
componen y qué decisiones de diseño se tomaron.

## Cómo ejecutar
```bash
javac -d bin src/*.java
java -cp bin Main
```
````

### 4. Subir la rama

```bash
git add .
git commit -m "Lab 3 - Alan Turing 12345"
git push -u origin 12345-alan-turing-lab3
```

Subir la rama todavía no es entregar: falta el Pull Request del paso 5.

Si `bin/` no aparece en GitHub después del push, es porque un `.gitignore` está bloqueando los `.class`. Verifíquelo así:

```bash
git check-ignore -v bin/Main.class
git add -f bin
```

### 5. Abrir el Pull Request

> **El Pull Request es la entrega.** Sin PR, o con el PR mal hecho, la nota es **0**. Subir la rama no es entregar: la entrega se registra cuando el PR existe, apunta a donde debe y está bien identificado.

El PR va **desde su rama hacia `main`**, dentro del repositorio del curso.

| Campo | Valor |
|---|---|
| Repositorio | el del curso, no un fork |
| `base` (destino) | `main` |
| `compare` (origen) | su rama, por ejemplo `12345-alan-turing-lab3` |
| Título | **la misma nomenclatura de la rama**: `12345-alan-turing-lab3` |

Desde la web: GitHub → pestaña **Pull requests** → **New pull request** → seleccione `base: main` y `compare: su-rama` → **Create pull request**.

En la descripción del PR van, como mínimo, **nombre completo, carné y qué entrega es**.

**No cierre ni haga merge de su propio PR.** El PR se queda abierto: es lo que se revisa y califica. Tampoco suba commits nuevos después de la fecha de entrega, porque el PR queda marcado con la fecha del último commit.

#### Errores que dejan la entrega en 0

- No abrir el PR, o abrirlo después de la fecha límite.
- Abrir el PR desde un fork personal en lugar del repositorio del curso.
- Escoger mal el `base`: apuntar a la rama de otro compañero en vez de a `main`.
- Escoger mal el `compare`: abrir el PR desde `main` o desde la rama de alguien más.
- Título que no respeta la nomenclatura `carnet-nombre-apellido-tarea`.
- Abrir el PR sin haber hecho `push`, o con archivos faltando en la rama.
- Hacer merge del PR por su cuenta.

Como las ramas de entrega son huérfanas, el PR muestra todos los archivos como nuevos. Eso es lo esperado.

### 6. Antes de entregar

- [ ] La rama sigue la nomenclatura `carnet-nombre-apellido-tarea`.
- [ ] La rama contiene **solo** su entrega: nada de las carpetas de clase ni de entregas anteriores.
- [ ] Existen las tres carpetas: `docs`, `src` y `bin`.
- [ ] `docs/` tiene el PDF del análisis y el UML.
- [ ] El `README.md` tiene nombre completo, carné y la explicación de la tarea.
- [ ] El código compila con `javac -d bin src/*.java` sin errores.
- [ ] El `push` se hizo a la rama correcta y los archivos se ven en GitHub.
- [ ] **El Pull Request está abierto**, con `base: main` y `compare:` su rama.
- [ ] **El título del PR usa la misma nomenclatura de la rama.**
- [ ] La descripción del PR tiene nombre completo, carné y la tarea que entrega.
- [ ] El PR quedó abierto, sin merge y sin cerrar.

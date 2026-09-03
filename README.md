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
| `06-Excepciones` | Manejo, propagación (`throws`, checked y unchecked) y excepciones propias |
| `07-Palatino-Ultra` | `ArrayList`: agregar y eliminar equipos en tiempo de ejecución |
| `08-Notas` | Matriz multidimensional de `ArrayList`: registro y consulta de notas |

### Cómo compilar y ejecutar cualquier ejemplo

Desde la carpeta del proyecto:

```bash
javac -d bin src/*.java
java -cp bin Main
```

### Cómo traer los ejemplos nuevos de clase

El repositorio del curso crece cada semana. Para que su copia local tenga los ejemplos nuevos, se hace `pull` de la rama `main` del repositorio del curso, que se conoce como **`upstream`**.

Primero, una sola vez, se registra ese repositorio como remoto:

```bash
# Ver que remotos tiene configurados
git remote -v

# Registrar el repositorio del curso como upstream (solo la primera vez)
git remote add upstream git@github.com:menene/cc2008-2026-02-30.git
```

De ahí en adelante, **antes de empezar cualquier entrega**:

```bash
git checkout main
git pull upstream main
```

Eso baja los ejemplos nuevos sin tocar sus entregas. Si `git remote add` responde `error: remote upstream already exists`, ya estaba configurado y puede seguir directo con el `git pull upstream main`.

> Si clonó directamente el repositorio del curso, su `origin` **ya es** el repositorio del curso y `git pull origin main` hace exactamente lo mismo. El nombre `upstream` se usa para dejar claro de dónde viene el código de clase.

---

## Entrega de tareas y laboratorios

Para cada entrega **el profesor crea una rama por estudiante y por ejercicio**. Esa rama llega vacía y es el **destino** de la entrega. El estudiante no la crea ni trabaja directamente sobre ella: crea a partir de ella su propia **rama de trabajo**, y desde ahí abre el **Pull Request**.

> **`main` no se toca nunca.** No se commitea en `main`, no se hace push a `main` y **ningún Pull Request va hacia `main`**. `main` es solo la referencia de los ejemplos de clase.

Las dos ramas de cada entrega:

| Rama | Quién la crea | Para qué sirve |
|---|---|---|
| `26031-alan-turing-lab3` | **el profesor** (script) | Rama vacía. Es el `base` del PR: el destino de la entrega. |
| `26031-alan-turing-lab3-entrega` | **el estudiante** | Rama de trabajo. Lleva el código y es el `compare` del PR. |

### 1. Nomenclatura de las ramas

La rama que crea el profesor sigue este patrón:

```
carnet-nombre-apellido-tarea
```

| Rama del profesor (`base`) | Rama del estudiante (`compare`) | Entrega |
|---|---|---|
| `26031-alan-turing-lab3` | `26031-alan-turing-lab3-entrega` | Laboratorio 3 |
| `26031-alan-turing-hdt1` | `26031-alan-turing-hdt1-entrega` | Hoja de trabajo 1 |
| `26031-alan-turing-pro1` | `26031-alan-turing-pro1-entrega` | Proyecto |

La rama de trabajo es **exactamente el nombre de la rama del profesor más el sufijo `-entrega`**. Todo en minúsculas, sin tildes, sin espacios y separado con guiones.

### 2. Crear la rama de trabajo

La rama que creó el profesor es una rama *huérfana*: nace sin historial y sin archivos, es una hoja en blanco y no una copia de `main`. Al crear la rama de trabajo a partir de ella, la carpeta queda vacía y lista para la entrega.

```bash
# Traer las ramas nuevas que creo el profesor
git fetch origin

# Pararse en la rama que le asignaron (llega vacia)
git checkout 26031-alan-turing-lab3

# Crear SU rama de trabajo a partir de ella
git checkout -b 26031-alan-turing-lab3-entrega
```

Si `git checkout` responde `error: pathspec ... did not match any file(s) known to git`, la rama todavía no existe o el nombre está mal escrito: revise el nombre exacto en GitHub antes de seguir.

**Todos los commits van en la rama `-entrega`.** La rama del profesor se queda vacía: es el destino del PR, no el lugar de trabajo.

### 3. Estructura obligatoria

Esta es la estructura que debe tener la rama `-entrega`, en su raíz:

```
26031-alan-turing-lab3-entrega/
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
**Carné:** 26031

## Descripción
Explicación de la tarea: qué problema resuelve el programa, qué clases lo
componen y qué decisiones de diseño se tomaron.

## Cómo ejecutar
```bash
javac -d bin src/*.java
java -cp bin Main
```
````

### 4. Subir la rama de trabajo

El push va **a su rama `-entrega`**, nunca a `main` ni a la rama vacía del profesor:

```bash
# Confirme en que rama esta parado antes de hacer push
git branch --show-current      # debe decir 26031-alan-turing-lab3-entrega

git add .
git commit -m "Lab 3 - Alan Turing 26031"
git push -u origin 26031-alan-turing-lab3-entrega
```

Si `git branch --show-current` dice `main` o dice el nombre de la rama del profesor sin el sufijo `-entrega`, **no haga push**: regrese al paso 2 y párese en la rama correcta.

Subir la rama todavía no es entregar: falta el Pull Request del paso 5.

Si `bin/` no aparece en GitHub después del push, es porque un `.gitignore` está bloqueando los `.class`. Verifíquelo así:

```bash
git check-ignore -v bin/Main.class
git add -f bin
```

### 5. Abrir el Pull Request

> **El Pull Request es la entrega.** Sin PR, o con el PR mal hecho, la nota es **0**. Subir la rama no es entregar: la entrega se registra cuando el PR existe, apunta a donde debe y está bien identificado.

El PR va **desde su rama `-entrega` hacia la rama que creó el profesor**, dentro del repositorio del curso. **Nunca hacia `main`.**

| Campo | Valor |
|---|---|
| Repositorio | el del curso, no un fork |
| `base` (destino) | la rama que creó el profesor: `26031-alan-turing-lab3` — **NUNCA `main`** |
| `compare` (origen) | su rama de trabajo: `26031-alan-turing-lab3-entrega` |
| Título | **el nombre de la rama del profesor**: `26031-alan-turing-lab3` |

Desde la web: GitHub → pestaña **Pull requests** → **New pull request** → seleccione `base: 26031-alan-turing-lab3` y `compare: 26031-alan-turing-lab3-entrega` → **Create pull request**.

> GitHub propone `base: main` por defecto. **Hay que cambiarlo a mano.** Antes de darle a *Create pull request*, lea la línea que aparece arriba del formulario: debe decir `base: 26031-alan-turing-lab3 ← compare: 26031-alan-turing-lab3-entrega`. Si ahí aparece `main`, el PR está mal y la nota es 0.

En la descripción del PR van, como mínimo, **nombre completo, carné y qué entrega es**.

**No cierre ni haga merge de su propio PR.** El PR se queda abierto: es lo que se revisa y califica. Tampoco suba commits nuevos después de la fecha de entrega, porque el PR queda marcado con la fecha del último commit.

#### Errores que dejan la entrega en 0

- No abrir el PR, o abrirlo después de la fecha límite.
- Abrir el PR desde un fork personal en lugar del repositorio del curso.
- **Escoger mal el `base`: apuntar a `main`** o a la rama de otro compañero, en vez de a la rama que le creó el profesor.
- Escoger mal el `compare`: abrir el PR desde `main` o desde la rama de alguien más.
- Commitear el trabajo directamente en `main` o en la rama del profesor en vez de en la rama `-entrega`.
- Título que no respeta la nomenclatura `carnet-nombre-apellido-tarea`.
- Abrir el PR sin haber hecho `push`, o con archivos faltando en la rama.
- Hacer merge del PR por su cuenta, o hacer merge de cualquier cosa hacia `main`.

Como la rama del profesor está vacía, el PR muestra todos los archivos como nuevos. Eso es lo esperado.

### 6. Antes de entregar

- [ ] Hice `git pull upstream main` antes de empezar, para tener los ejemplos de clase al día.
- [ ] Mi rama de trabajo se llama igual que la rama del profesor **más el sufijo `-entrega`**.
- [ ] **No hay ni un commit mío en `main`** ni en la rama vacía del profesor.
- [ ] La rama contiene **solo** su entrega: nada de las carpetas de clase ni de entregas anteriores.
- [ ] Existen las tres carpetas: `docs`, `src` y `bin`.
- [ ] `docs/` tiene el PDF del análisis y el UML.
- [ ] El `README.md` tiene nombre completo, carné y la explicación de la tarea.
- [ ] El código compila con `javac -d bin src/*.java` sin errores.
- [ ] El `push` se hizo a la rama `-entrega` y los archivos se ven en GitHub.
- [ ] **El Pull Request está abierto**, con `base:` la rama del profesor y `compare:` su rama `-entrega`.
- [ ] **El `base` del PR NO es `main`.** Lo verifiqué leyendo la línea de arriba del PR.
- [ ] **El título del PR usa la misma nomenclatura de la rama del profesor.**
- [ ] La descripción del PR tiene nombre completo, carné y la tarea que entrega.
- [ ] El PR quedó abierto, sin merge y sin cerrar.

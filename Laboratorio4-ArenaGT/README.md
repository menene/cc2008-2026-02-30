# ArenaGT · Laboratorio No. 4 de Polimorfismo

Aplicación de consola en Java para administrar una copa entre empresas. Requiere un JDK 17 o posterior. Los datos se cargan de nuevo en cada ejecución.

## Compilar y ejecutar

Abre esta carpeta en VS Code y abre una terminal PowerShell en la raíz del proyecto. Ejecuta los siguientes comandos.

```powershell
New-Item -ItemType Directory -Force bin | Out-Null
javac --release 17 -encoding UTF-8 -d bin (Get-ChildItem src -Recurse -Filter *.java).FullName
java -cp bin arenagt.presentacion.Main
```

Si Windows tarda en iniciar Java desde el acceso del sistema, puedes usar la ruta del JDK instalado anteponiendo su directorio a la ruta de la terminal actual y repetir los comandos.

```powershell
$env:Path = 'C:\Program Files\Java\jdk-25.0.3\bin;' + $env:Path
```

## Probar el menú

La opción **6** muestra a Luna con 2 puntos y luego a Faro, Río y Sol con 1 cada uno. La opción **7** muestra E1, X1, E2 y E3. E1 terminó 2–2 en fútbol sala y E2 terminó 78–74 en baloncesto. La clínica X1 comparte fecha y hora con E1 en otra sede.

Para probar una operación nueva, elige **4**, escribe **E4**, fecha **2026-11-14**, hora **11** y sede **Arena B**. Con la opción **5**, intenta registrar **70** y **70**. El menú explica el rechazo y E4 sigue programado. Repite con **72** y **70**. Sol suma dos puntos y Río uno. Consulta la tabla con **6** y sal con **0**.

## Ejecutar las pruebas

Después de compilar la aplicación, ejecuta en la misma terminal:

```powershell
javac --release 17 -encoding UTF-8 -cp bin -d bin pruebas/Pruebas.java
java -cp bin Pruebas
```

Cada fila registra entrada, resultado esperado y resultado obtenido. Una diferencia detiene la suite con un error. La última línea de una ejecución correcta indica `Total aprobado: 38`. La suite usa copas de prueba independientes e incluye recorridos del menú real.

## Archivos

- `src/arenagt/dominio/` contiene las dos interfaces, los eventos, sus estados, los equipos y la copa. Cada deporte implementa su validación y reparto de puntos. El orden del calendario vive en `Programable.compareTo` y el de la clasificación en `Equipo.compareTo`.
- `src/arenagt/presentacion/Main.java` contiene la carga inicial y el menú.
- `bin/` contiene las clases compiladas y `pruebas/` el verificador ejecutable.
- `docs/Laboratorio No. 4.pdf` es la copia del análisis y UML original. `docs/ArenaGT - Entrega con pruebas.pdf` reúne ese documento y la evidencia. `docs/Pruebas.tsv` conserva la salida de la suite.

La implementación conserva los contratos públicos y los estados del UML. Los auxiliares internos centralizan la validación de textos, el alta en ambos índices y la lectura del menú. El método privado `Copa.validarId` devuelve la clave normalizada para reutilizarla al construir el evento. Los códigos, identificadores y sedes distinguen mayúsculas después de quitar espacios exteriores.

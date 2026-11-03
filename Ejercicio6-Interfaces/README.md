# Ejercicio 6 — Polimorfismo vía Interfaces

**Nombre completo:** Raúl Escobar Godínez
**Carné:** 26429

**Análisis y diseño con UML:** [Documento PDF](docs/Ejercicio%20No.%206%20.pdf)

Proyecto Java de consola basado en el PDF original y en las tablas y los cuatro UML de `Ejercicio_6_Analisis_y_Diseno.docx`. Incluye diez integraciones, MVC, herencia, contratos por capacidad, sobrecarga y ordenamiento con `Comparable`.

Las operaciones son **simuladas**. No se conectan APIs reales, no se transfieren fondos y los XML no tienen validez fiscal. Los datos se mantienen en memoria durante la sesión. El diseño no define un historial de pagos: un reintegro valida capacidad, datos y disponibilidad; no verifica un cobro previo ni saldos.

## Abrir y ejecutar en VS Code

1. Descargar o clonar la rama de entrega y abrir la carpeta `Ejercicio6-Interfaces` con **Archivo → Abrir carpeta**.
2. Tener instalado un **JDK 17 o posterior**, con `java` y `javac` disponibles, y la extensión **Extension Pack for Java** de Microsoft (recomendada por el proyecto).
3. Abrir `src/vista/Principal.java` y pulsar **Run** sobre `main`, o usar F5 con la configuración **Ejercicio 6 - Consola**.
4. Escribir las opciones en la terminal integrada. Usar `0` para salir.

Alternativa desde PowerShell, dentro de la carpeta del proyecto:

```powershell
.\ejecutar.ps1
```

Para compilar o probar por separado:

```powershell
.\compilar.ps1
.\probar.ps1
```

Si la política local impide ejecutar scripts, se puede usar directamente:

```powershell
New-Item -ItemType Directory -Path bin -Force | Out-Null
$fuentesJava = Get-ChildItem src,tests -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -encoding UTF-8 --release 17 -Xlint:all -d bin $fuentesJava
java '-Dfile.encoding=UTF-8' -cp bin vista.Principal
java '-Dfile.encoding=UTF-8' -cp bin pruebas.PruebasIntegraciones
```

Las pruebas Java terminan con código 0 si pasan; no imprimen mensajes, para mantener toda salida Java en `Principal`. `probar.ps1` muestra la confirmación. No se requiere Maven, Gradle ni bibliotecas externas.

## Organización

```text
src/
  modelo/
    Auditable.java                Consultable.java
    Transaccional.java            Documentable.java
    IntegracionAPI.java           EstadoResultado.java
    ResultadoOperacion.java       CatalogoIntegraciones.java
    MotorCheckout.java            PasarelaTarjeta.java
    PasarelaTransferencia.java    BilleteraDigital.java
    ProveedorLogistico.java       ServicioRastreo.java
    CertificadorFEL.java
  controlador/ControladorIntegraciones.java
  inicializacion/InicializadorIntegraciones.java
  vista/Principal.java
tests/pruebas/PruebasIntegraciones.java
.vscode/                         Configuración de VS Code
docs/                            Precisiones, validación y ejecución de ejemplo
```

`CatalogoIntegraciones` posee la única `List<IntegracionAPI>`. `listar()` devuelve una envoltura de lectura de esa misma lista, sin copiarla. La vista filtra activas durante el recorrido; el ordenamiento modifica el catálogo completo. Las APIs comparten configuración encapsulada y solo implementan sus capacidades reales.

## Menú

| Opción | Función | Ejemplo |
|---|---|---|
| 1 | Listar integraciones activas y conexión | Muestra diez, con LOG-002 desconectada |
| 2 | Buscar configuración | PAG-001 |
| 3 | Ordenar catálogo completo por latencia | PAG-004 aparece primero, con 75 ms |
| 4 | Reintegrar | LOG-001, 25, R-001 → IGNORADA; PAG-001 → EXITOSA |
| 5 | Cobrar | PAG-003, 25.50, C-001 |
| 6 | Consultar envío | CON-001, ENV-001 |
| 7 | Generar guía o XML FEL | LOG-001 o FEL-001, DOC-001 |
| 0 | Salir | Finaliza la sesión |

Usar identificadores tal como aparecen en el catálogo y punto decimal para los montos. Una entrada numérica incorrecta cancela esa operación y vuelve al menú. Un fin de entrada también cierra el programa de manera controlada.

## Correspondencia con el diseño

Se mantienen los ocho parámetros de los constructores, las seis subclases, las cuatro interfaces propias, los tres estados de resultado, las dos sobrecargas de `solicitarReintegro` y los nombres completos de las tablas del Word. Las diez instancias reproducen identificadores, nombres, latencias y estados de su tabla 1.5.

Las precisiones necesarias para conectar la vista y exponer todas las capacidades desde el controlador están documentadas en [docs/PRECISIONES-DISENO.md](docs/PRECISIONES-DISENO.md), con el fragmento UML complementario. El Word original no fue modificado.

Las clases Java contienen encabezados y comentarios. Solo `Principal` utiliza `Scanner` y salida a consola. El ciclo del menú tiene condición explícita de salida. Los setters de configuración rechazan datos inválidos; las operaciones del motor responden con `FALLIDA` o `IGNORADA` según el caso y aíslan fallos de los proveedores.

Para añadir un proveedor, crear una subclase de `IntegracionAPI`, implementar los contratos necesarios y registrarla mediante `ControladorIntegraciones.registrar` o `CatalogoIntegraciones.agregar`. La prueba `UltimaMilla` demuestra que no hace falta cambiar `MotorCheckout`.

Esta entrega está en la rama `26429-raul-escobar-godinez-ejercicio6-entrega`. El PR usa provisionalmente `26429` como destino porque aún no existe la rama específica del ejercicio. El proyecto se conserva en esta subcarpeta para no alterar las entregas anteriores de `26429`.

$ErrorActionPreference = 'Stop'
Push-Location $PSScriptRoot
try {
    New-Item -ItemType Directory -Path bin -Force | Out-Null
    $fuentesJava = Get-ChildItem src,tests -Filter *.java -Recurse | ForEach-Object { $_.FullName }
    & javac -encoding UTF-8 --release 17 -Xlint:all -d bin $fuentesJava
    if ($LASTEXITCODE -ne 0) { throw 'No se pudo compilar el proyecto.' }
    Write-Host 'Compilación correcta.'
} finally { Pop-Location }

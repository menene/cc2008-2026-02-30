$ErrorActionPreference = 'Stop'
& "$PSScriptRoot/compilar.ps1"
& java '-Dfile.encoding=UTF-8' -cp "$PSScriptRoot/bin" pruebas.PruebasIntegraciones
if ($LASTEXITCODE -ne 0) { throw 'Falló una prueba.' }
Write-Host 'Todas las pruebas de dominio pasaron.'

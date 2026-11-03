$ErrorActionPreference = 'Stop'
& "$PSScriptRoot/compilar.ps1"
& java '-Dfile.encoding=UTF-8' -cp "$PSScriptRoot/bin" vista.Principal
if ($LASTEXITCODE -ne 0) { throw 'La ejecución terminó con error.' }

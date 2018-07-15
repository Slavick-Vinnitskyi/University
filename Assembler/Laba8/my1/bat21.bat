@echo off
ml.exe /c /coff /Cp Lib21.asm
link /DLL /DEF:def.def /NOENTRY /SUBSYSTEM:WINDOWS  /LIBPATH:c:\masm32\lib  Lib1.obj
ml.exe /c /coff /Cp Lab81.asm
link /SUBSYSTEM:WINDOWS Lab81.obj
pause

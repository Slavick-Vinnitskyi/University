@echo off
ml.exe /c /coff /Cp MyLib1.asm
link /DLL /DEF:def.def /SUBSYSTEM:WINDOWS  /LIBPATH:D:\masm32\lib  MyLib1.obj
ml.exe /c /coff /Cp Laba8-1.asm
link /SUBSYSTEM:WINDOWS Laba8-1.obj
pause

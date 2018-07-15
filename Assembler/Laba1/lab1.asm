.386
.model flat, stdcall
option casemap:none

include \masm32\include\windows.inc
include \masm32\include\user32.inc
include \masm32\include\kernel32.inc
include \masm32\include\masm32.inc

includelib \masm32\lib\user32.lib
includelib \masm32\lib\kernel32.lib
includelib \masm32\lib\masm32.lib

.data
   birth db "30121998",0

Num1 db 30 
Num2 db -30

Num3 dw 30 
Num4 dw -30
Num5 dw 3012 
Num6 dw -3012

Num7 dd 30 
Num8 dd -30
Num9 dd 3012 
Num10 dd -3012
Num11 dd 30121998
Num12 dd -2071999

Num13 dq 30 
Num14 dq -30
Num15 dq 3012 
Num16 dq -3012
Num17 dq 30121998
Num18 dq -30121998

Num19 db 0.004
Num20 db -0.004

Num21 dq 0.47
Num22 dq -0.47

Num23 dt 47050,921
Num24 dt -47050,921

    Caption db "Laba1",0

stringD db 64 dup(?)
stringE db 64 dup(?)
stringF db 64 dup(?)

Text db 128 dup(?)
fmt db "Check:",13,
        "A = %d",13,
        "B = %d",13,
        "C = %d",13,
        "D = %s",13,
        "E = %s",13,
        "F = %s",0
        
       

    D dq 0.004
    E dq 0.47
    F dq 47050.921
    


.code
main:
    invoke FloatToStr, D, addr stringD
    invoke FloatToStr, E, addr stringE
    invoke FloatToStr, F, addr stringF
   
    invoke wsprintf, addr Text, addr fmt, Num7, Num9, Num11, addr stringD, addr stringE, addr stringF
    invoke MessageBox, 0, ADDR Text, ADDR Caption, 0
    invoke ExitProcess, 0	
end main

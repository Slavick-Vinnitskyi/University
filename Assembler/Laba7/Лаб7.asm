.386
.model flat, stdcall
option casemap:none 

include \masm32\include\user32.inc
include \masm32\include\kernel32.inc
include \masm32\include\masm32.inc
include \masm32\include\fpu.inc 

includelib \masm32\lib\user32.lib
includelib \masm32\lib\kernel32.lib
includelib \masm32\lib\masm32.lib
includelib \masm32\lib\fpu.lib

PUBLIC argA,four,argB
extrn  ThirdProc@0:near 

.data
  
	argA dd  1.0, 1.5, 2.0, 5.0, 5.0
    argB dd  1.0, 2.0, 3.0, 4.0, 4.0
    argC dd  1.5, 2.0, 3.0, 5.0, 3.0
    argD dd  2.0, 2.5, 4.0, 4.0, 4.0
    v1 dd 0
    v2 dd 0
    four dd 4.0
    miunsTwo dd -2.0 
    vos2 dd 82.0
    result dt ?
    Caption db "Lab06",0
    Text db 128 dup (?)
    format db "result %d = %s",0
    buffer db ?

.code
start:
    mov edi, 0
@beg:
    finit
    call ThirdProc@0

    push argD[edi*4]
    push vos2
   	call SecondProc 

   	mov eax, argC[edi*4]
   	mov ebx, miunsTwo
    call FirstProc

    mov argC[edi*4], eax

    fld argC[edi*4]

    fsub argD[edi*4]
    
    fdiv argA[edi*4] 

    fstp result 
    inc edi

    invoke FpuFLtoA, offset result, 8, offset buffer, SRC1_REAL or SRC2_DIMM
    invoke wsprintf, ADDR Text, ADDR format, edi, ADDR buffer
    invoke MessageBoxA, 0, ADDR Text, ADDR Caption, 0

    cmp edi, 5
    jne @beg

    invoke ExitProcess, 0
    
FirstProc PROC

	LOCAL varC, min2
	mov varC, eax
	mov min2, ebx

	fld varC 
	fmul min2 
	fstp varC

	mov eax, varC

	ret

FirstProc ENDP

SecondProc PROC

	push ebp
	mov ebp, esp
	mov eax, [ebp+8]
	mov v1,eax
	mov ebx, [ebp+12]
	mov v2,ebx
	pop ebp

	fld v2
	fmul v1

	fstp argD[edi*4]

	ret 8

SecondProc ENDP

;ThirdProc proc 
	;fld argA[edi*4] 
	;fdiv four 
	;fsub argB[edi*4]
	;fptan 
	;fxch 
	;fstp argA[edi*4] 
	;ret
;ThirdProc endp

end start

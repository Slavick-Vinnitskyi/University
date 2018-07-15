.386
.model flat,stdcall
option casemap:none
include c:\masm32\include\masm32rt.inc    


.data
	var4 dd 4.0
	var2 dd 2.0
	var123 dd 123.0
	format db "F1 = %s",13,10,"F2 = %s",13,10,"F3 = %s",13,10,"F4 = %s",13,10,"F5 = %s",0
	strMessage	db "Laboratornaya8",0
.data?
	result dt ?
	inner_text db 512 dup (?)
	
.code
Dllmain proc hInstDLL:HINSTANCE, reason:DWORD, reserved1:DWORD
        mov  eax,TRUE
        ret
Dllmain Endp
myFunc proc var_a:DWORD,var_b:DWORD,var_c:DWORD,var_d:DWORD
	;	finit
	        ; подготовка стека сопроцессора для нормальной работы

       fld var_b; записываем b
	fld var4 ; записываем b4
	fmul ;4*b
	fld var_d; записываем d
	fld var123; записываем 123
	fmul;d*123
	fsqrt;sqrt(d*123)
	fsub;4b-sqrt(d*123)
	fld var_c;записываем c
	fadd ; c+ 4b-sqrt(d*123)
	fld1
	fld var_a;записываем a
	fld var2 
	fdiv;a/2
	fsub;1-a/2

	fdiv;числитель/делитель
	fstp result

	invoke FloatToStr, result, addr buffer
	invoke MessageBoxA, 0, addr buffer, addr strMessage, 0

	ret
myFunc endp
End Dllmain
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

fld cc[eax] ;записть в стек
	fld doub 
	
	fmul;умножение st0 and st1 , сохран в st0
	fld d[eax];вторая часть числителя
	fld eightwo
	fmul;умножение
	fsub; заканчиваем числитель
	fld a[eax];записуем в стек переменные знаменателя
	fld four
	fdiv;делим
	fld b[eax]
	fsub
	fptan;получем тангенс | берет tg st0, записывает в st1, а в st0 записуется 1.0
	
	fstp ;убираем 1
	
	fdiv;заканчиваем выражение
	
	;fstp result;запись в результат

	invoke FloatToStr, result, addr buffer
	invoke MessageBoxA, 0, addr buffer, addr strMessage, 0

	ret
myFunc endp
End Dllmain
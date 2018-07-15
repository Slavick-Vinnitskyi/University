.386					
.model flat, stdcall	
option casemap: none
  
include c:\masm32\include\masm32rt.inc    

.data


	a dq  1.0, 1.5, 2.0, 5.0, 5.0
	b dq  1.0, 2.0, 3.0, 4.0, 4.0
	cc dq 1.5, 2.0, 3.0, 5.0, 3.0
	d dq  2.0, 2.5, 4.0, 4.0, 4.0
	doub dq -2.0
	eightwo dq 82.0
	four dq 4.0
	result dt 1.0
	;result dt 1.0
format db "F = %s",13,10,"F = %s",13,10,"F = %s",13,10,"F = %s",13,10,"F = %s",0
	
		MsgBoxCaptionSuc db "Main", 0
	MsgBoxText     db "A=%hd",0 
	string db 512 DUP(?)
	
	.code
	
	
	start:


	xor eax,eax

	calculate:
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
	
	add eax,8
	cmp eax,40
	jne calculate
	je enderer
	
	enderer:
	
	;invoke wsprintf,addr string,addr MsgBoxText,eax
		
		invoke wsprintf,addr string,addr format,real10$(st(4)),real10$(st(3)),real10$(st(2)),real10$(st(1)),real10$(st(0))
	invoke MessageBoxA, 0, addr string, addr MsgBoxCaptionSuc, 0
	invoke ExitProcess, 0
	end start 
	
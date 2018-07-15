.386
.model flat,stdcall
option casemap:none
include		c:\masm32\include\masm32rt.inc   
Include 	c:\masm32\fpulib\fpu.inc
IncludeLib  c:\masm32\fpulib\fpu.lib
.data
  four dd 4.0
  doub dd -2.0
  eightwo dd 82.0
  format db "Result = %s",0
  strMessage  db "Laba8",0
.data?
  result dt ?
  buffer db 15 dup (?)
  res2 dq ?
  inner_text db 512 dup (?)
.code
myFunc proc var_a:DWORD,var_b:DWORD,var_c:DWORD,var_d:DWORD
    ;finit подготовка стека сопроцессора для нормальной работы
	fld argC ;записть в стек
	fld doub 
	fmul;умножение st0 and st1 , сохран в st0
	fld argD;вторая часть числителя
	fld eightwo
	fmul;умножение
	fsub; заканчиваем числитель
	fld argA;записуем в стек переменные знаменателя
	fld four
	fdiv;делим             
	fld argB
	fsub
	fptan;получем тангенс | берет tg st0, записывает в st1, а в st0 записуется 1.0
	fstp  res2;убираем 1	
	fdiv;заканчиваем выражение	
	fstp result;запись в результат
invoke FpuFLtoA, ADDR result,10, ADDR buffer, SRC1_REAL or SRC2_DIMM
invoke wsprintf,addr inner_text, addr format, offset buffer
invoke MessageBoxA, 0, addr inner_text, addr strMessage, 0
  
  ret
myFunc endp
End

.386	; Enable 80386+ instruction set
.model flat, stdcall
option casemap: none
  
include c:\masm32\include\masm32rt.inc    

.data
	promt db "Enter password: ", 0
	chars_read dd ?
	chars_written dd ?
	entered_password db 20 dup(?)
	password db '1234'
	error_mes db "Error, password incorrect", 0
	st_data_name db "Vinnitskyi Viacheslav Andrievich", 0
	st_data_date db "Birhday : 30.12.1998",0
	st_data_student_book db "Number - 6402", 0
	title_data db "Info", 0
	title_error db "Error", 0
	
.code


	OutputInfo macro str_d, str_t ; макрос данных вывода 
		invoke MessageBox, 0, str_d,  str_t, 0 ;; макрос данных вывода 
	endm
	  macro str_xor, num
		local cmp_m 
		
		xor ecx, ecx ; ecx = 0
	cmp_m:
		mov dl, entered_password[ecx]  ;; Строка не будет видна после подстановки макроса 
		xor dl, num ; сравнение 
		mov entered_password[ecx], dl
		inc ecx
		cmp ecx, lengthof password
		jne cmp_m
	endm
	
	MacroCMP macro str1, str2
		local string_cmp ; 
		xor ecx, ecx
	string_cmp:
		mov dl, str1[ecx] ; load dl with char from str1
		mov dh, str2[ecx] ; load dh with char from str2
		cmp dl, dh ;; Строка не будет видна после подстановки макроса 
		jne errorer ;; 
		inc ecx
		cmp ecx, lengthof password
		jne string_cmp
	endm
start:
	
	invoke AllocConsole
	invoke SetConsoleOutputCP, 1251
	invoke GetStdHandle, STD_INPUT_HANDLE
	mov ebx, eax
	invoke GetStdHandle, STD_OUTPUT_HANDLE
	invoke WriteConsoleA, eax,  addr promt, sizeof promt, addr chars_written, 0
	invoke ReadConsoleA, ebx,  addr entered_password, sizeof entered_password, addr chars_read, 0
	MacroXor entered_password, 5
	MacroCMP  entered_password, password
	OutputInfo addr st_data_name, addr title_data
	OutputInfo addr st_data_date, addr title_data
	OutputInfo addr st_data_student_book, addr title_data
	jmp @end
errorer:
	OutputInfo addr error_mes, addr title_error
@end:
	invoke ExitProcess, 0
end start

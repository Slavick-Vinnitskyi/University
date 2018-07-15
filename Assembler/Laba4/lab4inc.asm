
.386	; Enable 80386+ instruction set
.model flat, stdcall
option casemap: none
  
include c:\masm32\include\masm32rt.inc    

include lab4inc.inc
.data
	promt db "Enter password: ", 0
	chars_read dd ?
	chars_written dd ?
	entered_password db 20 dup(?)
	password db '1234'
	error_mes db "Error, password incorrect", 0
	st_data_name db "Vinnitskyi Viacheslav Andrievich", 0
	st_data_date db "Birthday : 30.12.1998",0
	st_data_student_book db "Number in grade book - 6402", 0
	title_data db "Info", 0
	title_error db "Error", 0
	
.code
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

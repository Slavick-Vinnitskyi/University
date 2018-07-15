.386					
.model flat, stdcall	
option casemap: none
  
include c:\masm32\include\masm32rt.inc    


.data
hConsoleInput DWORD ?			
hConsoleOutput DWORD ?
	askerer db "Password:"
	chars_read db 0
	chars_written dd ?
	entered_password db 30 dup(?)
	error_mes db "Password incorrect", 0
	st_data db "Vinnitskyi Vyacheslav Andrievich",13,10,"Birthday: 30.12.1998",13,10,"Number in grade book:6402", 0
	password db '4761'
	probel db 13, 10	
	MsgBoxCaptionSuc db "Main", 0
	MsgBoxCaptionErr db "Error",0
.code

start:
	invoke AllocConsole
	invoke GetStdHandle, STD_INPUT_HANDLE	
mov hConsoleInput, EAX			

invoke GetStdHandle, STD_OUTPUT_HANDLE	
mov hConsoleOutput, EAX	
	invoke CharToOem, ADDR askerer, ADDR askerer
	invoke WriteConsoleA, hConsoleOutput,  addr askerer, sizeof askerer, addr chars_written, 0
	invoke ReadConsoleA, hConsoleInput,  addr entered_password, sizeof entered_password, addr chars_read, 0
	
invoke WriteConsoleA, hConsoleOutput, ADDR probel, SIZEOF probel, ADDR chars_written, 0


sub chars_read, 2
cmp chars_read, 4
jne errorer

mov ebx, 0; обнуление регистра

mov dl, 5
jmp chipherer;шифрование

chipherer:
xor entered_password[ebx], dl

inc ebx
cmp ebx, 4
je nullifier
jne chipherer

nullifier:
mov ebx, 0
jmp string_cmp
string_cmp:
	mov dl, entered_password[ebx]
	mov dh, password[ebx]
	cmp dl, dh
	jne errorer
	jmp increaserer



increaserer:
       inc ebx
       jmp counterere


counterere:
	cmp ebx, 4
	jne string_cmp
	invoke MessageBoxA, 0, addr st_data, addr MsgBoxCaptionSuc, 0
	jmp enderer
errorer:
	invoke MessageBoxA, 0, addr error_mes, addr MsgBoxCaptionErr, 0
enderer:
add chars_read, 30h
invoke WriteConsoleA, hConsoleOutput,  addr chars_read, sizeof chars_read, addr chars_written, 0


	invoke ExitProcess, 0
end start

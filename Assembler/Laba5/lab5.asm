
                                    
.386					
.model flat, stdcall	
option casemap: none

include \masm32\include\windows.inc 
include \masm32\include\masm32.inc
include \masm32\include\user32.inc
include \masm32\include\kernel32.inc

includelib \masm32\lib\user32.lib
includelib \masm32\lib\masm32.lib
includelib \masm32\lib\kernel32.lib   

vich macro mas1
	LOCAL chet
LOCAL finalss

         ;(-25/a + c - b*a)/(l + c*b/2);
	mov eax, -25
	mov ecx, mas1[0]
	cdq
	idiv ecx
	
	
	mov ebx, mas1[8]
	add eax, ebx
	
	
	
	mov ecx, eax
	mov eax, mas1[0]
	mov ebx, mas1[4]
	imul ebx
	jc pom

	sub ecx, eax
	
	mov eax, mas1[8]
	mov ebx, mas1[4]
	imul ebx
	jc pom
	mov ebx, ecx
	mov ecx, 2
	
	xor edx, edx
	cdq
	idiv ecx
	add eax, 1
	mov ecx, eax
	mov eax, ebx
	xor edx, edx
	cdq
	idiv ecx
	
	test eax, 1; and eax with 1
	jz chet; ZF flag if true - func chet
	mov ebx, 5
	imul eax, ebx

	mov dword ptr mas1+12, eax

	jmp finalss
	
	chet:
	
	mov ebx, 2
	cdq
	idiv ebx
	
	mov dword ptr mas1+12, eax
	
	finalss:
	endm

.data

	
	mas1 dd 5, 2, 3, ?
	mas2 dd 5, 4, -2, ?
	mas3 dd -5, -2, -3, ?
	mas4 dd -25, 2, -2, ?
	mas5 dd 25, 2, -2, ?
	MsgBoxCaptionSuc db "Main", 0
	MsgBoxCaptionE db "Error", 0
	MsgBoxTextE    db "Error", 0
	MsgBoxText2     db "(a*b/4-1)/(41-ba+c) for a=%d, b=%d, c=%d, result=%d", 0
	MsgBoxText     db "(a*b/4-1)/(41-ba+c) for a=%d, b=%d, c=%d, result=%d",13, 10,"(a*b/4-1)/(41-ba+c) for a=%d, b=%d, c=%d, result=%d",13, 10,"(a*b/4-1)/(41-ba+c) for a=%d, b=%d, c=%d, result=%d",13, 10,"(a*b/4-1)/(41-ba+c) for a=%d, b=%d, c=%d, result=%d", 0
	string db 512 DUP(?)
.code

start:
 vich mas1
 vich mas2
 vich mas3
 vich mas4
 vich mas5
	invoke wsprintf,addr string,addr MsgBoxText,mas1[0], mas1[4], mas1[8], mas1[12],mas2[0], mas2[4], mas2[8], mas2[12],mas3[0], mas3[4], mas3[8], mas3[12],mas4[0], mas4[4], mas4[8], mas4[12]
	invoke MessageBoxA, 0, addr string, addr MsgBoxCaptionSuc, 0
	invoke wsprintf,addr string,addr MsgBoxText2,mas5[0], mas5[4], mas5[8], mas5[12]
	invoke MessageBoxA, 0, addr string, addr MsgBoxCaptionSuc, 0
	invoke ExitProcess, 0
pom: 
	invoke MessageBoxA, 0, addr MsgBoxTextE, addr MsgBoxCaptionE, 0
	invoke ExitProcess, 0
end start

.386
.model flat, stdcall
option casemap :none
include c:\masm32\include\masm32rt.inc 
includelib Lib1.lib

myFunc PROTO :dword,:dword,:dword,:dword
.data
	var_a dd 1.0, 1.5, 2.0, 5.0, 5.0
	var_b dd 1.0, 2.0, 3.0, 4.0, 4.0  
	var_c dd 1.5, 2.0, 3.0, 5.0, 3.0
	var_d dd 2.0, 2.5, 4.0, 4.0, 4.0
	
.code 
start:
	xor ebx, ebx
main:
	invoke myFunc, var_a[ebx], var_b[ebx], var_c[ebx], var_d[ebx]
	add ebx, 4
	cmp ebx, 20
	jne main
	invoke ExitProcess, 0
end start

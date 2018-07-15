.386
.model flat, stdcall
option casemap :none
include c:\masm32\include\masm32rt.inc 
includelib MyLib2.lib

myFunc PROTO :dword,:dword,:dword,:dword

.data
	var_a dd 1.0,  3.0,  4.0,  5.0,  -6.0
	var_b dd 10.0, 40.0, 50.0, 75.0, -50.0  
	var_c dd 9.0,  5.0,  7.0, 15.0, 8.0
	var_d dd 8.0,  2.0,  3.0,  4.0,  5.0

	MyLib db "lib.dll",0
	MyFunction db "myFunc",0
	LibNotFoundErr db "Cannot load library",0
	ProcName db "Load Library",0
	TestFuncNotEx db "TestHello function not found",0
   .data?
   hLib dd ?                                         ; хэндл библиотеки (DLL)
   myFuncAddr dd ?                        ; адрес функции Execute
.code 
start:
mov ebx,0
	invoke LoadLibrary,addr MyLib
	.if eax==0
                invoke MessageBox,0,addr LibNotFoundErr,addr ProcName,0
		.else
                mov hLib,eax
                invoke GetProcAddress,hLib,addr MyFunction
			   .if eax==0
                        invoke MessageBox,0,addr TestFuncNotEx,addr ProcName,0
                .else
                        mov myFuncAddr,eax
loops:
		push var_d[ebx]
		push var_c[ebx]
		push var_b[ebx]
		push var_a[ebx]
		call [myFuncAddr]
		add ebx, 4
		cmp ebx, 20
		jne loops						
	.endif
	invoke FreeLibrary,hLib
	.endif
	invoke ExitProcess, 0
end start

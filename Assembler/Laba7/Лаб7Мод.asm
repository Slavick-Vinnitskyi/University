.386					
.model flat, stdcall	
option casemap: none

extrn argA:dword,four:dword,argB:dword
public  ThirdProc 

.data
.data?

.code

ThirdProc proc 
fld argA[edi*4] 
	fdiv four 
	fsub argB[edi*4]
	fptan 
	fxch 
	fstp argA[edi*4] 
	ret
ThirdProc endp
end

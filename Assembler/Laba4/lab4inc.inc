OutputInfo macro str_d, str_t ; macro of data output
		invoke MessageBox, 0, str_d,  str_t, 0 ;; macro of data output
	endm
MacroXor macro str_xor, num
	local cmp_m 
	
	xor ecx, ecx ; ecx = 0
cmp_m:
	mov dl, entered_password[ecx]  ;; you wont see this line after substitution
	xor dl, num ; dl ^ num
	mov entered_password[ecx], dl
	inc ecx
	cmp ecx, lengthof password
	jne cmp_m
endm
	
MacroCMP macro str1, str2
	local string_cmp ; some local mark 
	xor ecx, ecx
string_cmp:
	mov dl, str1[ecx] ; load dl with char from str1
	mov dh, str2[ecx] ; load dh with char from str2
	cmp dl, dh ;; you wont see this line after substitution
	jne errorer ;; jump
	inc ecx
	cmp ecx, lengthof password
	jne string_cmp
endm
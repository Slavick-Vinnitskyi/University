.model tiny



.data

string db 0,0,0,0,0
password db '4761$'
passwordt db 0,0,0,0
msgName db 'Гордиенко Никита Юриевич',  13, 10, '$'
msgNum db 'Зачетная книжка: 6404',  13, 10, '$'
msgDate db 'Дата рождения: 1 апреля 1999',  13, 10, '$'
msgf db ' Ошибка: неверный пароль!!!!! $'
msgs db 'Успешно $'
.code
org 100h


start:


mov cx, 0; каунтер

enterer:
mov ah, 01h; чтение ввода
int 21h

mov di, cx
mov string[di], al;запись с ввода в массив

inc cx
cmp cx, 4 ;сраавнение каунтера
jne enterer
mov string[4], "$"
mov password[4], "$";строка заканчивается на этот знак
xor ax, ax
xor di, di
mov di, 0; обнуление регистра
xor bl, bl
mov bl, 5
jmp chipherer;шифрование

chipherer:
xor string[di], bl

inc di
cmp di, 4
je nullifier
jne chipherer

nullifier:
mov di, 0
jmp comparer

comparer:;сравнение строки и пароля

xor bl,bl
mov bl, string[di]
cmp bl, password[di]
jne errorer
je counter_increase

counter_increase:
inc di
jmp counter_compare




counter_compare:
cmp di, 4;отсчет каунтера чтобы проверило 4 символа только
je ender
jmp comparer

errorer:

mov ah, 09h
mov dx, offset msgf;вывод сообщений
int 21h

xor ax, ax
mov ah, 4ch
int 21h

ender:
mov ah, 09h
mov dx, offset msgs
int 21h

mov ax, 03h; очищение экрана
int 10h

mov ah, 09h
mov dx, offset msgName
int 21h

mov ah, 09h
mov dx, offset msgNum
int 21h

mov ah, 09h
mov dx, offset msgDate
int 21h


xor ax, ax
mov ah, 4ch
int 21h
end start

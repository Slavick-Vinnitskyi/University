.model tiny



.data

string db 0,0,0,0,0
password db '4761$'
passwordt db 0,0,0,0
msgName db '��न���� ����� �ਥ���',  13, 10, '$'
msgNum db '���⭠� ������: 6404',  13, 10, '$'
msgDate db '��� ஦�����: 1 ��५� 1999',  13, 10, '$'
msgf db ' �訡��: ������ ��஫�!!!!! $'
msgs db '�ᯥ譮 $'
.code
org 100h


start:


mov cx, 0; �����

enterer:
mov ah, 01h; �⥭�� �����
int 21h

mov di, cx
mov string[di], al;������ � ����� � ���ᨢ

inc cx
cmp cx, 4 ;�ࠠ������ �����
jne enterer
mov string[4], "$"
mov password[4], "$";��ப� �����稢����� �� ��� ����
xor ax, ax
xor di, di
mov di, 0; ���㫥��� ॣ����
xor bl, bl
mov bl, 5
jmp chipherer;��஢����

chipherer:
xor string[di], bl

inc di
cmp di, 4
je nullifier
jne chipherer

nullifier:
mov di, 0
jmp comparer

comparer:;�ࠢ����� ��ப� � ��஫�

xor bl,bl
mov bl, string[di]
cmp bl, password[di]
jne errorer
je counter_increase

counter_increase:
inc di
jmp counter_compare




counter_compare:
cmp di, 4;����� ����� �⮡� �஢�ਫ� 4 ᨬ���� ⮫쪮
je ender
jmp comparer

errorer:

mov ah, 09h
mov dx, offset msgf;�뢮� ᮮ�饭��
int 21h

xor ax, ax
mov ah, 4ch
int 21h

ender:
mov ah, 09h
mov dx, offset msgs
int 21h

mov ax, 03h; ��饭�� �࠭�
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

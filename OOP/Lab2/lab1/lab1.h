#pragma once

#include "resource.h"
#include "string"

#define MAX_LOADSTRING 100

// Глобальные переменные:
HINSTANCE hInst;                                // текущий экземпляр
WCHAR szTitle[MAX_LOADSTRING];                  // Текст строки заголовка
WCHAR szWindowClass[MAX_LOADSTRING];            // имя класса главного окна

												// Отправить объявления функций, включенных в этот модуль кода:
ATOM                MyRegisterClass(HINSTANCE hInstance);
BOOL                InitInstance(HINSTANCE, int);
LRESULT CALLBACK    WndProc(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    About(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    ID_Dialog1(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    ID_Dialog2(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    ID_Dialog3(HWND, UINT, WPARAM, LPARAM);

std::string buf;
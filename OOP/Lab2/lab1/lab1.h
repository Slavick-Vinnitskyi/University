#pragma once

#include "resource.h"
#include "string"

#define MAX_LOADSTRING 100

// ���������� ����������:
HINSTANCE hInst;                                // ������� ���������
WCHAR szTitle[MAX_LOADSTRING];                  // ����� ������ ���������
WCHAR szWindowClass[MAX_LOADSTRING];            // ��� ������ �������� ����

												// ��������� ���������� �������, ���������� � ���� ������ ����:
ATOM                MyRegisterClass(HINSTANCE hInstance);
BOOL                InitInstance(HINSTANCE, int);
LRESULT CALLBACK    WndProc(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    About(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    ID_Dialog1(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    ID_Dialog2(HWND, UINT, WPARAM, LPARAM);
INT_PTR CALLBACK    ID_Dialog3(HWND, UINT, WPARAM, LPARAM);

std::string buf;
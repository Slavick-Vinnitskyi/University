#include "stdafx.h"
#include "Tool.h"

ToolBarHandler::ToolBarHandler(HWND hWnd)
{
	auto hInst = HINSTANCE(GetWindowLong(hWnd, GWL_HINSTANCE));

	toolbar = CreateWindowEx(0, TOOLBARCLASSNAME, nullptr,
		WS_CHILD | TBSTYLE_TOOLTIPS | TBSTYLE_LIST | WS_BORDER, 0, 0, 0, 0, hWnd, nullptr, hInst,
		NULL);
	HIMAGELIST hImageList = ImageList_Create(48, 48, FALSE, 4, 0);
	ImageList_Add(hImageList, LoadBitmap(hInst, MAKEINTRESOURCE(IDB_BITMAP)), nullptr);
	ImageList_Add(hImageList, LoadBitmap(hInst, MAKEINTRESOURCE(IDB_BITMAP_LINE)), nullptr);
	ImageList_Add(hImageList, LoadBitmap(hInst, MAKEINTRESOURCE(IDB_BITMAP_REC)), nullptr);
	ImageList_Add(hImageList, LoadBitmap(hInst, MAKEINTRESOURCE(IDB_BITMAP_El)), nullptr);

	SendMessage(toolbar, TB_SETIMAGELIST, (WPARAM)ID_IL_STANDARD, (LPARAM)hImageList);
	SendMessage(toolbar, TB_BUTTONSTRUCTSIZE, (WPARAM)sizeof(TBBUTTON), 0);
	TBBUTTON tbb[4] =
	{
		{ 0,ID_DOT,TBSTATE_ENABLED,BTNS_BUTTON,{ 0 },0, (INT_PTR)L"Draw Dot (black)" },
		{ 1,ID_LINE,TBSTATE_ENABLED,BTNS_BUTTON,{ 0 },0, (INT_PTR)L"Draw Line (black)" },
		{ 2,ID_RECTANGLE,TBSTATE_ENABLED,BTNS_BUTTON,{ 0 },0, (INT_PTR)L"Draw Rectangle with white filling" },
		{ 3,ID_ELLIPSE,TBSTATE_ENABLED,BTNS_BUTTON,{ 0 },0, (INT_PTR)L"Draw Ellipse without filling" }
	};

	SendMessage(toolbar, TB_ADDBUTTONS, 4, (LPARAM)&tbb);
	SendMessage(toolbar, TB_AUTOSIZE, 0, 0);
	SendMessage(toolbar, TB_SETEXTENDEDSTYLE, 0, LPARAM(TBSTYLE_EX_MIXEDBUTTONS));
	ShowWindow(toolbar, SW_SHOW);
}

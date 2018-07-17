#pragma once
#include "lab1.h"

INT_PTR CALLBACK ID_Dialog3(HWND hDlg, UINT message, WPARAM wParam, LPARAM lParam)
{
	UNREFERENCED_PARAMETER(lParam);
	switch (message)
	{
	case WM_INITDIALOG:
		SendDlgItemMessage(hDlg, IDC_LIST3, LB_ADDSTRING, 0, (LPARAM)"²Ï-61");
		SendDlgItemMessage(hDlg, IDC_LIST3, LB_ADDSTRING, 0, (LPARAM)"²Ï-62");
		SendDlgItemMessage(hDlg, IDC_LIST3, LB_ADDSTRING, 0, (LPARAM)"²Ï-63");
		SendDlgItemMessage(hDlg, IDC_LIST3, LB_ADDSTRING, 0, (LPARAM)"²Ï-64");
		return (INT_PTR)TRUE;

	case WM_COMMAND:
		if (LOWORD(wParam) == IDCANCEL)
		{
			EndDialog(hDlg, LOWORD(wParam));
			return (INT_PTR)TRUE;
		}
		if (LOWORD(wParam) == IDOK)
		{
			CHAR localpafch[100];
			CHAR indx = SendDlgItemMessage(hDlg, IDC_LIST3, LB_GETCURSEL, 0, 0);
			SendDlgItemMessage(hDlg, IDC_LIST3, LB_GETTEXT, indx, (long)localpafch);
			buf = localpafch;
			EndDialog(hDlg, LOWORD(wParam));
		}
		break;
	}
	return (INT_PTR)FALSE;
}
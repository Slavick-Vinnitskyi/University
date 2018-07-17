#include "stdafx.h"
#include "MyTable.h"

void MyTable::SetTable(Table* tb, char* filename, HWND hWnd)
{
	EnableMenuItem(GetMenu(hWnd), ID_FILE_SAVEAS, false);
	EnableMenuItem(GetMenu(hWnd), ID_FILE_SAVE, false);
	DestroyWindow(hwndEdit);
	if (tb != NULL)
	{
		SetWindowTextA(hWnd, filename);
		tab = tb;
		while (!stc.empty())
		{
			stc.pop();
		}

		f = true;
		int qc = tb->GetQC();
		int qi = tb->GetQI();
		
		maxlc = new int[tb->GetQC()];

		for (int j = 0; j < tb->GetQC(); j++)
		{
			maxlc[j] = 0;
		}

		for (int j = 0; j < tb->GetQC(); j++)
		{
			for (int i = 0; i < tb->GetQI(); i++)
			{
				if (maxlc[j] < strlen(tb->GetVct(i, j))) maxlc[j] = strlen(tb->GetVct(i, j));
			}
		}
	}
	InvalidateRect(hWnd, 0, TRUE);
}

void MyTable::SetFlag(bool bu)
{
	f = bu;
}
void MyTable::Paint(HWND hWnd)
{
	if (tab != NULL)
	{
		PAINTSTRUCT ps;
		HDC hdc;

			hdc = BeginPaint(hWnd, &ps);
			maxl = 0;
			for (int i = 0; i < tab->GetQC(); i++)
			{
				maxl += maxlc[i];
			}
			if (f)
			{
				SetScrollsPropertys(hWnd);
				f = false;
			}
			
			Rectangle(hdc, 0 - HscrollInfo.nPos, 0 - VscrollInfo.nPos, (maxl*let + 2 * tab->GetQC() *keys) - HscrollInfo.nPos, tab->GetQI() * 60 - VscrollInfo.nPos);
			for (int i = 0; i < tab->GetQI(); i++)
			{
				MoveToEx(hdc, 0 - HscrollInfo.nPos, i * 60 - VscrollInfo.nPos, NULL);
				LineTo(hdc, maxl*let + 2 * tab->GetQC() * keys - HscrollInfo.nPos, i * 60 - VscrollInfo.nPos);
				for (int j = 0; j < tab->GetQC(); j++)
				{
					if (i == 0)
					{
						MoveToEx(hdc, coord(j) - keys, 0 - VscrollInfo.nPos, NULL);
						LineTo(hdc, coord(j) - keys, tab->GetQI() * 60 - VscrollInfo.nPos);
					}
					TextOutA(hdc, coord(j), 20 + i * 60 - VscrollInfo.nPos, tab->GetVct(i, j), strlen(tab->GetVct(i, j)));
				}
			}
			EndPaint(hWnd, &ps);
		}
	
}

void MyTable::HScroll(HWND hWnd, WPARAM wParam)
{
	int xCurrentScroll = GetScrollPos(hWnd, SB_HORZ);
	int xDelta;
	int xNewPos;
	switch (LOWORD(wParam))
	{
	case SB_PAGERIGHT:
		xNewPos = xCurrentScroll + 50;
		break;
	case SB_PAGELEFT:
		xNewPos = xCurrentScroll - 50;
		break;
	case SB_LINERIGHT:
		xNewPos = xCurrentScroll + 5;
		break;
	case SB_LINELEFT:
		xNewPos = xCurrentScroll - 5;
		break;
	case SB_THUMBPOSITION:
		xNewPos = HIWORD(wParam);
		break;
	default:
		xNewPos = xCurrentScroll;
	}
	if (!IsWindow((HWND)hwndEdit))
	{
		SetScrollPos(hWnd, SB_HORZ, xNewPos, true);
		HscrollInfo.nPos = xNewPos;
		InvalidateRect(hWnd, 0, TRUE);
	}
}

void MyTable::VScroll(HWND hWnd, WPARAM wParam)
{
	int yCurrentScroll = GetScrollPos(hWnd, SB_VERT);
	int yDelta;
	int yNewPos;
	switch (LOWORD(wParam))
	{
	case SB_PAGEDOWN:
		yNewPos = yCurrentScroll + 10;
		break;
	case SB_PAGEUP:
		yNewPos = yCurrentScroll - 10;
		break;
	case SB_LINEDOWN:
		yNewPos = yCurrentScroll + 5;
		break;
	case SB_LINEUP:
		yNewPos = yCurrentScroll - 5;
		break;
	case SB_THUMBPOSITION:
		yNewPos = HIWORD(wParam);
		break;
	default:
		yNewPos = yCurrentScroll;
	}
	if (!IsWindow((HWND)hwndEdit))
	{
		SetScrollPos(hWnd, SB_VERT, yNewPos, true);
		VscrollInfo.nPos = yNewPos;
		InvalidateRect(hWnd, 0, TRUE);
	}
}

void MyTable::SetScrollsPropertys(HWND hWnd)
{
	
	RECT rc;
	GetClientRect(hWnd, &rc);
	if (rc.right < (maxl *  let + 2 * tab->GetQC() * keys))
	{
		HscrollInfo.cbSize = sizeof(SCROLLINFO);
		HscrollInfo.nMin = 0;
		HscrollInfo.nMax = (maxl*let + 2 * tab->GetQC() *keys) + 20;
		HscrollInfo.fMask = SIF_ALL;
		if (!HscrollInfo.nPos) HscrollInfo.nPos = 0;
		HscrollInfo.nPage = rc.right;
		SetScrollInfo(hWnd, SB_HORZ, &HscrollInfo, false);
	}
	else
		SetScrollRange(hWnd, SB_HORZ, 0, 0, false);
	if (rc.bottom < tab->GetQI() * 60)
	{
		VscrollInfo.cbSize = sizeof(SCROLLINFO);
		VscrollInfo.nMin = 0;
		VscrollInfo.nMax = tab->GetQI() * 60 + 20;
		VscrollInfo.fMask = SIF_ALL;
		if (!VscrollInfo.nPos) VscrollInfo.nPos = 0;
		VscrollInfo.nPage = rc.bottom;
		SetScrollInfo(hWnd, SB_VERT, &VscrollInfo, false);
	}
	else
		SetScrollRange(hWnd, SB_VERT, 0, 0, TRUE);
}



LRESULT CALLBACK MyTable::EditProc(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam)
{
	MyTable* v = (MyTable*)(GetWindowLongPtr(hwnd, GWLP_USERDATA));
	if (v) return v->RealEditProc(hwnd, msg, wParam, lParam);
	return DefWindowProc(hwnd, msg, wParam, lParam);
}

LRESULT CALLBACK MyTable::RealEditProc(HWND hwndEdit, UINT msg, WPARAM wParam, LPARAM lParam)
{
		char bufEdit[150];
		Info kek1;
		switch (msg)
		{
		case WM_KEYDOWN:
			switch (wParam)
			{
			case VK_RETURN:
				kek1.nC = numberC;
				kek1.nI = numberI;
				kek1.max = maxlc[numberC];
				strcpy(kek1._text, tab->GetVct(numberI, numberC));
				stc.push(kek1);
				GetWindowText(hwndEdit, bufEdit, 150);
				DestroyWindow(hwndEdit);
				if (bufEdit[0] == '\0') strcpy(bufEdit, " ");
				tab->ChangeItem(numberI, numberC, bufEdit);
				if (maxlc[numberC] < strlen(bufEdit)) maxlc[numberC] = strlen(bufEdit);
				maxl = 0;
				for (int i = 0; i < tab->GetQC(); i++)
				{
					maxl += maxlc[i];
				}
				SetScrollsPropertys(hwnd);
				InvalidateRect(hwnd, 0, TRUE);
				break;  //or return 0; if you don't want to pass it further to def proc
				//If not your key, skip to default:
			case VK_ESCAPE:
				DestroyWindow(hwndEdit);
				break;
			}
		default:
			return CallWindowProc(oldEditProc, hwndEdit, msg, wParam, lParam);
		}
		return 0;
}



void MyTable::Edit(HWND hWnd)
{
	if (tab != NULL)
	{
		if (!IsWindow((HWND)hwndEdit))
		{
			int ryadprop = 0;
			int otny = 0;
			POINT pt;
			long x, y;
			GetCursorPos(&pt);
			ScreenToClient(hWnd, &pt);
			x = pt.x;
			y = pt.y;
			if ((x + HscrollInfo.nPos < (maxl*let + 2 * tab->GetQC() *keys)) && (y + VscrollInfo.nPos < tab->GetQI() * 60))
			{
				//x -= ostx();
				numberC = numC(x + HscrollInfo.nPos);
				numberI = numI(y + VscrollInfo.nPos);

				hwndEdit = CreateWindowEx(0,
					"EDIT",   // predefined class 
					NULL,// no window title 
					WS_CHILD | WS_VISIBLE | WS_BORDER |
					ES_LEFT,
					coord(numberC) - 20, (numberI) * 60 - VscrollInfo.nPos , maxlc[numberC] * let + 2 * keys, 60,   // set size in WM_SIZE message 
					hWnd,         // parent window 
					(HMENU)1450,   // edit control ID 
					(HINSTANCE)GetWindowLong(hWnd, GWL_HINSTANCE),
					NULL);        // pointer not needed
				SetWindowTextA(hwndEdit, tab->GetVct(numberI, numberC));
				SetFocus(hwndEdit);
				SetWindowLongPtr(hwndEdit, GWLP_USERDATA, (long)this);
				hwnd = hWnd;
				oldEditProc = (WNDPROC)SetWindowLongPtr(hwndEdit, GWLP_WNDPROC, (LONG_PTR)EditProc);
				//oldEditProc = (WNDPROC)SetWindowLongPtr(hwndEdit, GWLP_WNDPROC, (LONG_PTR)EditProc);
				
			}
		}
	}
}

int MyTable::coord(int j)
{
	int max = 0;
	int x = 0;
	for (int i = 0; i < j; i++)
	{
		max += maxlc[i];
	}
	x = max*let + 2 * j * keys + keys;
	return x - HscrollInfo.nPos;
}

int MyTable::numC(int x)
{
	int max = 0;
	int i = 0;
	while (max < x)
	{
		max += maxlc[i] * let + 2 * keys;
		i++;
	}

	return i - 1;
}

int MyTable::numI(int y)
{
	int max = 0;
	int i = 0;

	while (max < y)
	{
		max += 60;
		i++;
	}

	return i - 1;
}

void MyTable::Cansel(HWND hWnd)
{
	Info inf;
	if (!stc.empty())
	{
		inf = stc.top();
		tab->ChangeItem(inf.nI, inf.nC, inf._text);
		maxlc[inf.nC] = inf.max;
		stc.pop();
		InvalidateRect(hWnd, 0, TRUE);
	}
}

void MyTable::WriteFile(char* filename)
{
	if (tab != NULL)
	{
		ofstream fout;
		fout.open(filename, ios::out);
		for (int i = 0; i < tab->GetQI(); i++)
		{
			for (int j = 0; j < tab->GetQC(); j++)
			{
				fout << tab->GetVct(i, j);

				if (j != tab->GetQC() - 1) fout << "\t";
			}
			if (i != tab->GetQI() - 1) fout << "\n";
		}
		fout.close();
	}
}

void MyTable::WriteFileAs(HWND hWnd)
{
	if (tab != NULL)
	{
		OPENFILENAME ofn;
		char szFile[100];
		ZeroMemory(&ofn, sizeof(ofn));
		ofn.lStructSize = sizeof(ofn);
		ofn.hwndOwner = hWnd;
		ofn.lpstrFile = szFile;
		ofn.lpstrFile[0] = '\0';
		ofn.nMaxFile = sizeof(szFile);
		ofn.lpstrFilter = "Text\0*.TXT\0";
		ofn.nFilterIndex = 1;
		ofn.lpstrFileTitle = NULL;
		ofn.nMaxFileTitle = 0;
		ofn.lpstrInitialDir = NULL;
		ofn.Flags = OFN_PATHMUSTEXIST | OFN_FILEMUSTEXIST | OFN_HIDEREADONLY;
		if (GetSaveFileName(&ofn));
		{
			ofstream fout;
			fout.open(ofn.lpstrFile, ios::out);
			for (int i = 0; i < tab->GetQI(); i++)
			{
				for (int j = 0; j < tab->GetQC(); j++)
				{
					fout << tab->GetVct(i, j);
					if (j != tab->GetQC() - 1) fout << "\t";
				}
				if (i != tab->GetQI() - 1) fout << "\n";
			}
			fout.close();
		}
	}
}
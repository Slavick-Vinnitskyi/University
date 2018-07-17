#include "stdafx.h"
#include "LineEditor.h"

void LineEditor::OnLBdown(HWND hwnd, int x, int y)
{
	InvalidateRect(hwnd, nullptr, true);
	shape->SetX1Y1(x, y);
	shape->SetX2Y2(x, y);
	lb = true;
}

void LineEditor::OnLBup(HWND hwnd, int x, int y)
{
	shape->SetX2Y2(x, y);
	lb = false;
}

void LineEditor::OnMouseMove(HWND hwnd, int x, int y)
{
	if (lb)
	{
		
		HDC hdc = GetDC(hwnd);
		SetROP2(hdc, R2_NOTXORPEN);
		HPEN hPen = CreatePen(PS_SOLID, 1, RGB(0, 0, 0));
		HPEN hPenOld = HPEN(SelectObject(hdc, hPen));
		
		
		DrawShadow(hdc);
		shape->SetX2Y2(x, y);
		DrawShadow(hdc);

		SelectObject(hdc, hPenOld);
		DeleteObject(hPen);
		ReleaseDC(hwnd, hdc);
	}
}
void LineEditor::DrawShadow(HDC hdc)
{
	shape->Draw(hdc);
}

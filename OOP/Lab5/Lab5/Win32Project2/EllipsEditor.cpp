#include "stdafx.h"
#include "EllipsEditor.h"

void EllipsEditor::OnLBdown(HWND hwnd, int x, int y)
{
	InvalidateRect(hwnd, nullptr, true);
	shape->SetX1Y1(x, y);
	shape->SetX2Y2(x, y);
	lb = true;
}

void EllipsEditor::OnLBup(HWND hwnd, int x, int y)
{
	shape->SetX2Y2(x, y);
	lb = false;
}

void EllipsEditor::OnMouseMove(HWND hwnd, int x, int y)
{
	if (lb)
	{//черный контур без заполнения
		//помаранчеве заповнення
		HDC hdc = GetDC(hwnd);
		HPEN hPen = CreatePen(PS_SOLID, 1, RGB(0, 0, 0));
		HPEN hPenOld = HPEN(SelectObject(hdc, hPen));
		SetROP2(hdc, R2_NOTXORPEN);
		
		DrawShadow(hdc);
		shape->SetX2Y2(x, y);
		DrawShadow(hdc);
		


		SelectObject(hdc, hPenOld);
		DeleteObject(hPen);
		ReleaseDC(hwnd, hdc);
	}
}
void EllipsEditor::DrawShadow(HDC hdc)
{
	shape->Draw(hdc);
}

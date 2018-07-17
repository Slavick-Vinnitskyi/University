#include "stdafx.h"
#include "RectangleEditor.h"

void RectangleEditor::OnLBdown(HWND hwnd, int x, int y)
{
	InvalidateRect(hwnd, nullptr, true);
	shape->SetX1Y1(x, y);
	shape->SetX2Y2(x, y);
	lb = true;
}

void RectangleEditor::OnLBup(HWND hwnd, int x, int y)
{

	shape->SetX2Y2(x, y);
	lb = false;
}
void RectangleEditor::DrawShadow(HDC hdc)
{//черный цвет белое заполнение
 // серое заполнение	
	/*MoveToEx(hdc, shape->x1() - (shape->x2() - shape->x1()), shape->y1() + (shape->y2() - shape->y1()), nullptr);
	LineTo(hdc, shape->x2(), shape->y2());
	MoveToEx(hdc, shape->x2(), shape->y2(), nullptr);
	LineTo(hdc, shape->x1() + (shape->x2() - shape->x1()), shape->y1() - (shape->y2() - shape->y1()));
	MoveToEx(hdc, shape->x1() - (shape->x2() - shape->x1()), shape->y1() - (shape->y2() - shape->y1()), nullptr);
	LineTo(hdc, shape->x1() + (shape->x2() - shape->x1()), shape->y1() - (shape->y2() - shape->y1()));
	MoveToEx(hdc, shape->x1() - (shape->x2() - shape->x1()), shape->y1() - (shape->y2() - shape->y1()), nullptr);
	LineTo(hdc, shape->x1() - (shape->x2() - shape->x1()), shape->y1() + (shape->y2() - shape->y1()));*/

	shape->Draw(hdc);
}


void RectangleEditor::OnMouseMove(HWND hwnd, int x, int y)
{
	if (lb)
	{
		HDC hdc = GetDC(hwnd);
		SetROP2(hdc, R2_NOTXORPEN);
		HPEN hPen = CreatePen(PS_SOLID, 1, RGB(255, 0, 0));
		HPEN hPenOld = HPEN(SelectObject(hdc, hPen));
		DrawShadow(hdc);
		shape->SetX2Y2(x, y);
		DrawShadow(hdc);
		SelectObject(hdc, hPenOld);
		DeleteObject(hPen);
		ReleaseDC(hwnd, hdc);
	}
}


#pragma once
#include "Shape.h"

class RectangleShape: public  Shape
{
public:
	void Draw(HDC hdc) 
	{
		HBRUSH hBrush = HBRUSH(CreateSolidBrush(RGB(255,255,255)));
		HBRUSH hBrushOld = HBRUSH(SelectObject(hdc, hBrush)); 
		Rectangle(hdc, X1-(X2-X1),Y1-(Y2-Y1), X2, Y2);
		SelectObject(hdc, hBrushOld); 
		DeleteObject(hBrush);
	}
};

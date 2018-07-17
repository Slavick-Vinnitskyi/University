#pragma once
#include "Shape.h"

class RectangleShape: public  Shape
{
public:
	void Draw(HDC hdc) 
	{
		HBRUSH hBrush = HBRUSH(CreateSolidBrush(RGB(255,255,255)));
		HBRUSH hBrushOld = HBRUSH(SelectObject(hdc, hBrush));
		
		long x3, y3, x4, y4;
		long rast;
		rast = (X2 - X1);
		x3 = X1 + rast / 2;
		y3 = Y1 - rast / 2;
		x4 = X2 + rast / 2;
		y4 = Y2 - rast / 2;
		DrawRect(hdc, x3, y3, x4, y4);
		DrawRect(hdc, X1, Y1, X2, Y2);

		MoveToEx(hdc, X1, Y1, nullptr);
		LineTo(hdc, x3, y3);
		MoveToEx(hdc, X2, Y2, nullptr);
		LineTo(hdc, x4, y4);
		MoveToEx(hdc, X2, Y1, nullptr);
		LineTo(hdc, x4, y3);
		MoveToEx(hdc, X1, Y2, nullptr);
		LineTo(hdc, x3, y4);




		//Rectangle(hdc, X1-(X2-X1),Y1-(Y2-Y1), X2, Y2);
		SelectObject(hdc, hBrushOld); 
		DeleteObject(hBrush);
	}

	void static DrawRect(HDC hdc, long x1, long y1, long x2, long y2)
	{
		MoveToEx(hdc,  x1  ,  y1 , nullptr);
		LineTo(hdc,  x1 ,  y2 );
		MoveToEx(hdc, x1, y1, nullptr);
		LineTo(hdc, x2, y1);
		MoveToEx(hdc,  x2 ,  y2 , nullptr);
		LineTo(hdc, x1, y2);
		MoveToEx(hdc, x2, y2, nullptr);
		LineTo(hdc, x2, y1);


		
	}


	
};

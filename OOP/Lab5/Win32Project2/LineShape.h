#pragma once
#include "Shape.h"

class Line : public  Shape
{
public:
	void Draw(HDC hdc) 
	{
		
		MoveToEx(hdc, X1, Y1, nullptr);
		LineTo(hdc, X2, Y2);

		Ellipse(hdc, X1 - 20, Y1 - 20, X1 + 20, Y1 + 20);
		Ellipse(hdc, X2 - 20, Y2 - 20, X2 + 20, Y2 + 20);
	}
};

#pragma once
#include "Shape.h"

class Line : public  Shape
{
public:
	void Draw(HDC hdc) 
	{
		MoveToEx(hdc, X1, Y1, nullptr);
		LineTo(hdc, X2, Y2);
	}
};

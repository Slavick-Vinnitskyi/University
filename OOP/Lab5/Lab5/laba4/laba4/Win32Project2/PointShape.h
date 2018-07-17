#pragma once
#include "Shape.h"

class Point: public Shape
{
public:
	void Draw(HDC hdc) 
	{
		SetPixel(hdc, X1, Y1, RGB(0, 0, 0));
	
	}
	
};

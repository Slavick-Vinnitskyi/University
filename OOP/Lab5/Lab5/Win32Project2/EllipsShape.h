#pragma once
#include "Shape.h"

class Ellips: public  Shape
{
public:
	void Draw(HDC hdc)
	{
		Arc(hdc, X1, Y1, X2, Y2, 0, 0, 0, 0);
	}
};

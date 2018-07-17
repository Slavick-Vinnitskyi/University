#pragma once

class Shape
{
protected:
	long X1 = 0, Y1 = 0, X2 = 0, Y2 = 0;
public:
	virtual void Draw(HDC hdc) = 0;
	void SetX1Y1(long x1, long y1)
	{
		X1 = x1;
		Y1 = y1;
	}
	void SetX2Y2(long x2, long y2)
	{
		X2 = x2;
		Y2 = y2;
	}
	long x1()
	{
		return X1;
	}
	long x2()
	{
		return X2;
	}
	long y1()
	{
		return Y1;
	}
	long y2()
	{
		return Y2;
	}
};

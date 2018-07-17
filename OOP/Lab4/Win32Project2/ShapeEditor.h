#pragma once
#include "Editor.h"
#include "Shape.h"

class ShapeEditor : public  Editor
{
protected:
	Shape* shape = nullptr;
	bool lb = false;
public:

	Shape* ShapeR() 
	{
		return shape;
	}
	virtual void NewShape() = 0;

	virtual void DrawShadow(HDC hdc) = 0;


};

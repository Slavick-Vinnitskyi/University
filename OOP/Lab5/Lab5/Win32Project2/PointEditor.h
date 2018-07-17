#pragma once
#include "Editor.h"
#include "ShapeEditor.h"
#include "PointShape.h"

class PointEditor: public ShapeEditor
{
public:

	void OnLBdown(HWND hwnd, int x, int y)  {}
	
	void NewShape()  
	{ 
		shape = new Point();
	}

	void OnLBup(HWND hwnd, int x, int y)
	{ 
		shape->SetX1Y1(x, y);
	}

	void OnMouseMove(HWND hwnd, int x, int y)  {}

	void DrawShadow(HDC hdc){}
};

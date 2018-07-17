#pragma once

#include "ShapeEditor.h"
#include "RectangleShape.h"
class RectangleEditor: public ShapeEditor
{
public:
	void OnLBdown(HWND hwnd, int x, int y);

	void OnLBup(HWND hwnd, int x, int y);

	void OnMouseMove(HWND hwnd, int x, int y) ;

	void NewShape()
	{
		shape = new RectangleShape();
	}

	void DrawShadow(HDC hdc) ;
};

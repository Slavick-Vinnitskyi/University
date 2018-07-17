#pragma once
#include "ShapeEditor.h"
#include "EllipsShape.h"

class EllipsEditor: public ShapeEditor
{
public:
	void OnLBdown(HWND hwnd, int x, int y);

	void OnLBup(HWND hwnd, int x, int y);

	void OnMouseMove(HWND hwnd, int x, int y);

	void NewShape() 
	{
		shape =  new Ellips();
	}

	void DrawShadow(HDC hdc);
};

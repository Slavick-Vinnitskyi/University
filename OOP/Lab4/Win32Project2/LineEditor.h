#pragma once
#include "ShapeEditor.h"
#include "LineShape.h"

class LineEditor: public ShapeEditor
{
	
public:
	void OnLBdown(HWND hwnd, int x, int y);

	void OnLBup(HWND hwnd, int x, int y);

	void OnMouseMove(HWND hwnd, int x, int y);

	void DrawShadow(HDC hdc);
	
	void NewShape()
	{
		shape = new Line();
	}
};

#pragma once


#include "Shape.h"
#include "PointEditor.h"
#include "LineEditor.h"
#include "EllipsEditor.h"
#include "RectangleEditor.h"

class ShapeObjectsEditor : public Editor
{
private:
	ShapeEditor* editor = nullptr;
	Shape* shapes[105];
	int current_shape = 0;

public:



	void StartPointEditor()
	{
		if (editor)
		{
			delete editor;
		}
		editor = new PointEditor();
		editor->NewShape();
	}

	void StartLineEditor()
	{
		if (editor)
		{
			delete editor;
		}
		editor = new LineEditor();
		editor->NewShape();
	}

	
	void StartRectEditor()
	{
		if (editor)
		{
			delete editor;
		}
		editor = new RectangleEditor();
		editor->NewShape();
	}

	void StartEllipseEditor()
	{
		if (editor)
		{
			delete editor;
		}
		editor = new EllipsEditor();
		editor->NewShape();
	}

	void OnLBdown(HWND hwnd, int x, int y);
	void OnLBup(HWND hwnd, int x, int y);
	void OnMouseMove(HWND hwnd, int x, int y);
	void OnPaint(HWND hwnd);
};

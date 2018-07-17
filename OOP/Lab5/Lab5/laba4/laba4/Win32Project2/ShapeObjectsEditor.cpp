#include "stdafx.h"
#include "ShapeObjectsEditor.h"

void ShapeObjectsEditor::OnLBdown(HWND hwnd, int x ,int y)
{
	if (editor != nullptr)
	{
		editor->OnLBdown(hwnd, x, y);
	}
}

void ShapeObjectsEditor::OnLBup(HWND hwnd, int x, int y)
{
	if (editor != nullptr)
	{
		editor->OnLBup(hwnd, x, y);
		if (shapes[current_shape] != nullptr)
		{
			delete shapes[current_shape];
		}
		shapes[current_shape] = editor->ShapeR();
		current_shape++;
		if (current_shape > 105)
		{
			current_shape = 0;
		}
		editor->NewShape();
		InvalidateRect(hwnd, nullptr, true);
	}
}

void ShapeObjectsEditor::OnMouseMove(HWND hwnd, int x, int y)
{
	if (editor != nullptr)
	{
		editor->OnMouseMove(hwnd, x, y);
	}
}

void ShapeObjectsEditor::OnPaint(HWND hwnd)
{
	PAINTSTRUCT ps;
	HDC hdc = BeginPaint(hwnd, &ps);
	for(Shape* shape: shapes)
	{
		if (shape)
		{
			shape->Draw(hdc);
		}
	}
	EndPaint(hwnd, &ps);
}

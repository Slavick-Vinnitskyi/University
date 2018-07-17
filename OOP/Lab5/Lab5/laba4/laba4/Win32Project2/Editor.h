#pragma once

class Editor
{
public:
	virtual void OnLBdown(HWND, int, int)=0;
	virtual void OnLBup(HWND, int, int)=0;
	virtual void OnMouseMove(HWND hwnd, int x, int y)=0;
	
};

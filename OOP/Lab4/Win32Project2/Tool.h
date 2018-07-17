#pragma once
#pragma once
#include "resource.h"
#include <CommCtrl.h>

class ToolBarHandler
{
	static const int ID_IL_STANDARD = 0;
	HWND toolbar;
public:
	ToolBarHandler(HWND hWnd);

	void ResetState()
	{
		SendMessage(toolbar, TB_SETSTATE, ID_DOT, MAKELONG(TBSTATE_ENABLED, 0));
		SendMessage(toolbar, TB_SETSTATE, ID_LINE, MAKELONG(TBSTATE_ENABLED, 0));
		SendMessage(toolbar, TB_SETSTATE, ID_RECTANGLE, MAKELONG(TBSTATE_ENABLED, 0));
		SendMessage(toolbar, TB_SETSTATE, ID_ELLIPSE, MAKELONG(TBSTATE_ENABLED, 0));
	}
	void SetActiveState(int buttonId)
	{
		ResetState();
		SendMessage(toolbar, TB_SETSTATE, buttonId, MAKELONG(TBSTATE_PRESSED, 0));
	}
};

#include "Table.h"
#include "FileRead.h"
#include "resource.h"
#include <Commdlg.h>
#include <fstream>
#include <stack>


#define let 10.8
#define keys 20

using namespace std;

class MyTable {
private:
	struct Info{
		char _text[150];
		int nC;
		int nI;
		int max;
	};

	SCROLLINFO HscrollInfo;
	SCROLLINFO VscrollInfo;
	int coord(int j);
	int numberC;
	int numberI;
	HWND hwndEdit = NULL;
	HWND hwnd;
	int numI(int y);
	int numC(int x);

	Table* tab;
	int* maxlc;
	int maxl;
	stack<Info> stc;
	bool f = false;
	WNDPROC oldEditProc;
	static LRESULT CALLBACK EditProc(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam);
	void SetScrollsPropertys(HWND hWnd);
	
	LRESULT CALLBACK RealEditProc(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam);
	
public:
	void SetTable(Table* tb, char* filename, HWND hWnd);
	void Paint(HWND);
	void Edit(HWND hWnd);
	void SetFlag(bool);
	void WriteFile(char*);
	void WriteFileAs(HWND hWnd);
	void HScroll(HWND hWnd, WPARAM wParam);
	void VScroll(HWND hWnd, WPARAM wParam);
	void Cansel(HWND);
	
};
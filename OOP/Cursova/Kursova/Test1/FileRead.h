#include "Table.h"


using namespace std;

class Files
{
private:

	char filename[150];
	
public:
	Table* FileOpen(HWND);
	char* GetF();
};
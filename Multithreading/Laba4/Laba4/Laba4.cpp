#include "pch.h"
#include "Laba4.h"

using namespace std;

DWORD WINAPI ThreadFunc(CONST LPVOID lpParam) {
	ExitThread(0);
}

void main() {

	HANDLE  hThread;
	HANDLE hMutex = CreateMutex(NULL, FALSE, NULL);

	CreateThread(NULL, 0, StartFunctionOne, hMutex, 0, NULL);
	CreateThread(NULL, 0, StartFunctionTwo, hMutex, 0, NULL);
	CreateThread(NULL, 0, StartFunctionThree, hMutex, 0, NULL);

	system("pause");
}
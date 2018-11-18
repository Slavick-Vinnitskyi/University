#include "pch.h"
#include "Function2.h"
#include "Methods.h"
DWORD WINAPI StartFunctionTwo(CONST LPVOID lpParam) {
	int sizeOfArrays = 5;
	int** MK, **ML, **MG, **MF;
	Methods methods(sizeOfArrays);

	MK = methods.fillMatrix();
	ML = methods.fillMatrix();
	MG = methods.fillMatrix();

	MF = methods.diffMatrix(methods.multMatrix(MG, methods.multMatrix(MK,ML)), MK);

	printf("Function 2 started\n");
	CONST HANDLE hMutex = (CONST HANDLE)lpParam;
	WaitForSingleObject(hMutex, INFINITE);

	methods.putMatrix(MF);
	printf("Function 2 ended\n");
	ReleaseMutex(hMutex);
	ExitThread(0);
}
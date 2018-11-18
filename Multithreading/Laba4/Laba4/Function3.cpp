#include "pch.h"
#include "Function3.h"
#include "Methods.h"

DWORD WINAPI StartFunctionThree(CONST LPVOID lpParam) {
	int sizeOfArrays = 5;
	int* T, *O;
	int** MP, **MR;
	Methods methods(sizeOfArrays);

	T = methods.fillVector();
		
	MP = methods.fillMatrix();
	MR = methods.fillMatrix();
	

	O = methods.MultMatrixVector(methods.transMatrix(methods.multMatrix(MP, MR)),T);

	printf("Function 3 started\n");
	CONST HANDLE hMutex = (CONST HANDLE)lpParam;
	WaitForSingleObject(hMutex, INFINITE);

	methods.putVector(O);
	printf("Function 3 ended\n");
	ReleaseMutex(hMutex);
	ExitThread(0);
}

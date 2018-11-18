#include "pch.h"
#include "Function1.h"
#include "Methods.h"
DWORD WINAPI StartFunctionOne(CONST LPVOID lpParam) {
	int sizeOfArrays = 5;
	int* A, *B, *C;
	int** MO, **ME;
	Methods methods(sizeOfArrays);

	A = methods.fillVector();
	B = methods.fillVector();	
	MO = methods.fillMatrix();
	ME = methods.fillMatrix();


	C = methods.sumOfVectors(methods.MultMatrixVector(methods.multMatrix(ME, MO),B), A);
	printf("Function 1 started\n");
	CONST HANDLE hMutex = (CONST HANDLE)lpParam;
	WaitForSingleObject(hMutex, INFINITE);

	methods.putVector(C);
	printf("Function 1 ended\n");
	ReleaseMutex(hMutex);
	ExitThread(0);
}
#include "pch.h"
#include "Function1.h"

Function1::Function1(int sizeOfArrays)
{
	this->sizeOfArrays = sizeOfArrays;
}


Function1::~Function1()
{
}


void Function1::StartFunction(unsigned int& start) {

	unsigned int myStart = clock();

	Methods methods(sizeOfArrays);

	A = methods.fillVector();
	B = methods.fillVector();
	MO = methods.fillMatrix();
	ME = methods.fillMatrix();


	C = methods.sumOfVectors(methods.MultMatrixVector(methods.multMatrix(ME, MO), B), A);

	unsigned int myEnd = clock();
	start = myEnd - myStart;

#pragma omp critical
	{
		printf("Function 1 started\n");
		methods.putVector(C);
		printf("Function 1 ended\n");
	}
}
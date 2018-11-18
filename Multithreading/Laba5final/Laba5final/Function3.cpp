#include "pch.h"
#include "Function3.h"

Function3::Function3(int sizeOfArrays)
{
	this->sizeOfArrays = sizeOfArrays;
}


Function3::~Function3()
{
}


void Function3::StartFunction(unsigned int& start) {

	unsigned int myStart = clock();

	Methods methods(sizeOfArrays);

	T = methods.fillVector();

	MP = methods.fillMatrix();
	MR = methods.fillMatrix();

	O = methods.MultMatrixVector(methods.transMatrix(methods.multMatrix(MP, MR)), T);

	unsigned int myEnd = clock();
	start = myEnd - myStart;

#pragma omp critical
	{
		printf("Function 3 started\n");
		methods.putVector(O);
		printf("Function 3 ended\n");
	}
}

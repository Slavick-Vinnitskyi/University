#include "pch.h"
#include "Function2.h"

Function2::Function2(int sizeOfArrays)
{
	this->sizeOfArrays = sizeOfArrays;
}


Function2::~Function2()
{
}


void Function2::StartFunction(unsigned int& start)
{
	unsigned int myStart = clock();

	Methods methods(sizeOfArrays);
	
	MK = methods.fillMatrix();
	ML = methods.fillMatrix();
	MG = methods.fillMatrix();

	MF = methods.diffMatrix(methods.multMatrix(MG, methods.multMatrix(MK, ML)), MK);

	unsigned int myEnd = clock();
	start = myEnd - myStart;

#pragma omp critical
	{
		printf("Function 2 started\n");
		methods.putMatrix(MF);
		printf("Function 2 ended\n");
	}
}
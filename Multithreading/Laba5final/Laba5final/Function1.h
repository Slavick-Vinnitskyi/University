#pragma once
#include <ctime>
#include "Methods.h"

class Function1
{
public:
	Function1(int sizeOfArrays);

	~Function1();

	void StartFunction(unsigned int& start);
private:
	int sizeOfArrays;
	int* A, *B, *C;
	int** MO, **ME;
};
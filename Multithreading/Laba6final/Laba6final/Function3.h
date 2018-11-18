#pragma once
#include "Methods.h"
#include <ctime>

class Function3
{
public:
	Function3(int sizeOfArrays);
	~Function3();
	void StartFunction(unsigned int& start);
private:
	int sizeOfArrays;
	int* T, *O;
	int** MP, **MR;
};
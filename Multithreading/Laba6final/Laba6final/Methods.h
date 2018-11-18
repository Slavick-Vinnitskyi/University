#pragma once
#include <iostream>
#include "mpi.h"

class Methods
{
public:
	Methods(int sizeOfArrays);

	~Methods();

	int* fillVector();

	int** fillMatrix();

	void putVector(int* vector);

	void putMatrix(int** matrix);

	int* sumOfVectors(int* vector1, int* vector2);

	int** multMatrix(int** matrix1, int** matrix2);

	int** diffMatrix(int** matrix1, int** matrix2);
	int** transMatrix(int** matrix);

	int* MultMatrixVector(int** matrixToMultiple, int* vectorToMultiple);

private:
	int sizeOfArrays;
};
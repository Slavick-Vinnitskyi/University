#include "pch.h"
#include "Methods.h"


Methods::Methods(int sizeOfArrays)
{
	this->sizeOfArrays = sizeOfArrays;
}


Methods::~Methods()
{
}

//+
int* Methods::fillVector()
{
	int* vector = new int[sizeOfArrays];

	for (int i = 0; i < sizeOfArrays; i++)
	{
		//vector[i] = rand() % 100 - 100;
		vector[i] = 1;
	}

	return vector;
}
//+
int** Methods::fillMatrix()
{
	int** matrix = new int*[sizeOfArrays];

	for (int i = 0; i < sizeOfArrays; i++)
	{
		matrix[i] = new int[sizeOfArrays];
	}

	for (int i = 0; i < sizeOfArrays; i++)
	{
		for (int j = 0; j < sizeOfArrays; j++)
		{
			//matrix[i][j] = rand() % 100 - 100;
			matrix[i][j] = 1;
		}
	}

	return matrix;
}
//+
void Methods::putVector(int* vector)
{
	for (int i = 0; i < sizeOfArrays; i++)
	{
		std::cout << vector[i] << " ";
	}

	std::cout << '\n';
}
//+
void Methods::putMatrix(int** matrix)
{
	for (int i = 0; i < sizeOfArrays; i++)
	{
		for (int j = 0; j < sizeOfArrays; j++)
		{
			std::cout << matrix[i][j] << " ";
		}
		std::cout << '\n';
	}
}
//+
int* Methods::sumOfVectors(int* vector1, int* vector2)
{
	int* resVector = new int[sizeOfArrays];

	for (int i = 0; i < sizeOfArrays; i++)
	{
		resVector[i] = vector1[i] + vector2[i];
	}

	return resVector;
}

//+
int** Methods::multMatrix(int** matrix1, int** matrix2)
{
	int** resultMatrix = new int*[sizeOfArrays];

	for (int i = 0; i < sizeOfArrays; i++)
	{
		resultMatrix[i] = new int[sizeOfArrays];
	}

	for (int i = 0; i < sizeOfArrays; i++)
	{
		for (int j = 0; j < sizeOfArrays; j++)
		{
			resultMatrix[i][j] = 0;
		}

	}

	for (int i = 0; i < sizeOfArrays; i++) {
		for (int j = 0; j < sizeOfArrays; j++) {
			for (int k = 0; k < sizeOfArrays; k++) {
				resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
			}
		}
	}

	return resultMatrix;
}
int** Methods::diffMatrix(int** matrix1, int** matrix2)
{
	int** resultMatrix = new int*[sizeOfArrays];

	for (int i = 0; i < sizeOfArrays; i++)
	{
		resultMatrix[i] = new int[sizeOfArrays];
	}

	for (int i = 0; i < sizeOfArrays; i++) {
		for (int j = 0; j < sizeOfArrays; j++) {
			resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
		}
	}

	return resultMatrix;
}

int* Methods::MultMatrixVector(int** matrixToMultiple, int* vectorToMultiple) {
	int* result = new int[sizeOfArrays];
	for (int i = 0; i < sizeOfArrays; i++) {
		int sum = 0;
		for (int j = 0; j < sizeOfArrays; j++) {
			sum += matrixToMultiple[i][j] * vectorToMultiple[j];
		}
		result[i] = sum;
	}
	return result;
}
//+
int** Methods::transMatrix(int** matrix)
{
	int** transMatr = new int*[sizeOfArrays];

	for (int i = 0; i < sizeOfArrays; i++)
	{
		transMatr[i] = new int[sizeOfArrays];
	}

	for (int i = 0; i < sizeOfArrays; i++)
	{
		for (int j = 0; j < sizeOfArrays; j++)
		{
			transMatr[i][j] = 0;
		}
	}

	for (int i = 0; i < sizeOfArrays; i++) {
		for (int j = 0; j < sizeOfArrays; j++) {
			transMatr[i][j] = matrix[j][i];
		}
	}
	return transMatr;
}
#include "pch.h"
#include <omp.h>
#include <iostream>
#include <ctime>

#include "Function1.h"
#include "Function2.h"
#include "Function3.h"

/**
Labwork for parallel computing based on OpenMP library
*/
void main()
{
	Function1 function1(5);
	Function2 function2(5);
	Function3 function3(5);
	unsigned int start_time;

#pragma omp parallel sections num_threads(4)
	{
		std::cout << omp_get_num_threads()<< std::endl;

#pragma omp section

		function1.StartFunction(start_time);


#pragma omp section

		function2.StartFunction(start_time);


#pragma omp section

		function3.StartFunction(start_time);

	}
	unsigned int end_time = clock();
	std::cout << (float)(end_time - start_time) / 1000;
	system("pause");
}
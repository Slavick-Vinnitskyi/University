#pragma once

#include <vector>
#include <fstream>
#include <Commdlg.h>

using namespace std;

class Table {
private:
	vector<char**> vct;
	int qc = 0;
	int qi = 0;
public:
	char* GetVct(int, int);
	int GetQC();
	int GetQI();
	void ChangeItem(int i, int j, char* str);
	void SetVct(vector<char**>);
	void SetQC(int);
	void SetQI(int);
};
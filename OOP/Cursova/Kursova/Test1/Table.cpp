#include "stdafx.h"
#include "Table.h"

char* Table::GetVct(int i, int j)
{
	return vct[i][j];
}


int Table::GetQC()
{
	return qc;
}

int Table::GetQI()
{
	return qi;
}



void Table::SetVct(vector<char**> Vcts)
{
	vct = Vcts;
}

void Table::ChangeItem(int i, int j, char* str)
{
	strcpy(vct[i][j], str);
}

void Table::SetQI(int QI)
{
	qi = QI;
}

void Table::SetQC(int QC)
{
	qc = QC;
}

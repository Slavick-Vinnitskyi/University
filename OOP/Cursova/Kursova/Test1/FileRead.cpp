#include "stdafx.h"
#include "FileRead.h"

Table* Files::FileOpen(HWND hWnd)
{
	Table*  tb = new Table;
	OPENFILENAME ofn;
	char szFile[100];
	char buff[500];
	int indQC = 0;
	int indQI = 0;
	// open a file name
	ZeroMemory(&ofn, sizeof(ofn));
	ofn.lStructSize = sizeof(ofn);
	ofn.hwndOwner = hWnd;
	ofn.lpstrFile = szFile;
	ofn.lpstrFile[0] = '\0';
	ofn.nMaxFile = sizeof(szFile);
	ofn.lpstrFilter = "Text\0*.TXT\0";
	ofn.nFilterIndex = 1;
	ofn.lpstrFileTitle = NULL;
	ofn.nMaxFileTitle = 0;
	ofn.lpstrInitialDir = NULL;
	ofn.Flags = OFN_PATHMUSTEXIST | OFN_FILEMUSTEXIST;

	if (GetOpenFileName(&ofn))
	{		
		vector<char**> Vct;

		strcpy(filename, ofn.lpstrFile);
		//filename = ofn.lpstrFile;
		ifstream fin;
		fin.open(ofn.lpstrFile, ios::in);
		fin.getline(buff, 500);
		char* pch = strtok(buff, "\t");
		while (pch != NULL)                         // пока есть лексемы
		{
			indQC++;
			pch = strtok(NULL, "\t");
		}




		if (indQC != 0)
		{

			indQI++;

			while (!fin.eof())
			{
				fin.getline(buff, 500);
				indQI++;
			}

			Vct.resize(indQI*indQC);
			int qic = indQI;
			//tb->SetVct(NULL, NULL, NULL, indQI*indQC, NULL);

			indQI = 0;

			fin.seekg(ios::beg);
			while (!fin.eof())
			{
				if (indQI == 82)
				{
					int mam = 0;
					mam++;
				}
				int ind = 0;
				fin.getline(buff, 500);
				char* pch = strtok(buff, "\t");
				/*tb->SetVct(indQI, -1, NULL, -1, indQC);*/
				Vct[indQI] = new char*[indQC];
				while (pch != NULL)                         // пока есть лексемы
				{
					/*tb->SetVct(indQI, ind, NULL, -1, 150);*/
					Vct[indQI][ind] = new char[150];
					/*tb->SetVct(indQI, ind, pch, -1, -1);*/
					strcpy(Vct[indQI][ind], pch);


					//if (strlen(pch) > maxlc[ind]) maxlc[ind] = strlen(pch);

					ind++;
					pch = strtok(NULL, "\t");
				}
				indQI++;
			}
		}
		fin.close();
		if (indQC)
		{
			tb->SetQI(indQI);
			tb->SetQC(indQC);
			tb->SetVct(Vct);
		}
		return tb;
	}
	else
	{
		return NULL;
	}

}

char* Files::GetF()
{
	return filename;
}

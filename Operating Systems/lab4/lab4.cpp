
#include <map>
#include <vector>
//#include <conio.h>
#include <iostream>
#include <algorithm>
#include <iomanip>
 
using namespace std;
 
struct Top
{
    int number;
    int weight;
    vector<Top*> neightbours;
    vector<int> weightEdges;
    bool free = false;
    bool parent = false;
};
void critical(vector<int>* path, int* length, Top top);
void copyVector(vector<int>* dest, vector<int> source);
bool condition(vector<Top*> tops);
 
int main()
{
    int nTops, nEdges;
    cout<<"Enter tops and edges :";
    cin >> nTops >> nEdges;
    vector<int> weightTops;
 
    int** adjacencyMatrix = new int*[nTops];
    for (int i = 0; i < nTops; i++)
    {
        adjacencyMatrix[i] = new int[nTops];
 
        for (int j = 0; j < nTops; j++)
        {
            adjacencyMatrix[i][j] = -1;
        }
    }
 
    for (int i = 0; i < nEdges; i++)
    {   cout<<"Enter num, weightEdge, neightbour "<< i << " : ";
        int num, weightEdge, neightbour;
        cin >> num >> weightEdge >> neightbour;
        adjacencyMatrix[num][neightbour] = weightEdge;
    }
 
    for (int i = 0; i < nTops; i++)
    {
        for (int j = 0; j < nTops; j++)
        {
            cout << setw(3) << adjacencyMatrix[i][j] << " ";
        }
        cout << endl;
    }
 
    for (int i = 0; i < nTops; i++)
    {
        cout<< "weight for tops " << i << " : ";
        int weight;
        cin >> weight;
        weightTops.push_back(weight);
    }
 
    vector<Top*> tops(nTops);
    for (int i = 0; i < nTops; i++)
    {
        for (int j = 0; j < nTops; j++)
        {
            if (tops[i] == nullptr)
                tops[i] = new Top();
 
            tops[i]->number = i;
            tops[i]->weight = weightTops[i];
 
            if (adjacencyMatrix[i][j] > -1)
            {
                if (tops[j] == nullptr)
                    tops[j] = new Top();
 
                tops[i]->neightbours.push_back(tops[j]);
                tops[i]->weightEdges.push_back(adjacencyMatrix[i][j]);
            }
        }
    }
 
    Top* top = new Top();
    top->number = 1;
    top->weight = 2;
 
    Top* top1 = new Top();
    top1->number = 2;
    top1->weight = 2;
 
    Top* top2 = new Top();
    top2->number = 3;
    top2->weight = 2;
    
    Top* top3 = new Top();
    top3->number = 4;
    top3->weight = 1;
    
    top->neightbours.push_back(top1);
    top->neightbours.push_back(top2);
    top->weightEdges.push_back(2);
    top->weightEdges.push_back(4);
    top2->neightbours.push_back(top3);
    top2->weightEdges.push_back(5);
 
    while (condition(tops))
    {
        vector<int> criticalPath;
        int maxLength = 0;
 
        for (int i = 0; i < nTops; i++)
        {
            if (tops[i]->free)
                continue;
 
            vector<int> path;
            int length = 0;
            critical(&path, &length, *tops[i]);
 
            if (length > maxLength)
            {
                maxLength = length;
                copyVector(&criticalPath, path);
            }
        }
        for (int i = 0; i < criticalPath.size(); i++)
        {
            tops[criticalPath[i]]->free = true;
        }
 
        for (int i = 1; i < criticalPath.size(); i++)
        {
            int numEdge;
            for (int j = 0; j < tops[criticalPath[i - 1]]->neightbours.size(); j++)
            {
                if (tops[criticalPath[i - 1]]->neightbours[j]->number == criticalPath[i])
                {
                    numEdge = j;
                }
            }
            tops[criticalPath[i - 1]]->weightEdges[numEdge] = 0;
        }
    }
    for (int i = 0; i < nTops; i++)
    {
        tops[i]->free = false;
    }
    vector<int> criticalPath;
    int maxLength = 0;
 
    for (int i = 0; i < nTops; i++)
    {
        if (tops[i]->free)
            continue;
 
        vector<int> path;
        int length = 0;
        critical(&path, &length, *tops[i]);
 
        if (length > maxLength)
        {
            maxLength = length;
            copyVector(&criticalPath, path);
        }
    }
 
    for (int i = 0; i < criticalPath.size(); i++)
    {
        cout << criticalPath[i] << " ";
    }
    cout << endl; 
}
 void critical(vector<int>* path, int* length, Top top)
{
    path->push_back(top.number);
*length += top.weight;
 
    if (top.neightbours.size() == 0)
        return;
 
    if (top.neightbours.size() > 1)
    {
        int myMax = 0;
        int maxI;
        vector<vector<int>> myPathes;
 
        for (int i = 0; i < top.neightbours.size(); i++)
        {
            if (top.neightbours[i]->free)
                continue;
 
            vector<int> myPath;
            
            copyVector(&myPath, *path);
            int myLength = top.weightEdges[i];
 
            critical(&myPath, &myLength, *top.neightbours[i]);
 
            myPathes.push_back(myPath);
 
            if (myLength >= myMax)
            {
                myMax = myLength;
                maxI = myPathes.size() - 1;
            }
        }
 
        *length += myMax;
        copyVector(path, myPathes[maxI]);
        return;
    }
    
    if (top.neightbours[0]->free)
        return;
 
    critical(path, length, *top.neightbours[0]);
    *length += top.weightEdges[0];
}
void copyVector(vector<int>* dest, vector<int> source)
{
    dest->clear();
    for (int i = 0; i < source.size(); i++)
    {
        dest->push_back(source[i]);
    }
}
bool condition(vector<Top*> tops)
{
    for (int i = 0; i < tops.size(); i++)
    {
        if (!tops[i]->free)
            return true;
    }
    return false;
}

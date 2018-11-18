#include <iostream>
#include "disp.h"

using namespace std;

int main()
{
    cout << "1 - FIFO" << endl;
    int c;
    cin >> c;
    double kv, sv;
    cout << "Enter CPU kvant: ";
    cin >> kv;
    cout << "Enter SV kvant: ";
    cin >> sv;
    Dispather* d;
    if (c == 1)
    { 
        d = new DispatherNoPrt(kv, sv, 2);
    
        d->Add(2, 2);
        d->Add(3, 3);
        d->Add(4, 1);
        d->Add(5, 4);
        d->Add(8, 2);
        d->Do(0, 42);
        cin >> c;
        delete d;
    }
    else
        return -1;
}

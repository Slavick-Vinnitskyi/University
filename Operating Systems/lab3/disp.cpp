
#include <iostream>
#include "disp.h"
using namespace std;


Queue::Queue() : first(NULL), last(NULL), cnt(0) { }
void Queue::Enqueue(int num, int pr)// = -1) // включение
    {
        if (!first)
            first = last = new Task(num, pr);
        else {
            last->next = new Task(num, pr);
            last = last->next;
        }
        cnt++;
    }
void Queue::Enqueue(Task* t) // включение
    {
        if (!first)
            first = last = t;
        else {
            last->next = t;
            last = last->next;
        }
        cnt++;
    }
Task* Queue::Dequeue() // исключение
    {
        if (first) 
        {
            Task* t = first;
            first = first->next;
            cnt--;
            return t;
        }
    }
int Queue::Empty() // пусто?
    {
        return !cnt;
    }

Dispather::Dispather(double kvant, int sv_kvant) : kvant(kvant), n_tasks(0), sv_kvant(sv_kvant){ }

DispatherNoPrt::DispatherNoPrt(double kvant, int sv_kvant, int n_replay) : Dispather(kvant, sv_kvant), n_replay(n_replay) { }

void DispatherNoPrt::Add(int n, int prt)
{
    Q[0].Enqueue(n);
    n_tasks++;
}
void DispatherNoPrt::Do(double t, double T)
{
    int cur_q = 0;
    Task* cur_t;
    double tmAbs = t;
    for (double tm = t; tm <= T;) {
        for (int rep = 0; rep < n_replay; rep++) {
            for (int i = 0; i < n_tasks && tm <= T; i++) {
                cur_t = Q[cur_q].Dequeue();
                cout << "SV " << ' ' << " Time = " << tmAbs << endl;
                tmAbs += sv_kvant;
                cout << "Task #" << cur_t->num << ' ' << "Time = " << tmAbs << endl;
                if (rep == n_replay - 1)
                    Q[cur_q + 1].Enqueue(cur_t);
                else
                    Q[cur_q].Enqueue(cur_t);
                tm += kvant;
                tmAbs += kvant;
            }
        }
        cur_q++;
    }
}

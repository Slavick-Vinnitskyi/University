#pragma once
#ifndef DISP_H
#define DISP_H

#include <iostream>

using namespace std;

struct Task // Структура, определяющая задачу
    {
    int pr; // приоритет
    int num; // номер
    Task* next; // следующая задача
    Task(int num, int pr = -1){};
};

class Queue // класс очереди
{
    Task *first, *last;

public:
    int cnt;
    Queue();
    void Enqueue(int num, int pr = -1);
    void Enqueue(Task* t) ;// включение
    
    Task* Dequeue();// исключение
    
    int Empty(); // пусто?
    
};

class Dispather { // базовый класс диспетчера
 
protected:
    double kvant; // квант CPU, выделяемый задаче
    int n_tasks; // количество задач
    int sv_kvant; // квант SV
    Queue Q[10]; // массив очередей
public:
    Dispather(double kvant, int sv_kvant);
    virtual void Add(int n, int prt) {}; // длбавить задачу
    virtual void Do(double t, double T) {}; // выполнять
};

class DispatherNoPrt : public Dispather // класс диспетчера со смешанным алгоритмом
{
    int n_replay; // количество повторений
public:
    DispatherNoPrt(double kvant, int sv_kvant, int n_replay);
    
    void Add(int n, int prt = -1);
    void Do(double t, double T);
};

#endif

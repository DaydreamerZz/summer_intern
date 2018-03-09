//
// Created by lab2 on 18-3-7.
//

#ifndef QUEUE_H
#define QUEUE_H

#define QUEUE_INIT_SIZE 3

typedef int ElemType;

typedef struct ArrayQueue{
    int front, rear;
    ElemType queue[QUEUE_INIT_SIZE];
}ArrayQueue;


ArrayQueue *init_array_queue();

int is_empty(ArrayQueue *arrayQueue);

void enque(ArrayQueue *arrayQueue, ElemType value);

void deque(ArrayQueue *arrayQueue, ElemType *value);

void print_array_queue(ArrayQueue *arrayQueue);


#endif //INTERVIEW_QUEUE_H

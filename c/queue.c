//
// Created by lab2 on 18-3-7.
//

#include <stdio.h>
#include <stdlib.h>
#include "queue.h"

ArrayQueue *init_array_queue()
{
    ArrayQueue *arrayQueue = NULL;
    arrayQueue = malloc(sizeof(ArrayQueue));
    if(!arrayQueue){
        printf("malloc error\n");
        return NULL;
    }
    arrayQueue->front = arrayQueue->rear = 0;
    return arrayQueue;
}

int is_empty(ArrayQueue *arrayQueue){
    return arrayQueue->front==arrayQueue->rear?1:0;
}

void enque(ArrayQueue *arrayQueue, ElemType value)
{
    if((arrayQueue->rear+1)%QUEUE_INIT_SIZE == arrayQueue->front){
        printf("queue full\n");
        return;
    }
    arrayQueue->queue[arrayQueue->rear] = value;
    arrayQueue->rear = (arrayQueue->rear+1) % QUEUE_INIT_SIZE;
    return;
}

void deque(ArrayQueue *arrayQueue, ElemType *value){
    if(is_empty(arrayQueue)){
        printf("queue empty\n");
        return;
    }
    *value = arrayQueue->queue[arrayQueue->front];
    arrayQueue->front = (arrayQueue->front+1) % QUEUE_INIT_SIZE;
    return;
}

void print_array_queue(ArrayQueue *arrayQueue);
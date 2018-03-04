//
// Created by lab2 on 18-3-2.
//

#ifndef STACK_H
#define STACK_H

#define STACK_INIT_SIZE 20
#define STACK_INCREMENT 20

typedef int ElemType;
typedef int Status;


typedef struct StackL{
    ElemType *base;
    ElemType *top;
    int size;
}StackL;


typedef struct StackA{
    ElemType base[STACK_INIT_SIZE];
    int stackSize;
    int top;
}StackA;


StackL *init_stackl();
void free_stackl(StackL *s);

Status push_stackl(StackL *s, ElemType e);
Status pop_stackl(StackL *s, ElemType *e);

void stackl_print(StackL *s);

//------------------------------------------------------------
//数组stack

ElemType *init_stacka();
void free_stacka();

Status push_stacka(StackA *s, ElemType e);
Status pop_stacka(StackA *s, ElemType *e);

void stacka_print(StackA *s);
#endif //INTERVIEW_STACK_H

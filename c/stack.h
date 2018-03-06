//
// Created by lab2 on 18-3-2.
//

#ifndef STACK_H
#define STACK_H

#define STACK_INIT_SIZE 20
#define STACK_INCREMENT 20

typedef int ElemType;
typedef int Status;


typedef struct LinkStack{
    ElemType *base;
    ElemType *top;
    int size;
}LinkStack;


typedef struct ArrayStack{
    ElemType base[STACK_INIT_SIZE];
    int stackSize;
    int top;
}ArrayStack;

//-----------------------------------------------------------
//也是数组的stack,但是是指针的
LinkStack *init_link_stack();
void free_link_stack(LinkStack *s);

Status push_link_stack(LinkStack *s, ElemType e);
Status pop_link_stack(LinkStack *s, ElemType *e);

void link_stack_print(LinkStack *s);

//------------------------------------------------------------
//数组stack

ArrayStack *init_array_stack();
void free_array_stack(ArrayStack *s);

Status push_array_stack(ArrayStack *s, ElemType e);
Status pop_array_stack(ArrayStack *s, ElemType *e);

void array_stack_print(ArrayStack *s);
#endif //INTERVIEW_STACK_H

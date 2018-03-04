//
// Created by lab2 on 18-3-2.
//

#include <stdlib.h>
#include <stdio.h>
#include "stack.h"


StackL *init_stackl(){
    StackL *s = malloc(sizeof(StackL));
    if(!s){
        printf("malloc error\n");
        return NULL;
    }
    s->base = (ElemType *)malloc(sizeof(ElemType) * STACK_INIT_SIZE);
    s->top = s->base;
    s->size = STACK_INIT_SIZE;
    return s;
}
void free_stackl(StackL *s)
{
    if(!s){
        printf("NULL stack\n");
        return;
    }
    free(s->base);
    free(s);
    return;
}

Status push_stackl(StackL *s, ElemType e)
{
    if(s == NULL){
        printf("NULL stack\n");
        return -1;
    }
    if((s->top - s->base) >= s->size) {
        s->base = (ElemType *) realloc(s->base, sizeof(ElemType) * (s->size + STACK_INCREMENT));
        if(!s){
            printf("realloc error\n");
            return NULL;
        }
        s->top = s->base + s->size;
        s->size += STACK_INCREMENT;
    }
    *(s->top) = e;
    ++(s->top);
    return 1;
}

Status pop_stackl(StackL *s, ElemType *e)
{
    if(!s){
        printf("NULL stack\n");
        return -1;
    }
    if(s->top == s->base){
        printf("Empty stack\n");
        return 0;
    }
    --(s->top);
    *e = *(s->top);
    return -1;
}

void stackl_print(StackL *s)
{
    if(!s){
        printf("NULL stack\n");
        return;
    }

    ElemType *e = s->base;
    for(; e != s->top; e++){
        printf("%d\t", *e);
    }
    printf("\n");

}



ElemType *init_stacka()
{
    ElemType *stack = (ElemType *)malloc(sizeof(StackA));
    return stack;
}
void free_stacka();

Status push_stacka(StackA *s, ElemType e)
{
    if(!s){
        printf("NULL stack\n");
        return -1;
    }
    if(s->stackSize == STACK_INIT_SIZE){
        printf("stack full\n");
        return -1;
    }
    s->base[s->stackSize++] = e;

}
Status pop_stacka(StackA *s, ElemType *e);

void stacka_print(StackA *s)
{
    int len = s->stackSize;
    for(; len > 0; len--){
        printf("%d\t", s->base[len]);
    }

}


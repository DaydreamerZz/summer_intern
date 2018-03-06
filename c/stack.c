//
// Created by lab2 on 18-3-2.
//

#include <stdlib.h>
#include <stdio.h>
#include "stack.h"


LinkStack *init_link_stack(){
    LinkStack *s = malloc(sizeof(LinkStack));
    if(!s){
        printf("malloc error\n");
        return NULL;
    }
    s->base = (ElemType *)malloc(sizeof(ElemType) * STACK_INIT_SIZE);
    s->top = s->base;
    s->size = STACK_INIT_SIZE;
    return s;
}
void free_link_stack(LinkStack *s)
{
    if(!s){
        printf("NULL stack\n");
        return;
    }
    free(s->base);
    free(s);
    return;
}

Status push_link_stack(LinkStack *s, ElemType e)
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

Status pop_link_stack(LinkStack *s, ElemType *e)
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

void link_stack_print(LinkStack *s)
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



ArrayStack *init_array_stack()
{
    ArrayStack *stack = (ElemType *)malloc(sizeof(ArrayStack));
    stack->stackSize = STACK_INIT_SIZE;
    stack->top = 0;
    return stack;
}
void free_array_stack(ArrayStack *s)
{
    if(!s){
        printf("NULL stack\n");
        return;
    }
    free(s->base);
    free(s);
}

Status push_array_stack(ArrayStack *s, ElemType e)
{
    if(!s){
        printf("NULL stack\n");
        return -1;
    }
    if(s->top == STACK_INIT_SIZE){
        printf("stack full\n");
        return -1;
    }
    s->base[s->top++] = e;

}
Status pop_array_stack(ArrayStack *s, ElemType *e)
{
    if(!s){
        printf("NULL stack\n");
        return -1;
    }
    if(s->top == 0){
        printf("Empty stack\n");
        return -1;
    }else{
        *e = s->base[--(s->top)];
    }

}

void array_stack_print(ArrayStack *s)
{
    int len = s->top-1;
    for(; len >= 0; len--){
        printf("%d\t", s->base[len]);
    }

}


//
// Created by lab2 on 18-3-2.
//

#ifndef INTERVIEW_LIST_H
#define INTERVIEW_LIST_H

typedef struct node{
    int value; // size = 4
    struct node *next; // size = 8
}node; //size = 16,因为对齐

node *add_to_tail(node *head, int value);

void show_list(node *head);

void remove_node(node *head, int value);

void print_list_reversingly(node *head);
void print_list_reversingly_recursively(node *head);

#endif //INTERVIEW_LIST_H

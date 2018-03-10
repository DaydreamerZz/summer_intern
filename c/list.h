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

void print_list(node *head);

void remove_node(node *head, int value);

void print_list_reversingly(node *head);
void print_list_reversingly_recursively(node *head);

node *find_kth_to_tail(node *head, int k);

node *reverse_list(node *head);
node *reverse_list_recursively(node *head);

node *merge_list(node *first, node *second);
#endif //INTERVIEW_LIST_H

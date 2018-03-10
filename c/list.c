//
// Created by lab2 on 18-3-2.
//
#include <stdio.h>
#include <stdlib.h>
#include "list.h"

/*
 * 打印完整链表
 */
void print_list(node *head)
{
    if(head == NULL){
        printf("Null list\n");
        return;
    }
    while(head != NULL){
        printf("%d\t", head->value);
        head = head->next;
    }

    printf("\n");
}

/*
 * 在链表尾部添加一个node
 */
node *add_to_tail(node *head, int value)
{
    node *new_node = malloc(sizeof(node));
    new_node->value = value;
    new_node->next = NULL;

    node *current_head = head;
    if(head == NULL){
        head = new_node;
    }else{
        while(current_head->next != NULL)
            current_head = current_head->next;
        current_head->next = new_node;
    }
    return head;
}


/*
 * 删除链表中第一次出现value的节点
 */
void remove_node(node *head, int value)
{
    if(head == NULL)
        return;

    node *pre_head = malloc(sizeof(node));
    pre_head->next = head;

    while(head != NULL){
        if(head->value == value){
            pre_head->next = head->next;
            free(head);
            break;
        }else{
            pre_head = head;
            head = head->next;
        }

    }
}

void print_list_reversingly(node *head)
{
    if(head == NULL)
        return;

    int arr[100];
    int arr_index = 0;

    while(head != NULL){
        arr[arr_index++] = head->value;
        head = head->next;
    }

    for(int i = arr_index-1; i >= 0; i--){
        printf("%d\t", arr[i]);
    }
    printf("\n");
}


void print_list_reversingly_recursively(node *head)
{
    if(head != NULL){
        if(head->next != NULL){
            print_list_reversingly_recursively(head->next);
        }
        printf("%d\t", head->value);
    }

}

node *find_kth_to_tail(node *head, int k)
{
    if(head == NULL){
        printf("Null list\n");
        return NULL;
    }else if(k <= 0){
        printf("k must big than 1\n");
        return NULL;
    }
    node *first = head;
    node *second = head;
    int index = 0;
    while(first != NULL){
        first = first->next;
        index++;
        if(index == k)
            break;
    }
    if(index < k){
        printf("Not enough node in this list\n");
        return NULL;
    }else{
        while(first != NULL){
            first = first->next;
            second = second->next;
        }
    }
    return second;

}

node *reverse_list(node *head)
{
    if(head == NULL){
        printf("Null list\n");
        return NULL;
    }
    node *currentNode = head->next;
    head->next = NULL;
    node *pNext = NULL;
    while(currentNode != NULL){
        pNext = currentNode;
        currentNode = currentNode->next;
        pNext->next = head;
        head = pNext;
    }
    return head;
}

node *reverse_list_recursively(node *head)
{
    return NULL;
}

node *merge_list(node *first, node *second)
{
    if(first == NULL && second == NULL)
        return NULL;
    else if(first == NULL && second != NULL){
        return second;
    }else if(first != NULL && second == NULL){
        return first;
    }
    node *head = malloc(sizeof(node));
    node *currentHead = head;
    while(first != NULL && second != NULL){
        if(first->value <= second->value){
            currentHead->next = first;
            currentHead = currentHead->next;
            first = first->next;
        }else{
            currentHead->next = second;
            currentHead = currentHead->next;
            second = second->next;
        }
    }
    if(first == NULL && second != NULL)
        currentHead->next = second;
    if(second == NULL && first != NULL)
        currentHead->next = first;
    return head->next;
}
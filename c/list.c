//
// Created by lab2 on 18-3-2.
//
#include <stdio.h>
#include <stdlib.h>
#include "list.h"

/*
 * 打印完整链表
 */
void show_list(node *head)
{
    if(head == NULL)
        return;
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


void print_list_reversingly_recursively(node *head){
    if(head != NULL){
        if(head->next != NULL){
            print_list_reversingly_recursively(head->next);
        }
        printf("%d\t", head->value);
    }

}

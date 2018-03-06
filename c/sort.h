//
// Created by lab2 on 18-3-5.
//

#ifndef SORT_H
#define SORT_H


//插入排序
void insert_sort(int array[], int len);
void shell_sort(int array[], int len);


//交换排序
void bubble_sort(int array[], int len);
void quick_sort(int array[], int left, int right);


//选择排序
void select_sort(int array[], int len);


void print_array(int array[], int len);


#endif //SORT_H

//
// Created by lab2 on 18-3-5.
//
#include <stdio.h>
#include "sort.h"
#include <stdbool.h>
// 1 3 4 2 9 6 7 5
void insert_sort(int array[], int len)
{
    if(array == NULL || len <= 0)
        return;
    int i, j, tmp;

    for(i = 1; i < len; i++){
        tmp = array[i];
        if(tmp < array[i-1]){//如果后一个比前一个大,就不需要再交换了
            for(j = i - 1; j > 0 && array[j] > tmp; j--){
                array[j+1] = array[j];
            }
            array[j+1] = tmp;
        }
    }
}

void shell_sort(int array[], int len)
{
    if(array == NULL || len <= 0)
        return;
    int h, i, j, tmp;
    for(h = len/2; h > 0; h=h/2){
        for(i = h; i < len; i++){
            tmp = array[i];
            for(j = i-h; j>=0 && array[j] > tmp; j-=h){
                array[j+h] = array[j];
            }
            array[j+h] = tmp;
        }
    }
}

void bubble_sort(int array[], int len)
{
    if(array == NULL || len <= 0)
        return;

    int i, j, tmp;
    bool flag;
    for(i = 0; i < len; i++){
        flag = false;
        for(j = 0; j < len-1-i; j++){
            if(array[j] > array[j+1]){
                tmp = array[j];
                array[j] = array[j+1];
                array[j+1] = tmp;
                flag = true;
            }
        }
        if(!flag)
            break;
    }
}

void quick_sort(int array[], int left, int right)
{
    if(left < right){

        int i = left, j = right;
        int pivot = array[left];
        while(i < j){ //while(left < right)
            while(i < j && array[j] >= pivot)
                j--;
            if(i < j)
                array[i++] = array[j];

            while(i < j && array[i] <= pivot)
                i++;
            if(i < j)
                array[j--] = array[i];
        }

        array[i] = pivot;
        quick_sort(array, left, i-1);
        quick_sort(array, i+1, right);
    }
}

void select_sort(int array[], int len)
{
    if(!array || len <= 0)
        return;
    int i, j, tmpMin, tmp;
    for(i = 0; i < len; i++){
        tmpMin = i;
        for(j = i; j < len; j++){
            if(array[j] < array[tmpMin])
                tmpMin = j;
        }
        tmp = array[i];
        array[i] = array[tmpMin];
        array[tmpMin] = tmp;
    }
}

void print_array(int array[], int len)
{
    if(array == NULL ||  len <=0)
        return;
    int i = 0;
    while(i < len){
        printf("%d\t", array[i++]);
    }
    printf("\n");
}
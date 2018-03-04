#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

#include "list.h"
#include "stack.h"

int str_to_int(char *str);
bool find_in_matrix(int matrix[][4], int rows, int columns, int number);
bool find_in_matrix2(int *matrix, int rows, int columns, int number);
void replace_blank(char string[], int length);
int *merge_two_sorted_array(int array1[], int len1, int array2[], int len2, int len);



int main()
{
    init_link_stack();
    return 0;
}

int str_to_int(char *str)
{
    if(str == NULL)
        return -1;
    int positive_or_negative = 0;
    int value = 0;
    if(*str == '+'){
        positive_or_negative = 1;
        str++;
    }else if(*str == '-'){
        positive_or_negative = 0;
        str++;
    }

    while(*str != 0){

        if(*str < '0' || *str > '9')
            return -1;

        value = value * 10 + (*str - '0');
        str++;
    }

    if(positive_or_negative == 1)
        return value;
    else
        return 0-value;
}


bool find_in_matrix(int matrix[][4], int rows, int columns, int number)
{
    bool is_find = false;
    if(matrix != NULL && rows > 0 && columns > 0){
        int row = 0;
        int column = columns - 1;
        while(row < rows && column > 0){
            if(matrix[row][column] == number){
                is_find = true;
                break;
            }
            else if(matrix[row][column] > number)
                column--;
            else
                row++;
        }
    }
    return is_find;
}

bool find_in_matrix2(int *matrix, int rows, int columns, int number){
    bool is_find = false;
    if(matrix != NULL && rows > 0 && columns > 0){
        int row = 0;
        int column = columns - 1;
        while(row < rows && column > 0){
//            if(*(matrix+row*columns+column) == number){
            if(matrix[row*columns+column] == number){
                is_find = true;
                break;
            }else if(*(matrix+row*columns+column) > number)
                column--;
            else
                row++;
        }
    }
    return is_find;
}

void replace_blank(char string[], int length)
{
    if(string == NULL || length <= 0)
        return;

    int blank_count = 0;
    int origin_length = 0;
    char *start = string;
    while(*start != 0){
        if(*start == ' ')
            blank_count += 1;
        origin_length++;
        start++;
    }

    int new_length = origin_length + blank_count * 2;
    if(new_length > length)
        return;

    int index_of_origin = origin_length;
    int index_of_new = new_length;
    while(index_of_origin >= 0){
        if(string[index_of_origin] == ' '){
            string[index_of_new--] = '0';
            string[index_of_new--] = '2';
            string[index_of_new--] = '%';
        }else{
            string[index_of_new--] = string[index_of_origin];
        }

        index_of_origin--;
    }

}

int* merge_two_sorted_array(int array1[], int len1, int array2[], int len2, int len)
{
    if(len1 < 0 || len2 < 0)
        return NULL;
    if(array1 == NULL || len1 == 0)
        return array2;
    else if(array2 == NULL || len2 == 0)
        return array1;
    int total_len = len1 + len2;
    if(total_len > len)
        return NULL;

    int index_of_array1 = len1-1;
    int index_of_array2 = len2-1;
    int index_of_new = total_len-1;
    while(index_of_array1 >= 0 || index_of_array2 >=0){
        if(array1[index_of_array1] >= array2[index_of_array2]){
            array1[index_of_new] = array1[index_of_array1];
            index_of_array1--;
            index_of_new--;
        }else{
            array1[index_of_new] = array2[index_of_array2];
            index_of_array2--;
            index_of_new--;
        }
    }
    return array1;

}

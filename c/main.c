#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <assert.h>

#include "list.h"
#include "stack.h"
#include "sort.h"
#include "queue.h"


#define MIN(a, b) ((a)<(b)?(a):(b))

int str_to_int(char *str);
bool find_in_matrix(int matrix[][4], int rows, int columns, int number);
bool find_in_matrix2(int *matrix, int rows, int columns, int number);
void replace_blank(char string[], int length);
int *merge_two_sorted_array(int array1[], int len1, int array2[], int len2, int len);
int min_rotate_array(int *arr, int length);

long long stupid_fibonacci_recursive(int n);
int smart_finonacci(int n);

int count_one_positive(int n);
int count_one_negative(int n);
int count_ont_master(int n);

int d_to_b(char *binary, int n);

double pow_test(double base, int exponent);

//打印从1到n位数,由于n可能很大,用字符数组表示n位数
void print_1_to_maxofdigitals(int n);
bool increase(char *numbers); //增加
void print_number(char *numbers); //打印

void reorder_odd_even(int *array, int length);
void reorder_smart(int *array, int length);

int main()
{
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

int min_rotate_array(int *arr, int length)
{
    if(arr == NULL || length <= 0)
        return -1;
    int left = 0, right = length-1;
    int mid = 0; //mid初始值为1是因为如果原本就是递增的,那么不进入while
    while(arr[left] >= arr[right]){
        if(right - left == 1){
            mid = right;
            break;
        }

        mid = (left+right)/2;
        if(arr[mid] >= arr[left])
            left = mid;
        else if(arr[mid] <= arr[right])
            right = mid;
    }
    printf("%d\n", arr[mid]);
}

long long stupid_fibonacci_recursive(int n)
{
    if(n <= 0)
        return 0;
    else if(n == 1)
        return 1;
    return stupid_fibonacci_recursive(n - 1)+ stupid_fibonacci_recursive(n - 2);
}
int smart_finonacci(int n)
{
    int i = 0, j = 1;
    int tmp = 0;
    if(n <= 0)
        return i;
    else if(n == 1)
        return j;
    else{
        while(n >= 2){
            tmp = i;
            i = j;
            j = j + tmp;
            n --;
        }
    }
    return j;
}


int count_one_positive(int n)
{
    int count = 0;
    while(n){
        if(n & 1)
            count++;
        n = n >> 1;
    }
    return count;
}
int count_one_negative(int n)
{
    int count = 0;
    unsigned int flag = 1;
    while(flag){
        if(n & flag)
            count++;
        flag = flag << 1;
    }
    return count;
}
int count_ont_master(int n)
{
/*
 * 比如12,1100,那么减一会得到1011,而1100&1011得到1000,也就是消掉了最右边的一个1.
 */
    int count = 0;
    while(n){
        count++;
        n = (n-1)&n;
    }
    return count;
}


int d_to_b(char *binary, int n)
{
    int index = 0;
    int tmp = 0;
    while(n != 0){
        tmp = n % 2;
        binary[index++] = tmp+'0';
        n = n / 2;
    }
    binary[index] = '\0';
    return index;
}

double pow_test(double base, int exponent)
{
    double base_zero = 0.0;
    if(base - base_zero < 0.000001 && base - base_zero > -0.00001){ //check if base is 0
        return base_zero;
    }

    unsigned int absExponent = (unsigned int)exponent;
    if(exponent == 0){
        return 1.0;
    }else if(exponent < 0){
        absExponent = (unsigned int)(-exponent);
    }

    double res = 1.0;
    int index;
    for(index = 0; index < absExponent; index++){
        res = res * base;
    }

    if(exponent < 0)
        res = 1.0 / res;
    return res;

}


bool increase(char *numbers) //增加
{
    int takeOver = 0; //用来表示进位
    int length = strlen(numbers);
    bool isOver = false;

    for(int i = length-1; i >= 0; i--){
        int currentNumber = numbers[i] - '0' + takeOver;
        if(i == length-1){
            currentNumber += 1;
        }
        if(currentNumber >= 10){
            if(i == 0){
                isOver = true;
                break;
            }else{

                numbers[i] = '0';
                takeOver = 1;
            }
        }else{
            numbers[i] = '0' + currentNumber;
            break;
        }
    }
    return isOver;
}
void print_number(char *numbers) //打印
{
    bool startPrint = false;
    int length = strlen(numbers);
    int index;
    for(index = 0; index < length; index++){
        if(numbers[index] == '0')
            continue;
        else
            break;
    }
    for(; index < length; index++){
        printf("%c", numbers[index]);
    }
    printf("\n");

}
void print_1_to_maxofdigitals(int n)
{
    if(n <= 0)
        return;
    char numbers[n+1];
    memset(numbers, '0', n);
    numbers[n] = '\0';
    while(!increase(numbers)){
        print_number(numbers);
    }
    return;
}


void reorder_odd_even(int *array, int length)
{

    if(array == NULL || length <= 0)
        return;
    int left = 0, right = length-1;
    while(left < right){
        while(array[left] % 2  == 1){ //(array[left] & 0x1) != 0
            left++;
        }
        while(array[right] % 2 == 0){
            right--;
        }
        if(left < right){
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
    }
    return;

}
int func(int value)
{
    if(value % 3 == 0)
        return 1;
    else
        return 0;
}
void reorder_smart(int *array, int length)
{
    if(array == NULL || length <= 0)
        return;
    int left = 0, right = length-1;
    while(left < right){
        while(func(array[left])){
            left++;
        }
        while(!func(array[right])){
            right--;
        }
        if(left < right){
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
    }
    return;
}
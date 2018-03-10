cmake_minimum_required(VERSION 3.9)
project(interview C)

set(CMAKE_C_STANDARD 99)

add_executable(interview main.c stack.c stack.h sort.c sort.h queue.c queue.h list.h list.c)
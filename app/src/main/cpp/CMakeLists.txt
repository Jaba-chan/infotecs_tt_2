
cmake_minimum_required(VERSION 3.22.1)

project("infotecs_tt_2")

add_library(${CMAKE_PROJECT_NAME} SHARED
        native-lib.cpp)

target_link_libraries(${CMAKE_PROJECT_NAME}
        android
        log)
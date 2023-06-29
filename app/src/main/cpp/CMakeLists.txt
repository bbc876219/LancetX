cmake_minimum_required(VERSION 3.22.1)
project(app)

find_package(bytehook REQUIRED CONFIG)

# libhookee.so
add_library(hookee SHARED hookee.c)
target_compile_features(hookee PUBLIC c_std_11)
target_compile_options(hookee PUBLIC -Weverything -Werror)
target_link_libraries(hookee log)

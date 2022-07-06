package com.sparta.bart.sortmanager;

import com.sparta.bart.sortmanager.model.BinarySort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinarySortTest {
    BinarySort binarySort;

    int[] empty   = new int[0];
    int[] small   = new int[] {17, 28, 10, 43, 32};
    int[] smallSorted = new int[] {10, 17, 28, 32, 43};
    int[] large   = new int[] {5, 20, 29, 45, 17, 14, 47, 40, 13, 38, 19, 8, 22, 21, 1, 24, 26, 12, 27, 13, 5, 16, 21, 43, 16, 23, 49, 50, 48, 14, 43, 40, 11, 32, 28, 35, 12, 14, 28, 8, 36, 41, 1, 34, 48, 31, 23, 23, 39, 23, 19, 20, 13, 31, 10, 28, 7, 43, 19, 14, 16, 30, 13, 4, 40, 33, 26, 19, 46, 32, 21, 36, 2, 14, 10, 4, 7, 37, 44, 48, 7, 41, 12, 46, 29, 40, 22, 27, 38, 36, 7, 40, 48, 46, 1, 35, 45, 43, 25, 30, 34, 7, 14, 31, 38, 32, 19, 14, 31, 22, 40, 8, 11, 23, 13, 11, 2, 7, 11, 9, 24, 48, 30, 9, 50, 9, 37, 35, 48, 48, 38, 27, 31, 33, 21, 20, 23, 27, 1, 20, 2, 18, 48, 46, 21, 13, 9, 15, 47, 16, 17, 21, 6, 30, 24, 15, 35, 24, 39, 13, 25, 26, 13, 39, 36, 10, 19, 24, 10, 36, 5, 8, 17, 15, 11, 48, 10, 13, 43, 12, 9, 13, 10, 10, 26, 43, 19, 22, 22, 6, 12, 21, 11, 5, 17, 8, 41, 13, 5, 25, 7, 21, 4, 18, 32, 42, 27, 16, 1, 13, 7, 2, 21, 9, 3, 41, 1, 40, 9, 3, 32, 4, 50, 38, 27, 26, 18, 24, 14, 15, 1, 42, 32, 14, 7, 41, 33, 41, 40, 29, 24, 18, 14, 12, 35, 4, 4, 41, 11, 27, 29, 6, 33, 45, 20, 11, 50, 22, 40, 2, 28, 37, 11, 32, 17, 20, 20, 47, 40, 28, 28, 33, 49, 10, 30, 44, 19, 41, 31, 47, 50, 48, 33, 3, 24, 1, 28, 49, 4, 5, 17, 28, 16, 28, 34, 21, 35, 12, 19, 24, 41, 11, 8, 26, 47, 33, 33, 22, 46, 42, 35, 26, 43, 46, 19, 45, 6, 27, 37, 9, 1, 24, 4, 43, 27, 13, 2, 12, 39, 9, 1, 27, 11, 2, 21, 4, 8, 24, 4, 3, 14, 23, 11, 26, 22, 49, 26, 23, 25, 45, 30, 43, 45, 19, 46, 9, 47, 9, 27, 26, 42, 19, 4, 23, 13, 16, 41, 17, 10, 19, 46, 27, 16, 41, 25, 11, 39, 27, 10, 37, 20, 29, 48, 18, 15, 46, 9, 40, 10, 2, 12, 30, 10, 26, 41, 14, 21, 29, 25, 29, 1, 49, 40, 22, 47, 41, 8, 15, 36, 48, 18, 36, 42, 1, 6, 16, 18, 13, 25, 27, 21, 47, 4, 46, 49, 15, 40, 17, 34, 14, 6, 32, 38, 47, 19, 35, 2, 8, 27, 15, 50, 28, 48, 18, 23, 12, 28, 32, 46, 7, 18, 49, 43, 46, 3, 12, 15, 31, 17, 17, 32, 41, 8, 14, 1, 7, 16, 27, 27, 46, 17, 49, 33, 43, 12, 44, 30, 7, 25, 23, 43, 35, 13, 29, 38, 22, 25, 18, 6, 1, 6, 9, 20, 39, 20, 12, 44, 10, 29, 12};
    int[] largeSorted = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 29, 29, 29, 29, 29, 29, 29, 29, 29, 30, 30, 30, 30, 30, 30, 30, 30, 31, 31, 31, 31, 31, 31, 31, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 33, 33, 33, 33, 33, 33, 33, 33, 33, 34, 34, 34, 34, 35, 35, 35, 35, 35, 35, 35, 35, 35, 36, 36, 36, 36, 36, 36, 36, 37, 37, 37, 37, 37, 38, 38, 38, 38, 38, 38, 38, 39, 39, 39, 39, 39, 39, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 42, 42, 42, 42, 42, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 44, 44, 44, 44, 45, 45, 45, 45, 45, 45, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 47, 47, 47, 47, 47, 47, 47, 47, 47, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 49, 49, 49, 49, 49, 49, 49, 49, 50, 50, 50, 50, 50, 50};
    int[] extreme = new int[] {26, 11, 6, 34, 42, 39, 46, 12, 10, 5, 37, 40, 24, 9, 40, 16, 15, 37, 27, 4, 10, 32, 11, 26, 3, 41, 47, 35, 17, 38, 45, 24, 13, 28, 44, 1, 7, 37, 49, 50, 31, 30, 36, 44, 48, 29, 32, 29, 14, 28, 4, 45, 23, 33, 25, 37, 44, 50, 5, 7, 32, 25, 3, 26, 11, 24, 42, 24, 37, 37, 12, 24, 32, 50, 5, 39, 50, 42, 1, 50, 16, 41, 8, 9, 30, 7, 34, 50, 4, 29, 30, 29, 44, 34, 25, 38, 29, 22, 5, 26, 32, 25, 10, 32, 13, 27, 3, 10, 13, 19, 2, 19, 18, 41, 13, 34, 34, 33, 41, 21, 36, 14, 29, 26, 27, 15, 24, 21, 34, 40, 29, 16, 41, 15, 30, 44, 47, 48, 48, 29, 9, 43, 4, 43, 44, 37, 44, 39, 17, 33, 25, 45, 28, 23, 36, 49, 16, 49, 28, 24, 17, 49, 3, 10, 25, 23, 9, 50, 49, 12, 5, 5, 8, 48, 45, 19, 49, 6, 21, 39, 34, 4, 13, 49, 2, 33, 1, 39, 2, 19, 20, 20, 38, 39, 26, 1, 25, 34, 17, 16, 38, 27, 40, 10, 17, 43, 17, 36, 48, 37, 43, 23, 30, 8, 22, 26, 40, 27, 33, 28, 34, 30, 39, 4, 28, 21, 44, 19, 43, 43, 26, 48, 5, 41, 39, 48, 39, 47, 15, 42, 33, 38, 11, 42, 47, 44, 22, 21, 37, 3, 9, 4, 29, 48, 38, 11, 15, 35, 41, 1, 45, 40, 42, 20, 50, 50, 12, 15, 8, 4, 46, 10, 1, 17, 41, 50, 46, 12, 45, 41, 28, 40, 13, 37, 24, 49, 38, 44, 19, 21, 23, 11, 8, 16, 45, 42, 27, 7, 44, 50, 16, 25, 46, 30, 39, 11, 2, 11, 13, 13, 28, 22, 50, 4, 10, 16, 13, 4, 46, 8, 43, 3, 46, 40, 50, 21, 38, 3, 10, 6, 41, 40, 26, 50, 16, 42, 1, 5, 3, 37, 40, 44, 50, 37, 10, 27, 13, 14, 20, 24, 27, 9, 6, 3, 46, 28, 32, 2, 3, 37, 48, 18, 22, 1, 37, 42, 7, 23, 31, 15, 43, 19, 12, 14, 28, 46, 41, 19, 2, 50, 31, 43, 36, 14, 31, 27, 10, 37, 9, 16, 12, 19, 37, 35, 44, 15, 46, 50, 31, 45, 1, 14, 20, 14, 43, 34, 19, 37, 2, 49, 48, 17, 5, 1, 7, 23, 13, 35, 36, 29, 6, 1, 2, 33, 19, 11, 24, 39, 38, 46, 8, 43, 43, 8, 6, 47, 37, 3, 6, 47, 44, 40, 37, 5, 36, 8, 12, 5, 6, 10, 10, 23, 36, 25, 12, 38, 17, 50, 39, 29, 36, 22, 33, 43, 37, 25, 35, 31, 9, 25, 15, 1, 4, 31, 9, 2, 35, 6, 48, 17, 33, 22, 10, 30, 4, 34, 21, 2, 40, 17, 15, 15, 27, 1, 31, 44, 39, 21, 35, 4, 39, 12, 29, 21, 45, 14, 23, 5, 11, 28, 46, 13, 50, 5, 42, 7, 31, 3, 32, 35, 23, 41, 9, 2, 16, 18, 34, 12, 34, 8, 28, 20, 48, 44, 16, 35, 42, 15, 25, 45, 21, 11, 7, 37, 31, 40, 18, 21, 35, 32, 39, 42, 46, 21, 25, 50, 50, 22, 6, 50, 13, 46, 47, 38, 39, 44, 4, 24, 25, 10, 22, 15, 27, 5, 1, 45, 30, 23, 8, 25, 26, 16, 18, 4, 6, 19, 28, 7, 43, 28, 36, 6, 46, 29, 4, 16, 28, 31, 23, 49, 19, 25, 12, 42, 21, 25, 39, 38, 44, 26, 16, 6, 6, 43, 44, 35, 14, 45, 10, 30, 29, 9, 27, 10, 10, 44, 1, 47, 8, 32, 31, 15, 22, 48, 41, 15, 41, 28, 22, 48, 49, 36, 46, 45, 38, 36, 49, 46, 15, 41, 36, 36, 20, 37, 3, 15, 42, 14, 32, 47, 30, 32, 11, 45, 23, 49, 29, 13, 31, 8, 23, 13, 26, 13, 9, 30, 40, 1, 34, 22, 2, 31, 17, 45, 1, 12, 40, 31, 21, 27, 43, 4, 47, 28, 22, 28, 20, 4, 27, 28, 4, 14, 43, 24, 33, 7, 6, 7, 4, 46, 14, 14, 19, 16, 34, 20, 30, 26, 44, 22, 47, 22, 28, 42, 29, 39, 31, 3, 31, 25, 12, 15, 11, 48, 37, 1, 36, 9, 26, 4, 43, 25, 28, 21, 46, 1, 18, 45, 46, 14, 40, 1, 41, 35, 18, 11, 26, 41, 8, 13, 30, 22, 21, 39, 29, 34, 44, 38, 23, 15, 7, 12, 9, 1, 43, 32, 35, 41, 47, 4, 1, 20, 2, 42, 12, 47, 14, 37, 22, 39, 30, 23, 15, 35, 32, 9, 36, 7, 22, 6, 20, 43, 23, 47, 41, 46, 6, 7, 11, 10, 13, 10, 17, 37, 22, 2, 34, 2, 3, 1, 45, 47, 12, 43, 10, 4, 23, 30, 9, 28, 36, 22, 35, 4, 39, 34, 19, 8, 40, 9, 1, 28, 32, 14, 22, 25, 23, 45, 24, 12, 16, 5, 30, 7, 11, 18, 47, 14, 1, 7, 20, 20, 27, 39, 40, 30, 43, 5, 9, 50, 15, 28, 32, 18, 40, 3, 11, 20, 30, 48, 47, 30, 21, 35, 48, 46, 6, 19, 50, 24, 37, 38, 47, 10, 3, 9, 47, 4, 43, 31, 29, 2, 35, 46, 27, 36, 13, 39, 36, 21, 8, 14, 17, 47, 6, 50, 27, 9, 49, 16, 20, 38, 32, 43, 16, 33, 9, 11, 35, 49, 9, 41, 19, 15, 31, 41, 24, 11, 21, 21, 13, 49, 35, 23, 11, 43, 33, 14, 42, 33, 28, 12, 12, 25, 24, 12, 30, 38, 24, 42, 12, 37, 4, 30, 30, 35, 20, 1, 38, 33, 34, 32, 47, 3, 27, 44, 50, 25, 42, 3, 24, 32, 23, 27, 16, 12, 33, 39, 35, 24, 19, 40, 22, 6, 20, 20, 29, 9, 6, 34, 38, 22, 15, 46, 29, 6, 46, 10, 11, 50, 44, 16, 13, 40, 30, 2, 1, 22, 26, 10, 43, 15, 8, 27, 20, 23, 13, 12, 37, 9, 15, 5, 34, 30, 12, 14, 4, 19, 21, 20, 6, 22, 18, 31, 49, 48, 23, 32, 4, 15, 11, 5, 36, 39, 22, 5, 25, 22, 34, 49, 27, 8, 35, 11, 26, 48, 37, 41, 35, 17, 17, 50, 46, 46, 9, 50, 10, 50, 32, 31, 5, 25, 20, 22, 34, 27, 24, 46, 5, 18, 10, 2, 25, 28, 22, 34, 33, 40, 25, 37, 49, 10, 46, 19, 4, 47, 25, 5, 26, 5, 21, 49, 11, 35, 45, 11, 9, 33, 24, 44, 39, 41, 39, 15, 35, 9, 4, 20, 4, 46, 33, 31, 18, 45, 48, 8, 27, 21, 20, 15, 24, 10, 27, 49, 34, 47, 24, 37, 21, 12, 21, 36, 36, 48, 35, 22, 27, 29, 15, 29, 3, 23, 7, 44, 39, 2, 4, 24, 37, 44, 10, 16, 44, 20, 5, 36, 33, 46, 41, 38, 17, 24, 11, 13, 46, 22, 42, 28, 20, 4, 47, 9, 28, 4, 12, 47, 25, 42, 21, 47, 38, 8, 40, 41, 29, 40, 31, 2, 4, 17, 29, 36, 47, 22, 44, 21, 28, 14, 2, 13, 30, 19, 31, 32, 24, 40, 45, 23, 29, 44, 26, 15, 32, 36, 40, 11, 47, 46, 27, 13, 20, 46, 25, 26, 26, 6, 17, 28, 30, 35, 4, 24, 48, 42, 15, 48, 25, 37, 34, 25, 14, 34, 34, 20, 41, 16, 9, 10, 28, 30, 33, 22, 25, 44, 30, 42, 49, 14, 28, 15, 13, 1, 36, 3, 35, 29, 1, 43, 24, 28, 31, 1, 48, 19, 31, 50, 36, 16, 16, 23, 2, 45, 22, 20, 39, 45, 37, 37, 7, 19, 20, 16, 29, 37, 33, 8, 32, 40, 47, 44, 26, 7, 11, 41, 4, 47, 27, 25, 18, 31, 33, 33, 6, 41, 13, 10, 6, 31, 11, 14, 33, 22, 28, 30, 47, 4, 7, 31, 11, 16, 27, 2, 31, 2, 37, 5, 21, 42, 24, 48, 21, 44, 27, 5, 26, 32, 4, 20, 49, 9, 42, 34, 9, 31, 8, 19, 14, 42, 12, 41, 42, 40, 9, 32, 26, 42, 14, 27, 28, 16, 2, 39, 43, 11, 24, 6, 50, 32, 15, 17, 48, 28, 25, 15, 36, 22, 1, 36, 29, 1, 40, 22, 25, 22, 10, 12, 3, 48, 38, 21, 11, 16, 34, 2, 4, 41, 26, 22, 45, 36, 29, 40, 50, 10, 20, 26, 38, 25, 22, 35, 1, 38, 22, 50, 11, 28, 43, 7, 10, 12, 31, 1, 11, 42, 15, 39, 9, 31, 21, 49, 31, 23, 18, 36, 47, 23, 9, 18, 7, 20, 45, 3, 16, 39, 4, 43, 3, 43, 9, 11, 8, 16, 50, 49, 13, 12, 18, 29, 23, 43, 2, 28, 19, 27, 6, 15, 28, 36, 39, 19, 17, 36, 44, 6, 7, 8, 3, 41, 24, 43, 30, 27, 39, 44, 35, 48, 23, 25, 13, 3, 13, 13, 36, 45, 44, 26, 21, 19, 11, 45, 40, 24, 5, 34, 1, 35, 27, 31, 4, 14, 19, 17, 12, 6, 44, 36, 32, 28, 33, 44, 7, 2, 13, 24, 1, 15, 3, 50, 29, 1, 21, 38, 26, 37, 11, 21, 34, 35, 38, 11, 31, 5, 6, 12, 29, 22, 40, 49, 46, 15, 43, 48, 39, 34, 43, 14, 26, 10, 49, 29, 38, 32, 14, 3, 19, 37, 17, 12, 23, 11, 39, 10, 1, 9, 1, 18, 28, 33, 2, 21, 28, 6, 4, 17, 3, 15, 29, 27, 41, 43, 15, 20, 44, 5, 11, 26, 21, 28, 26, 11, 19, 29, 39, 45, 15, 12, 31, 21, 8, 46, 17, 37, 39, 29, 44, 8, 18, 3, 34, 40, 5, 33, 27, 11, 47, 33, 16, 21, 2, 21, 24, 36, 42, 29, 40, 33, 12, 4, 1, 8, 6, 45, 43, 41, 29, 38, 25, 41, 28, 11, 44, 14, 42, 41, 41, 20, 1, 43, 13, 33, 13, 34, 8, 15, 19, 49, 5, 28, 32, 18, 20, 10, 6, 2, 35, 11, 14, 16, 13, 6, 4, 38, 22, 26, 42, 43, 15, 31, 1, 18, 23, 22, 23, 49, 2, 7, 49, 33, 12, 20, 28, 36, 10, 43, 49, 13, 42, 2, 42, 36, 6, 6, 43, 23, 8, 29, 21, 24, 18, 18, 30, 22, 9, 1, 47, 27, 18, 15, 35, 40, 37, 17, 4, 15, 25, 42, 28, 28, 5, 42, 19, 10, 36, 33, 34, 48, 47, 44, 16, 10, 24, 45, 32, 35, 43, 46, 48, 39, 19, 40, 28, 27, 17, 20, 29, 15, 13, 38, 34, 23, 28, 29, 31, 25, 4, 27, 41, 49, 1, 16, 9, 9, 17, 26, 43, 34, 50, 9, 12, 4, 18, 37, 6, 33, 42, 42, 20, 38, 31, 40, 34, 20, 25, 43, 36, 6, 9, 12, 47, 29, 48, 6, 23, 17, 30, 19, 4, 39, 23, 32, 16, 44, 32, 27, 7, 14, 45, 6, 34, 12, 12, 2, 8, 24, 25, 34, 36, 39, 12, 8, 31, 18, 27, 21, 39, 21, 32, 34, 24, 26, 6, 16, 22, 37, 3, 41, 46, 41, 8, 26, 7, 17, 32, 2, 4, 21, 6, 34, 4, 23, 17, 38, 3, 47, 38, 14, 42, 48, 47, 37, 5, 11, 4, 2, 25, 20, 14, 25, 10, 11, 50, 50, 25, 45, 35, 7, 30, 31, 33, 41, 5, 46, 49, 3, 12, 21, 4, 3, 24, 28, 20, 42, 10, 23, 13, 25, 42, 4, 25, 6, 39, 27, 35, 20, 18, 29, 15, 15, 10, 44, 35, 9, 30, 8, 19, 48, 36, 19, 28, 15, 35, 24, 50, 3, 44, 50, 43, 27, 45, 37, 50, 26, 40, 6, 16, 24, 9, 5, 27, 11, 7, 3, 11, 44, 4, 23, 37, 24, 43, 39, 8, 24, 21, 7, 40, 19, 25, 8, 13, 21, 10, 9, 21, 39, 28, 15, 19, 21, 37, 44, 34, 4, 3, 42, 9, 9, 20, 6, 23, 7, 20, 20, 6, 37, 42, 42, 13, 22, 46, 36, 3, 29, 15, 40, 15, 4, 16, 7, 4, 8, 48, 26, 1, 34, 18, 43, 29, 36, 14, 12, 17, 48, 24, 19, 36, 18, 12, 11, 27, 15, 17, 4, 9, 46, 3, 5, 45, 7, 18, 40, 11, 10, 24, 20, 6, 12, 43, 28, 22, 5, 12, 18, 25, 39, 42, 35, 17, 24, 21, 19, 49, 15, 16, 33, 32, 10, 42, 10, 1, 28, 38, 27, 6, 41, 18, 33, 27, 33, 11, 18, 33, 13, 42, 2, 5, 10, 17, 29, 3, 7, 48, 43, 25, 38, 48, 12, 29, 14, 36, 42, 40, 11, 38, 2, 44, 24, 49, 35, 48, 38, 44, 3, 44, 34, 49, 16, 31, 48, 18, 45, 47, 15, 24, 41, 49, 28, 13, 2, 47, 2, 22, 41, 27, 40, 39, 42, 22, 47, 5, 9, 5, 13, 19, 6, 7, 24, 5, 23, 37, 43, 27, 16, 30, 4, 26, 21, 6, 29, 46, 27, 49, 37, 19, 47, 3, 48, 7, 36, 28, 37, 7, 9, 2, 39, 45, 8, 44, 37, 19, 50, 50, 4, 23, 5, 34, 32, 28, 31, 33, 9, 11, 23, 10, 38, 26, 46, 17, 42, 25, 40, 46, 5, 48, 15, 8, 2, 34, 5, 23, 30, 48, 45, 20, 18, 17, 39, 24, 33, 7, 8, 14, 50, 35, 18, 17, 31, 16, 46, 37, 1, 24, 40, 3, 8, 38, 27, 4, 48, 11, 31, 29, 31, 8, 31, 35, 50, 32, 46, 36, 4, 30, 24, 49, 2, 36, 40, 15, 46, 2, 15, 21, 30, 46, 36, 48, 12, 18, 33, 19, 15, 6, 46, 2, 23, 31, 26, 14, 36, 18, 12, 21, 38, 33, 8, 15, 10, 39, 10, 33, 30, 15, 18, 15, 23, 43, 33, 48, 23, 43, 10, 11, 31, 15, 8, 49, 29, 45, 8, 41, 41, 44, 35, 35, 1, 8, 42, 50, 32, 47, 33, 20, 49, 13, 17, 27, 29, 43, 36, 24, 49, 28, 33, 42, 1, 10, 30, 34, 39, 30, 27, 7, 11, 5, 50, 37, 8, 17, 39, 12, 39, 13, 19, 33, 26, 1, 11, 2, 21, 40, 46, 24, 23, 6, 14, 13, 10, 17, 34, 22, 25, 45, 48, 25, 5, 23, 43, 21, 33, 11, 8, 4, 7, 13, 20, 15, 10, 27, 28, 48, 39, 19, 33, 20, 9, 23, 29, 5, 29, 26, 28, 45, 42, 2, 4, 24, 3, 39, 9, 7, 4, 37, 31, 47, 2, 16, 23, 36, 10, 3, 15, 34, 29, 6, 8, 34, 50, 3, 15, 24, 43, 9, 1, 6, 46, 36, 29, 10, 8, 47, 28, 9, 25, 7, 5, 17, 24, 36, 1, 32, 48, 37, 30, 4, 9, 46, 41, 27, 40, 15, 14};
    int[] extremeSorted = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 29, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 34, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 42, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};

    @BeforeEach
    void setup(){
        binarySort = new BinarySort();
    }

    @Test
    @DisplayName("null")
    void nullTest(){
        Assertions.assertNotNull(binarySort.sortArray(null));
    }

    @Test
    @DisplayName("int[0]")
    void sortEmpty() {
        Assertions.assertArrayEquals(new int[] {-1}, binarySort.sortArray(empty));
    }

    @Test
    @DisplayName("int[5]")
    void sortSmall() {
        Assertions.assertArrayEquals(smallSorted, binarySort.sortArray(small));
    }

    @Test
    @DisplayName("int[500]")
    void sortLarge() {
        Assertions.assertArrayEquals(largeSorted, binarySort.sortArray(large));
    }

    @Test
    @DisplayName("int[2500] ")
    void sortExtreme() {
        Assertions.assertArrayEquals(extremeSorted, binarySort.sortArray(extreme));
    }
}
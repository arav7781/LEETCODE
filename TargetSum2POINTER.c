#include <stdio.h>
#include <stdlib.h>

int* twoSum(int* numbers, int numbersSize, int target, int* returnSize) {
    *returnSize = 2;
    int* result = (int*)malloc(*returnSize * sizeof(int));
    int left = 0;
    int right = numbersSize - 1;

    while (left < right) {
        int sum = numbers[left] + numbers[right];
        if (sum == target) {
            result[0] = left + 1; // converting 0-indexed to 1-indexed
            result[1] = right + 1; // converting 0-indexed to 1-indexed
            return result;
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    
    return NULL; // In case there is no solution, but problem states there is always one solution.
}

int main() {
    int numbers[] = {2, 7, 11, 15};
    int target = 9;
    int returnSize;
    int* result = twoSum(numbers, sizeof(numbers)/sizeof(numbers[0]), target, &returnSize);

    if (result != NULL) {
        printf("index1 = %d, index2 = %d\n", result[0], result[1]);
        free(result);
    } else {
        printf("No solution found.\n");
    }

    return 0;
}

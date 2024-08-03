#include <stdio.h>

int removeDuplicates(int* nums, int numsSize) {
    if (numsSize == 0) {
        return 0;
    }

    int k = 1; // k is the index for the next unique element
    int count = 1; // To count occurrences of the current element

    for (int i = 1; i < numsSize; i++) { // Start from the second element
        if (nums[i] == nums[i - 1]) {
            count++;
        } else {
            count = 1;
        }

        // Place the element if it has appeared less than or equal to twice
        if (count <= 2) {
            nums[k] = nums[i];
            k++;
        }
    }
    return k;
}
//purane wale function mai
//he error you're seeing indicates a heap buffer overflow, 
//which means that the program is trying to access memory beyond the allocated region for the array. 
//This is happening because the loop in the removeDuplicates function is accessing an element that is out of the bounds of the array.
//Let's carefully review and correct the implementation to ensure we stay within the bounds of the array

int main() {
    int nums[] = {1, 1, 1, 2, 2, 3};
    int numsSize = sizeof(nums) / sizeof(nums[0]);

    int newLength = removeDuplicates(nums, numsSize);

    printf("New length: %d\n", newLength);
    printf("Modified array: ");
    for (int i = 0; i < newLength; i++) {
        printf("%d ", nums[i]);
    }

    return 0;
}

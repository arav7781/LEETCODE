#include <stdio.h>

int removeDuplicates(int* nums, int numsSize) {
    if (numsSize == 0) {
        return 0;
    }

    int k = 1;  // Pointer to keep track of the position for unique elements

    for (int i = 1; i < numsSize; i++) {
        if (nums[i] != nums[i - 1]) {
            nums[k] = nums[i];
            k++;
        }
    }

    return k;
}

int main() {
    int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int numsSize = sizeof(nums) / sizeof(nums[0]);

    int k = removeDuplicates(nums, numsSize);

    printf("Array after removing duplicates: ");
    for (int i = 0; i < k; i++) {
        printf("%d ", nums[i]);
    }
    printf("\n");
    printf("Number of unique elements: %d\n", k);

    return 0;
}

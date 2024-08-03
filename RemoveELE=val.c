#include <stdio.h>

int removeElement(int* nums, int numsSize, int val) {
    int k = 0;  // Pointer to keep track of the position for non-val elements

    for (int i = 0; i < numsSize; i++) {
        if (nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }
    }

    return k;
}

int main() {
    int nums[] = {3, 2, 2, 3};
    int val = 3;
    int numsSize = sizeof(nums) / sizeof(nums[0]);

    int k = removeElement(nums, numsSize, val);

    printf("Array after removal: ");
    for (int i = 0; i < k; i++) {
        printf("%d ", nums[i]);
    }
    printf("\n");
    printf("Number of elements not equal to %d: %d\n", val, k);

    return 0;
}

#include <stdio.h>
#include <limits.h>

// Function to find the minimal length of a subarray with a sum >= target
int minSubArrayLen(int target, int* nums, int numsSize) {
    int minLength = INT_MAX;
    int left = 0;
    int sum = 0;

    for (int right = 0; right < numsSize; right++) {
        sum += nums[right];

        while (sum >= target) {
            minLength = (minLength < (right - left + 1)) ? minLength : (right - left + 1);
            sum -= nums[left];
            left++;
        }
    }

    return (minLength == INT_MAX) ? 0 : minLength;
}

int main() {
    int nums[] = {2, 3, 1, 2, 4, 3};
    int target = 7;
    int numsSize = sizeof(nums) / sizeof(nums[0]);

    int result = minSubArrayLen(target, nums, numsSize);
    printf("Minimal length of subarray: %d\n", result);

    return 0;
}

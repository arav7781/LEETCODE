#include <stdio.h>

// Function to find the maximum water that can be contained
int maxArea(int* height, int heightSize) {
    int left = 0;
    int right = heightSize - 1;
    int max_area = 0;

    // Iterate while left pointer is less than right pointer
    while (left < right) {
        // Calculate the width between the left and right pointers
        int width = right - left;
        // Calculate the height using the shorter of the two lines
        int current_height = height[left] < height[right] ? height[left] : height[right];
        // Calculate the current area
        int current_area = width * current_height;
        // Update max_area if current_area is larger
        if (current_area > max_area) {
            max_area = current_area;
        }

        // Move the pointer pointing to the shorter line inward
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }

    return max_area;
}

int main() {
    int heights1[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int size1 = sizeof(heights1) / sizeof(heights1[0]);
    int result1 = maxArea(heights1, size1);
    printf("The maximum amount of water the container can store is: %d\n", result1); // Output: 49

    int heights2[] = {1, 1};
    int size2 = sizeof(heights2) / sizeof(heights2[0]);
    int result2 = maxArea(heights2, size2);
    printf("The maximum amount of water the container can store is: %d\n", result2); // Output: 1

    return 0;
}

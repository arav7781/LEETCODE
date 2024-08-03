int majorityElement(int* nums, int numsSize) {
    int count = 0;
    int candidate = 0;

    // Phase 1: Find a candidate
    for (int i = 0; i < numsSize; i++) {
        if (count == 0) {
            candidate = nums[i];
        }
        count += (nums[i] == candidate) ? 1 : -1;
    }

    // Phase 2: Verify the candidate
    count = 0;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == candidate) {
            count++;
        }
    }

    if (count > numsSize / 2) {
        return candidate;
    }

    // If the majority element doesn't exist (not expected as per the problem statement)
    return -1; 
}

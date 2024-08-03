#include <stdio.h>

// Function to find the maximum number of satisfied customers
int maxSatisfied(int* customers, int customersSize, int* grumpy, int grumpySize, int minutes) {
    int baseSatisfaction = 0;
    
    // Calculate the base satisfaction without using the secret technique
    for (int i = 0; i < customersSize; i++) {
        if (!grumpy[i]) {
            baseSatisfaction += customers[i];
        }
    }

    // Calculate the initial extra satisfaction if the technique is used in the first 'minutes' window
    int extraSatisfaction = 0;
    for (int i = 0; i < minutes; i++) {
        if (grumpy[i]) {
            extraSatisfaction += customers[i];
        }
    }

    // Track the maximum extra satisfaction possible by sliding the window
    int maxExtraSatisfaction = extraSatisfaction;
    for (int i = minutes; i < customersSize; i++) {
        if (grumpy[i]) {
            extraSatisfaction += customers[i];
        }
        if (grumpy[i - minutes]) {
            extraSatisfaction -= customers[i - minutes];
        }
        if (extraSatisfaction > maxExtraSatisfaction) {
            maxExtraSatisfaction = extraSatisfaction;
        }
    }

    // The total maximum satisfied customers is the base satisfaction plus the maximum extra satisfaction
    return baseSatisfaction + maxExtraSatisfaction;
}

// Example usage
int main() {
    int customers[] = {1, 0, 1, 2, 1, 1, 7, 5};
    int grumpy[] = {0, 1, 0, 1, 0, 1, 0, 1};
    int minutes = 3;

    int customersSize = sizeof(customers) / sizeof(customers[0]);
    int grumpySize = sizeof(grumpy) / sizeof(grumpy[0]);

    int result = maxSatisfied(customers, customersSize, grumpy, grumpySize, minutes);
    printf("Maximum number of satisfied customers: %d\n", result);

    return 0;
}

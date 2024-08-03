/*you are given a string s and an integer k. Encrypt the string using the following algorithm:

For each character c in s, replace c with the kth character after c in the string (in a cyclic manner).
Return the encrypted string.*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to encrypt the string
char* encryptString(char* s, int k) {
    int len = strlen(s);
    char* encrypted = (char*)malloc((len + 1) * sizeof(char));

    for (int i = 0; i < len; i++) {
        // Calculate the new position in a cyclic manner
        int newPos = (i + k) % len;
        encrypted[newPos] = s[i];
    }
    encrypted[len] = '\0'; // Null-terminate the encrypted string

    return encrypted;
}

int main() {
    char s[] = "hello";
    int k = 2;
    char* encrypted = encryptString(s, k);
    printf("Original string: %s\n", s);
    printf("Encrypted string: %s\n", encrypted);
    free(encrypted); // Free the allocated memory

    return 0;
}


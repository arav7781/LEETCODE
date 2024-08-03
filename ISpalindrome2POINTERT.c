#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
#include <string.h>

bool isPalindrome(char* s) {
    int left = 0;
    int right = strlen(s) - 1;

    while (left < right) {
        // Move left index to the next alphanumeric character
        while (left < right && !isalnum(s[left])) {//isalnum is used to check whether the character is alphanumeric or not
            left++;
        }

        // Move right index to the previous alphanumeric character
        while (left < right && !isalnum(s[right])) {
            right--;
        }

        // If characters do not match after converting to lowercase
        if (tolower(s[left]) != tolower(s[right])) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}

int main() {
    char str1[] = "A man, a plan, a canal: Panama";
    char str2[] = "race a car";

    if (isPalindrome(str1)) {
        printf("\"%s\" is a palindrome.\n", str1);
    } else {
        printf("\"%s\" is not a palindrome.\n", str1);
    }

    if (isPalindrome(str2)) {
        printf("\"%s\" is a palindrome.\n", str2);
    } else {
        printf("\"%s\" is not a palindrome.\n", str2);
    }

    return 0;
}

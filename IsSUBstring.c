//If i reaches the length of s, it means all characters in s were found in t in the correct order, so return true.
//If the loop exits and i has not reached the length of s, return false.
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool isSubsequence(char* s, char* t) {
    int s_len = strlen(s);
    int t_len = strlen(t);
    int i = 0, j = 0;

    while (i < s_len && j < t_len) {
        if (s[i] == t[j]) {
            i++;
        }
        j++;
    }

    return i == s_len;
}

int main() {
    char s1[] = "abc";
    char t1[] = "ahbgdc";
    char s2[] = "axc";
    char t2[] = "ahbgdc";

    if (isSubsequence(s1, t1)) {
        printf("\"%s\" is a subsequence of \"%s\".\n", s1, t1);
    } else {
        printf("\"%s\" is not a subsequence of \"%s\".\n", s1, t1);
    }

    if (isSubsequence(s2, t2)) {
        printf("\"%s\" is a subsequence of \"%s\".\n", s2, t2);
    } else {
        printf("\"%s\" is not a subsequence of \"%s\".\n", s2, t2);
    }

    return 0;
}

#include <stdio.h>
#include <stdlib.h>

int numberOfSubmatrices(char** grid, int gridSize, int* gridColSize) {
    int count = 0;

    // Iterate over all possible top-left corners of submatrices
    for (int top = 0; top < gridSize; top++) {
        for (int left = 0; left < gridColSize[top]; left++) {
            // Iterate over all possible bottom-right corners of submatrices
            for (int bottom = top; bottom < gridSize; bottom++) {
                for (int right = left; right < gridColSize[bottom]; right++) {
                    int x_count = 0, y_count = 0;
                    
                    // Check if grid[0][0] is within the submatrix
                    if (!(top <= 0 && 0 <= bottom && left <= 0 && 0 <= right)) {
                        continue;
                    }

                    // Count 'X' and 'Y' in the current submatrix
                    for (int i = top; i <= bottom; i++) {
                        for (int j = left; j <= right; j++) {
                            if (grid[i][j] == 'X') {
                                x_count++;
                            } else if (grid[i][j] == 'Y') {
                                y_count++;
                            }
                        }
                    }

                    // Check conditions
                    if (x_count > 0 && x_count == y_count) {
                        count++;
                    }
                }
            }
        }
    }

    return count;
}

int main() {
    int gridSize = 3;
    int gridColSize[] = {3, 3, 3};

    char* grid[] = {
        "X Y .",
        "Y X Y",
        ". Y X"
    };

    // Convert grid to proper format
    char** formattedGrid = (char**)malloc(gridSize * sizeof(char*));
    for (int i = 0; i < gridSize; i++) {
        formattedGrid[i] = (char*)malloc((gridColSize[i] + 1) * sizeof(char));
        for (int j = 0; j < gridColSize[i]; j++) {
            formattedGrid[i][j] = grid[i][j];
        }
        formattedGrid[i][gridColSize[i]] = '\0';  // Null-terminate each row
    }

    int result = numberOfSubmatrices(formattedGrid, gridSize, gridColSize);
    printf("Number of valid submatrices: %d\n", result);

    // Free allocated memory
    for (int i = 0; i < gridSize; i++) {
        free(formattedGrid[i]);
    }
    free(formattedGrid);

    return 0;
}

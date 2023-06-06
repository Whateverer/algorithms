public class DynamicProgramming {
    int countPaths(boolean[][] grid, int row, int col) {
        if(!validSquare(grid, row, col)) return 0;
        if(isAtEnd(grid, row, col)) return 1;
        return countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
    }

    int countPaths(boolean[][] grid, int row, int col, int[][] paths) {
        if(!validSquare(grid, row, col)) return 0;
        if(isAtEnd(grid, row, col)) return 1;
        if (paths[row][col] == 0) {
            paths[row][col] = countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
        }
        return paths[row][col];
    }

    private boolean isAtEnd(boolean[][] grid, int row, int col) {
        return true;
    }

    boolean validSquare(boolean[][] grid, int row, int col) {
        return true;
    }
}

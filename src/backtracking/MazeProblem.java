package backtracking;

import java.util.Arrays;
import java.util.List;

public class MazeProblem {

	public static void main(String[] args) {

		List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 1, 1, 1), Arrays.asList(1, 1, 1, 1),
				Arrays.asList(1, 1, 1, 1), Arrays.asList(1, 1, 1, 1));
		System.out.println(numberOfPaths(input));
		List<List<Integer>> input2 = Arrays.asList(Arrays.asList(0, 0, 0, 0), Arrays.asList(0, -1, 0, 0),
				Arrays.asList(-1, 0, 0, 0), Arrays.asList(0, 0, 0, 0));
		int maze[][] = { { 0, 0, 0, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 0, 0 } };
		System.out.println(countPaths(maze, 4, 4));

	}

	public static int numberOfPaths(List<List<Integer>> a) {

		if (a.get(0).get(0) == 0) {
			return 0;
		}
		int r = a.size(), c = a.get(0).size();
		int[][] maze = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a.get(i).get(j) == 0) {
					maze[i][j] = -1;
				} else {
					maze[i][j] = 0;
				}
			}
		}

		return countPaths(maze, r, c);
	}

	static int countPaths(int maze[][], int R, int C) {
		if (maze[0][0] == -1)
			return 0;

		for (int i = 0; i < R; i++) {
			if (maze[i][0] == 0)
				maze[i][0] = 1;
			else
				break;
		}

		for (int i = 1; i < C; i++) {
			if (maze[0][i] == 0)
				maze[0][i] = 1;
			else
				break;
		}

		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (maze[i][j] == -1)
					continue;
				if (maze[i - 1][j] > 0)
					maze[i][j] = (maze[i][j] + maze[i - 1][j]);
				if (maze[i][j - 1] > 0)
					maze[i][j] = (maze[i][j] + maze[i][j - 1]);
			}
		}
		return (maze[R - 1][C - 1] > 0) ? maze[R - 1][C - 1] : 0;
	}
}

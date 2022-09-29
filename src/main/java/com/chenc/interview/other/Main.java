package com.chenc.interview.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i < line1.length() - 1; i++) {
            if (line1.charAt(i) == ']') {
                l.add(tmp);
                tmp = new ArrayList<>();
            } else if (line1.charAt(i) == '[' || line1.charAt(i) == ',') {
                continue;
            } else {
                tmp.add(line1.charAt(i) - '0');
            }
        }

        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());

        System.out.println(new Main().solve(l, n, k));
    }

    public int solve(List<List<Integer>> list, int n, int k) {
        int[][] dis = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dis[i][j] = Integer.MAX_VALUE / 2 - 1;
                if (i == j) {
                    dis[i][j] = 0;
                }
            }
        }
        boolean[] visited = new boolean[n + 1];
        visited[k] = true;

        for (List<Integer> tmp : list) {
            dis[tmp.get(0)][tmp.get(1)] = tmp.get(2);
            dis[tmp.get(1)][tmp.get(0)] = tmp.get(2);
        }

        for (int m = 1; m < n + 1; m++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][m] + dis[m][j]);
                }
            }
        }

        int ans = -1;
        for (int i = 1;i<n+1;i++) {
            ans = Math.max(dis[k][i], ans);
        }
        return ans == Integer.MAX_VALUE /2 -1 ? -1:ans;
    }
}

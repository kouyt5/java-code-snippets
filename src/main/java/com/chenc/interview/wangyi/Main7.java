package com.chenc.interview.wangyi;

import java.util.*;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        int[] x = new int[m];
        int[] y = new int[m];
        int[] z = new int[m];
        int q = m;
        while (m-- > 0){
            String[] line = sc.nextLine().split(" ");
            x[q-1 -m] = Integer.parseInt(line[0]);
            y[q-1-m] = Integer.parseInt(line[1]);
            z[q-1-m] = Integer.parseInt(line[2]);
        }
        Dijkstra p1 = new Dijkstra();
        Dijkstra p2 = new Dijkstra();
        p1.init(n);
        for (int i = 1;i<=m;i++){
            p1.add(x[i], y[i], z[i]);
            p2.add(y[i], x[i], z[i]);
        }
        long[] d1 = new long[10000000];
        long[] d2 = new long[10000000];
        Arrays.fill(d1, Long.MAX_VALUE);
        Arrays.fill(d2, Long.MAX_VALUE);
        long dis = 100000000000000l;
        for (int i = 1;i<=m;i++){
            dis = Math.min(dis, d1[x[i]]+d2[y[i]]+z[i]);
            dis = Math.min(dis, d1[y[i]]+d2[x[i]]+z[i]);
        }
        if (dis == 100000000000000l) dis = -1;
        System.out.println(dis);
    }
    public static class Edge{
        int v;
        int w;
        int nxt;
        public Edge(int v, int w, int nxt){
            this.v = v;
            this.w = w;
            this.nxt = nxt;
        }
    }
    public static class Node{
        long dis;
        int pos;
        public Node(long dis, int pos){
            this.dis = dis;
            this.pos = pos;
        }
    }
    public static class Dijkstra{
        int[] head;
        int cnt;
        int n;
        int [] vis;
        Edge[] ed;
        public void add(int u, int v, int w){
            ed[++cnt] = new Edge(v,w,head[u]);
            head[u] = cnt;
        }
        public void init(int tot){
            head = new int[1000000];
            vis = new int[1000000];
            ed = new Edge[10000];
            cnt = 0;
            n = tot;
            for (int i = 0;i<tot;i++) head[i] = 0;
        }
        public void dij(int st, long[] dis){
            PriorityQueue<Node> qu = new PriorityQueue<>(new Comparator<Node>() {

                @Override
                public int compare(Node o1, Node o2) {
                    // TODO Auto-generated method stub
                    return (int)(o2.dis - o1.dis);
                }
                
            });
            dis[st] = 0;
            for (int i = 0;i<=n;i++){
                vis[i] = 0;
            }
            qu.offer(new Node(0, st));
            vis[st] = 0;
            while (!qu.isEmpty()){
                Node tmp = qu.peek();
                qu.poll();
                int x = tmp.pos;
                if (vis[x] > 0) continue;
                vis[x] = 1;
                for (int i = head[x]; i!=0;i=ed[i].nxt){
                    int y = ed[i].v;
                    if (dis[y] > dis[x] +ed[i].w){
                        dis[y] = dis[x] +ed[i].w;
                        if (vis[y] == 0){
                            qu.offer(new Node(dis[y], y));
                        }
                    }
                }
            }
        }
    }
}

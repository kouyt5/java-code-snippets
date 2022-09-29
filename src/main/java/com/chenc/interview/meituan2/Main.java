package com.chenc.interview.meituan2;
import java.util.*;

class Main {
  
  public static int done (int a, int n, int[] pos, int[] neg) {
    int sum = 0;
    for (int i = 1;i<=n;i++) {
      if (pos[i] == a) {
        sum +=1;
      }
    }
    if (sum >= (n + 1) /2 ) return 0;
    return (n + 1) /2 -sum;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    String[] posS = sc.nextLine().split(" ");
    String[] negS = sc.nextLine().split(" ");
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] pos = new int[n + 1];
    int[] neg = new int[n + 1];
    int res = 0;
    for (int i = 1; i<=n;i++) {
      pos[i] = Integer.parseInt(posS[i-1]);
      if (map.containsKey(pos[i])) {
        Set<Integer> tmp = map.get(pos[i]);
        tmp.add(i);
        map.put(pos[i], tmp);
      }else {
        Set<Integer> tmp = new HashSet<>();
        tmp.add(i);
        map.put(pos[i], tmp);
      }
    }
    
    for (int i = 1;i<=n;i++) {
      if (map.containsKey(neg[i])) {
        Set<Integer> tmp = map.get(pos[i]);
        tmp.add(i);
        map.put(neg[i], tmp);
      } else {
        Set<Integer> tmp = new HashSet<>();
        tmp.add(i);
        map.put(neg[i], tmp);
    }
    }
    for (Integer i:map.keySet()) {
      if (map.get(i).size() >= (n+i)/2) {
        res = Math.min(res, done(i, n, pos, neg));
      }
    }
    System.out.println(res);

    Collections.sort(new LinkedList<Integer>(), new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub
        return 0;
      }
      
    });
  }
}
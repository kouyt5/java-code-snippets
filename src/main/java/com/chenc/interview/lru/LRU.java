package com.chenc.interview.lru;

import com.chenc.interview.absmin.Main;

public class LRU {

    private int[] counter;
    private int[] container;
    private boolean[] vis;
    private int count = 0;

    public LRU(int cap){
        counter = new int[cap];
        container = new int[cap];
        vis = new boolean[cap];
        
    }
    public int find(int i){
        int res = -1;
        for (int j = 0;j<container.length;j++){
            if (vis[j]){
                // container[j] = counter[j] + 1;
                if (container[j] == i){
                    res = j;
                }
            }
        }
        return res;
    }

    public void delete(int i){
        for (int j = 0;i<container.length;i++){
            if (container[j] == i){
                container[j] = 0;
                counter[j] = 0;
                vis[j] = false;
                count --;
                return;
            }
        }
    }
    public void insert(int i){
        int j = find(i);
        if (j != -1){  // finded
            counter[j] = 0;
        }else{
            if (count < container.length){
                count ++;
                for (int k = 0;k<container.length;k++){
                    if (!vis[k]){
                        vis[k] = true;
                        container[k] = i;
                        break;
                    }
                }
            }else{
                //淘汰一个
                int minValue = Integer.MAX_VALUE;
                int lucky = -1;
                for (int k = 0;k<container.length;k++){
                    if (counter[k] < minValue){
                        lucky = k;
                        minValue = counter[k];
                    }
                }
                counter[lucky] = 0;
                container[lucky] = i;
                vis[lucky] = true;
            }
        }
        for (int k = 0;k<container.length;k++){
            if (vis[k]){
                counter[k]++;
            }
        }
    }
    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.insert(1);
        lru.insert(2);
        lru.insert(3);
        lru.delete(1);
        lru.insert(4);
    }
}

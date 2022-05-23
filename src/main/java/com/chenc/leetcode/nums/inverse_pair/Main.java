package com.chenc.leetcode.nums.inverse_pair;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P mod 1000000007
 * @author cc
 * @since 2022.4.19
 */
public class Main {
    private int ans;
    private int[] tmp;
    public int InversePairs(int [] array) {
        tmp = new int[array.length];
        merge(array, 0, array.length -1);
        return ans;
    }
    
    public void merge(int[] array, int i, int j){
        if (i > j) return;
        if (j - i <= 1){
            if (array[i] > array[j]){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                ans += 1;
                ans = ans % 1000000007;
            }
            return;
        }
        int mid = i + (j -i)/2;
        merge(array, i, mid);
        merge(array, mid+1, j);
        int r = mid + 1;
        int k = i;
        for (int m = i;m<=j;m++){
            tmp[m] = array[m];
        }
        while (k <= j){
            if (i > mid){
                while (k <= j){
                    array[k++] = tmp[r++];
                }
                continue;
            }
            if (r > j){
                while (k <= j){
                    array[k++] = tmp[i++];
                }
                continue;
            }
            if (tmp[i]<tmp[r]){
                array[k++] = tmp[i++];
            }else{
                while (r <= j && tmp[r] < tmp[i]){
                    array[k++] = tmp[r++];
                    ans += mid -i+1;
                    ans = ans % 1000000007;
                }
            }
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.InversePairs(new int[]{1,2,3,4,5,6,7,0});
        System.out.println(main.ans);
    }
}

package com.chenc.interview.k_mean;

import java.security.DrbgParameters.Reseed;

/**
 * 1. 现有一支股票n天的日收盘价数据，请编写程序计算该股票K日均线数据。k日均线数据包含n-k+1个数据点，每个数据点的计算规则如下：
1) n天的日期编号从0开始，到n-1结束；
2) 第0天收盘价到第k-1天收盘价的平均价格作为k日均线数据的第0个数据点，第1天收盘价到第k天收盘价的平均价格作为k日均线数据的第1个数据点,依此类推。
备注：n>=k。
 */
public class Solution {
    
    public float[] solution(float[] data, int k){
        if (data.length == 0){
            return new float[0];
        }
        float kSum = 0;
        for (int j = 0;j<k;j++){
            kSum += data[j];
        }
        float[] result = new float[data.length-k+1];
        result[0] = kSum / k;
        for (int i = 1;i<data.length-k+1;i++){
            kSum = kSum - data[i-1] + data[i+k-1];
            result[i] = kSum/k;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        float[] x = new float[]{
            22.1f, 22.3f, 22.4f, 22.7f, 22.0f, 24.0f, 25.0f, 27.0f, 28.0f, 
            27.0f, 29.0f, 27.0f, 26.0f, 25.0f, 24.0f, 24.0f, 23.0f, 
            21.0f, 20.0f, 22.0f
        };
        solution.solution(x, 5);
    }
}

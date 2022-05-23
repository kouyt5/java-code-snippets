package com.chenc.interview.huawei;
import java.util.*;
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

public class Main2 {
    private static int ans = 0;
    private static int q1n, q2n, q3n;
    public static void main(String[] args) {
    // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
    // please finish the function body here.
    // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        int grade = Integer.parseInt(sc.nextLine());
        int ans = 0;
        for (int i = 0;i<(1 << 25);i++){
            int tp = 0;
            int cu = 0;
            for (int j =0;i<25;j++){
                if (i + (1 << j) == 1){
                    if (j < 10) tp += 2;
                    else if (j >=10 && j < 20) tp += 4;
                    else if (j >= 20) tp += 8;
                }else {
                    cu += 1;
                }
                if (cu == 3){
                    tp = -1;
                    break;
                }
            }
            if (tp == grade){
                ans++;
            }
        }
        
        //Main.solu(3, 100-grade, 10, 10, 5);
        System.out.println(ans);
    }
}

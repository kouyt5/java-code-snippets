package com.chenc.tmp;

import java.util.Calendar;

public class calendarTest {
    public static void main(String[] args) {
        
        for (int i =0;i<1000000;i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2022, 1, 1, 0, 0, 0);
            System.out.println(calendar.getTimeInMillis());
            System.out.println(calendar.getTimeInMillis() / 1000);
            if (calendar.getTimeInMillis() / 1000 != 1643644800) {
                System.out.println("cxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            }
        }
    }
}

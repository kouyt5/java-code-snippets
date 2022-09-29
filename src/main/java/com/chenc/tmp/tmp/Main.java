package com.chenc.tmp.tmp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private Set<String> mails = new HashSet<>();

    public void filter(String mail) {
        StringBuilder sb = new StringBuilder();
        // .
        boolean ignore = false;
        for (int i = 0;i<mail.length();i++) {
            if (!ignore && mail.charAt(i) == '.') {
                continue;
            } else {
                sb.append(mail.charAt(i));
            }
            if (mail.charAt(i) == '@') {
                ignore = true;
            }
        }
        int addCount = 0;
        for (int i = 0;i<mail.length();i++) {
            if (mail.charAt(i) == '+') {
                addCount += 1;
            }
            if (addCount > 0 && mail.charAt(i) != '+') {
                addCount--;
            } else {
                sb.append(mail.charAt(i));
            }
        }
        float fl = 1.2f + 1;
        mails.add(sb.toString());
    }
}

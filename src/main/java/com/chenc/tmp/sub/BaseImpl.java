package com.chenc.tmp.sub;

import java.util.ArrayList;

public class BaseImpl extends Base{
    
    @Override
    public int test(){
        return 0;
    }

    public BaseImpl() {
        System.out.println("BaseImpl init");
    }
    public static void main(String[] args) {
        BaseImpl baseImpl = new BaseImpl();
        System.out.println("ggg" + " q" == "ggg q");
    }
}

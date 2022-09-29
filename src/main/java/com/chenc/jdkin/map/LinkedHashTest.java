package com.chenc.jdkin.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashTest {
    public static void main(String[] args) {
      MyLinkedHashMap map = new MyLinkedHashMap();
      String tmp;
      tmp = map.putAndGetRemoved("1", "hello1");
      tmp = map.putAndGetRemoved("1", "hello1_1");
      search(map);
      tmp = map.putAndGetRemoved("2", "hello2");
      search(map);
      tmp = map.putAndGetRemoved("1", "hello1");
      search(map);
      tmp = map.putAndGetRemoved("3", "hello4");
      tmp = map.putAndGetRemoved("1", "hello5");
      tmp = map.putAndGetRemoved("4", null);
      tmp = map.putAndGetRemoved("1", "hello5");
    }
    public static void search(MyLinkedHashMap map) {
        for (String s:map.values()) {
            System.out.println(s);
        }
    }
    static class MyLinkedHashMap extends LinkedHashMap<String, String>{

        private Map.Entry<String, String> removed;
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            if (size() > 2) {
                removed = eldest;
                return true;
            }
            removed = null;
            return false;
        }

        @Override
        public String put(String key, String value) {
            remove(key);
            return super.put(key, value);
        }

        public String putAndGetRemoved(String key, String value) {
            removed = null;
            String tmp = get(key);
            put(key, value);
            return removed == null ? (tmp == value ? null:tmp):removed.getValue();
        }
    }
}

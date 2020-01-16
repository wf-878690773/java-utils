package com.zr.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        map.put(1,"zxc");
        map.put(2,"zec");
        map.put(3,"zqc");
        map.put(4,"qdc");

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
           if (entry.getValue().equals("zec")){
               Integer key = entry.getKey();
               System.out.println(key);

           }
        }



    }
}

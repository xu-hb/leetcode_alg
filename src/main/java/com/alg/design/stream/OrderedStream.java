package com.alg.design.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656.设计有序流
 */
public class OrderedStream {
    int cursor;
    int size;
    String[] stream;
    public OrderedStream(int n) {
        cursor=1;
        size=n+1;
        stream = new String[size];
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey]=value;
        List<String> res = new ArrayList<>();
        if (idKey==cursor){
            while (cursor<size && stream[cursor] !=null){
                res.add(stream[cursor++]);
            }
        }

        return res;
    }
}

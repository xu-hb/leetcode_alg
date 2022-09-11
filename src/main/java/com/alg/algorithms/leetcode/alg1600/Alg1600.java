package com.alg.algorithms.leetcode.alg1600;

import java.util.ArrayList;
import java.util.List;

public class Alg1600 {

    /**
     * 1592.重新排列单词间的空格
     * @param s
     * @return
     */
    public String reorderSpaces(String s) {
        int n = s.length(), cnt = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == ' ' && ++i >= 0 && ++cnt >= 0) continue;
            int j = i;
            while (j < n && s.charAt(j) != ' ') j++;
            list.add(s.substring(i, j));
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        int m = list.size(), t = cnt / Math.max(m - 1, 1);
        String k = "";
        while (t-- > 0) k += " ";
        for (int i = 0; i < m; i++) {
            sb.append(list.get(i));
            if (i != m - 1) sb.append(k);
        }
        while (sb.length() != n) sb.append(" ");
        return sb.toString();
    }

    /**
     * 1598.文件夹操作日志收集器
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param logs
     * @return
     */
    public int minOperations(String[] logs) {
        int ret=0;
        for (String log : logs){
            if (log.equals("../") && ret>0){
                //返回上级目录
                ret--;
            }else if (log.equals("./")){
                //当前目录不处理
            }else if (log.charAt(0) !='.'){
                //下级目录
                ret++;
            }
        }
        return ret;
    }
}

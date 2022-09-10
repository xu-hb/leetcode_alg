package com.alg.algorithms.leetcode.alg1600;

public class Alg1600 {
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

package com.alg.algorithms.alg900;

public class Alg850 {
    /**
     * 844.比较含退格的字符串
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        //游标
        int cursorS = s.length()-1;
        int cursorT = t.length()-1;
        //空格数量
        int backCountS = 0;
        int backCountT = 0;

        while (cursorS>=0 || cursorT>=0){
            //寻找s退格后第一个符合条件的字符
            while (cursorS>=0){
                if (s.charAt(cursorS)=='#'){
                    backCountS++;
                    cursorS--;
                }else if (backCountS>0){
                    backCountS--;
                    cursorS--;
                }else {
                    break;
                }
            }

            //寻找t退格后第一个符合条件的字符
            while (cursorT>=0){
                if (t.charAt(cursorT)=='#'){
                    backCountT++;
                    cursorT--;
                }else if (backCountT>0){
                    backCountT--;
                    cursorT--;
                }else {
                    break;
                }
            }

            char tempS = cursorS>=0 ? s.charAt(cursorS) : ' ';
            char tempT = cursorT>=0 ? t.charAt(cursorT) : ' ';
            if (tempS!=tempT) return false;

            cursorS--;
            cursorT--;
        }
        return true;
    }
}

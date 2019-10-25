package com.redDabbler.review.pattern.strategy.compare;

public class CompareUtils {

    public void sort(Comparable[] os){
        for(int i =0;i<os.length;i++){
            for(int j=1;j<os.length;j++){
                if(os[i].compareTo(os[j])>0){
                    swap(os,i,j);
                }
            }
        }

    }

    private void swap(Comparable[] os, int i, int j) {
        Comparable temp = os[i];
        os[i] = os[j];
        os[j] = temp;
    }

}

package com.gummybot.searching;

public class ClassSearch {
    public int linearsearch(int[] array, int element){
        for(int i=0; i<array.length; i++){
            if(element == array[i])
                return i;
        }
        return -1;
    }

    public int binarysearch(int[] array, int element){
        int start = 0;
        int end = array.length-1;
        while (start<end){
            int mid = (start+end)/2;
            if(element == array[mid])
                return mid;
            else if (element < array[mid]){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return -1;
    }

    public int binarysearchrecursive(int[] array, int element, int start, int end){
        int mid = (start+end)/2;
        if(start>end)
            return -1;
        else if(element == array[mid])
            return mid;
        else if (element < array[mid])
            return binarysearchrecursive(array, element, start, mid-1);
        else
            return binarysearchrecursive(array, element, mid+1, end);
    }

    public int binarysearchfirstoccurence(int[] array, int element){
        int start = 0;
        int end = array.length-1;
        while (start<end){
            int mid = (start+end)/2;
            if (element <= array[mid]){
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        if(element == array[start])
            return start;
        else
            return -1;
    }

    public int binarysearchlastoccurence(int[] array, int element){
        int start = 0;
        int end = array.length-1;
        while (start<end){
            int mid = (start+end)/2;
            if (element >= array[mid]){
                start = mid;
            }
            else {
                end = mid-1;
            }
        }
        if(element == array[start])
            return start;
        else
            return -1;
    }

    public int binarysearchoccurencecount(int[] array, int element){
        int firstoccurence = binarysearchfirstoccurence(array, element);
        int lastoccurence = binarysearchlastoccurence(array, element);
        return ((lastoccurence-firstoccurence)+1);
    }
}

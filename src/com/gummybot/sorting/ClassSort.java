package com.gummybot.sorting;

public class ClassSort {

    private void swap(int[] arr, int ind1, int ind2){
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    public void bubblesort(int[] array){
        while(true){
            boolean swapped = false;
            for(int i = 0; i<array.length-1; i++){
                if(array[i]>array[i+1]){
                    swap(array, i, i+1);
                    swapped = true;
                }
            }
            if(swapped == false)
                break;
        }
    }

    public void selectionsort(int[] array){
        for (int i=0; i<array.length; i++){
            int minpos = i;
            for (int j=i+1; j<array.length; j++){
                if(array[minpos] > array[j])
                    minpos = j;
            }
            swap(array, minpos, i);
        }
    }

    public void insertionsort(int[] array){
        for (int i=1; i<array.length; i++){
            for (int j=i; j>0 && array[j] < array[j-1]; j--){
                swap(array, j, j-1);
            }
        }
    }

    private void merge(int[] array, int[] temparray, int start, int mid, int end){
        for (int i=start; i<=end; i++){
            temparray[i] = array[i];
        }
        int ptr1=start;
        int ptr2=mid+1;
        for (int i=start; i<=end; i++){
            if (ptr1>mid){
                array[i]=temparray[ptr2];
                ptr2++;
            }
            else if (ptr2>end){
                array[i]=temparray[ptr1];
                ptr1++;
            }
            else if (temparray[ptr2]<temparray[ptr1]) {
                array[i] = temparray[ptr2];
                ptr2++;
            }
            else {
                array[i] = temparray[ptr1];
                ptr1++;
            }
        }
    }

    private void mergesort(int[] array, int[] temparray, int start, int end){
        if(end<=start)
            return;
        int mid = (start+end)/2;
        mergesort(array, temparray, start, mid);
        mergesort(array, temparray, mid+1, end);
        merge(array, temparray, start, mid, end);
    }

    public void mergesort(int[] array){
        int[] temparray = new int[array.length];
        mergesort(array, temparray, 0, array.length-1);
    }

    private int partition(int[] array, int start, int end){
        int leftptr = start+1;
        int rightptr = end;
        int pivot = array[start];
        while(leftptr <= rightptr){
            while(array[leftptr] < pivot){
                leftptr++;
                if(leftptr > end)
                    break;
            }
            while(array[rightptr] > pivot){
                rightptr--;
                if (rightptr == start)
                    break;
            }
            if (leftptr >= rightptr)
                break;
            swap(array, leftptr, rightptr);
        }
        int partitionpos = rightptr;
        swap(array, start, partitionpos);
        return partitionpos;
    }

    private void quicksort(int[] array, int start, int end){
        if (end <= start)
            return;
        int partitionpos = partition(array, start, end);
        quicksort(array, start, partitionpos-1);
        quicksort(array, partitionpos+1, end);
    }

    public void quicksort(int[] array){
        quicksort(array, 0, array.length-1);
    }
}

import com.gummybot.searching.ClassSearch;
import com.gummybot.sorting.ClassSort;

public class ClassMain {
    public static void main(String[] args) {
        ClassSearch searchObj = new ClassSearch();
        ClassSort sortObj = new ClassSort();
        int[] arr = {3,2,7,4,9,8,6,5,1,10};
        sortObj.quicksort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println( arr[i]);
        }
        System.out.println("Index of 6 is: " + searchObj.binarysearch(arr, 6));
    }
}

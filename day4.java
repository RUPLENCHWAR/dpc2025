import java.util.Arrays;

public class MergeSortedArraysInPlace {
    public static void merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        
        int i = m - 1; 
        int j = 0;     
        
        while (i >= 0 && j < n) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                
                i--;
                j++;
            } else {
                break;
            }
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.println("Test Case 1:");
        System.out.println("Before merge:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        merge(arr1, arr2);
        System.out.println("After merge:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        
        arr1 = new int[]{10, 12, 14};
        arr2 = new int[]{1, 3, 5};
        System.out.println("\nTest Case 2:");
        System.out.println("Before merge:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        merge(arr1, arr2);
        System.out.println("After merge:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        
        arr1 = new int[]{2, 3, 8};
        arr2 = new int[]{4, 6, 10};
        System.out.println("\nTest Case 3:");
        System.out.println("Before merge:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        merge(arr1, arr2);
        System.out.println("After merge:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        
        arr1 = new int[]{1};
        arr2 = new int[]{2};
        System.out.println("\nTest Case 4:");
        System.out.println("Before merge:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        merge(arr1, arr2);
        System.out.println("After merge:");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        
        int size1 = 100000;
        int size2 = 50000;
        arr1 = new int[size1];
        arr2 = new int[size2];
        
        for (int k = 0; k < size1; k++) {
            arr1[k] = k + 1;
        }
        
        for (int k = 0; k < size2; k++) {
            arr2[k] = 50001 + k;
        }
        
        System.out.println("\nTest Case 5:");
        System.out.println("Before merge:");
        System.out.println("First 5 of arr1: [1, 2, 3, 4, 5]");
        System.out.println("Last 5 of arr1: [99996, 99997, 99998, 99999, 100000]");
        System.out.println("First 5 of arr2: [50001, 50002, 50003, 50004, 50005]");
        System.out.println("Last 5 of arr2: [99996, 99997, 99998, 99999, 100000]");
        
        merge(arr1, arr2);
        
        System.out.println("\nAfter merge:");
        System.out.println("First 5 of arr1: [1, 2, 3, 4, 5]");
        System.out.println("Last 5 of arr1: [49996, 49997, 49998, 49999, 50000]");
        System.out.println("First 5 of arr2: [50001, 50002, 50003, 50004, 50005]");
        System.out.println("Last 5 of arr2: [99996, 99997, 99998, 99999, 100000]");
        
        boolean correct = true;
        for (int k = 0; k < 50000; k++) {
            if (arr1[k] != k + 1) {
                correct = false;
                break;
            }
        }
        for (int k = 0; k < 50000; k++) {
            if (arr2[k] != 50001 + k) {
                correct = false;
                break;
            }
        }
    }
}

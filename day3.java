import java.util.*;

public class FindDuplicateNumber {

    public static int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array (n+1): ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        if (size > 50) {  
            for (int i = 1; i < size; i++) {
                arr[i - 1] = i;
            }
            arr[size - 1] = size / 2;
            System.out.println("Auto-generated large array with duplicate = " + (size / 2));
        } else {
            System.out.println("Enter " + size + " elements (range [1, n]):");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
        }

        int duplicate = findDuplicate(arr);
        System.out.println("Duplicate number: " + duplicate);

        sc.close();
    }
}

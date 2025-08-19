import java.util.*;

public class LeadersInArray {
    public static List<Integer> findLeaders(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();
        
        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);
        
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(maxFromRight);
            }
        }
        
        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Leaders in Array Program ---");
            System.out.println("1. Enter custom input");
            System.out.println("2. Run predefined test cases");
            System.out.println("3. Run Test Case 5 (large input: [1...1000000])");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter size of array: ");
                int n = sc.nextInt();
                int[] arr = new int[n];
                System.out.println("Enter " + n + " elements:");
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                System.out.println("Leaders: " + findLeaders(arr));
            } 
            else if (choice == 2) {
          
                int[][] testCases = {
                    {16, 17, 4, 3, 5, 2},
                    {1, 2, 3, 4, 0},
                    {7, 10, 4, 10, 6, 5, 2},
                    {5},
                    {100, 50, 20, 10}
                };

                for (int i = 0; i < testCases.length; i++) {
                    System.out.println("Test Case " + (i+1) + ": " + Arrays.toString(testCases[i]));
                    System.out.println("Leaders: " + findLeaders(testCases[i]));
                }
            } 
            else if (choice == 3) {
            
                int n = 1000000;
                int[] largeArr = new int[n];
                for (int i = 0; i < n; i++) {
                    largeArr[i] = i + 1;  
                }
                System.out.println("Running Test Case 5 (Large Input [1...1000000])...");
                System.out.println("Leaders: " + findLeaders(largeArr));
            } 
            else if (choice == 4) {
                System.out.println("Exiting...");
                break;
            } 
            else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}

import java.util.Scanner;

public class MissingNumberFinder {
    
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;
        
        for (int num : arr) {
            actualSum += num;
        }
        
        return (int)(expectedSum - actualSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Missing Number Finder");
        System.out.println("1. Enter array manually");
        System.out.println("2. Run Test Case 5 (1 to 999999 with 1000000 missing)");
        System.out.print("Choose an option (1 or 2): ");
        
        int option = scanner.nextInt();
        scanner.nextLine(); 
        
        if (option == 1) {
            System.out.println("Enter the array elements separated by spaces (e.g., 1 2 4 5):");
            String input = scanner.nextLine();
            String[] stringNumbers = input.split("\\s+");
            int[] numbers = new int[stringNumbers.length];
            
            for (int i = 0; i < stringNumbers.length; i++) {
                numbers[i] = Integer.parseInt(stringNumbers[i]);
            }
            
            int missingNumber = findMissingNumber(numbers);
            System.out.println("The missing number is: " + missingNumber);
        } 
        else if (option == 2) {
          
            int n = 1_000_000;
            int[] largeArray = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                largeArray[i] = i + 1;
            }
            
            int missingNumber = findMissingNumber(largeArray);
            System.out.println("Test Case 5 Result: " + missingNumber); 
        }
        
        scanner.close();
    }
}

import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Long, List<Integer>> prefixMap = new HashMap<>();
        long prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == 0) {
                result.add(new int[]{0, i});
            }

            if (prefixMap.containsKey(prefixSum)) {
                for (int startIndex : prefixMap.get(prefixSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            prefixMap.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, -3, 3, -1, 2},
            {4, -1, -3, 1, 2, -1},
            {1, 2, 3, 4},
            {0, 0, 0},
            {-3, 1, 2, -3, 4, 0}
        };

        for (int[] test : testCases) {
            List<int[]> ans = findZeroSumSubarrays(test);
            System.out.print("Input: " + Arrays.toString(test) + " -> Output: ");
            for (int[] sub : ans) {
                System.out.print("(" + sub[0] + ", " + sub[1] + ") ");
            }
            System.out.println();
        }

        int n = 10000;
        int[] bigTest = new int[2 * n];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            bigTest[idx++] = i;
            bigTest[idx++] = -i;
        }

        List<int[]> bigAns = findZeroSumSubarrays(bigTest);
        System.out.println("\nLarge Test Case: [1,-1,2,-2,...] up to 20,000 elements");
        System.out.println("Total subarrays found: " + bigAns.size());

        for (int i = 0; i < Math.min(5, bigAns.size()); i++) {
            System.out.print("(" + bigAns.get(i)[0] + ", " + bigAns.get(i)[1] + ") ");
        }
        System.out.print(" ... ");
        for (int i = Math.max(0, bigAns.size() - 5); i < bigAns.size(); i++) {
            System.out.print("(" + bigAns.get(i)[0] + ", " + bigAns.get(i)[1] + ") ");
        }
        System.out.println();
    }
}

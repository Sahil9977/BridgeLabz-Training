// Q6_SubarraysWithZeroSum.java
// Find all subarrays with zero sum using HashMap
package Collection;

import java.util.*;

public class SubarraysWithZeroSum {
    public static List<int[]> findSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                for (int idx : map.get(sum)) {
                    result.add(new int[]{idx + 1, i});
                }
            }
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, 3, 1, -4};
        List<int[]> subarrays = findSubarrays(arr);
        for (int[] sub : subarrays) {
            System.out.println("Subarray: " + sub[0] + " to " + sub[1]);
        }
        // Output: Subarrays with zero sum
    }
}

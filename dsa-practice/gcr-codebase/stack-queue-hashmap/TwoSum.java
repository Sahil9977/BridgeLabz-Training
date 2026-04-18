// Q10_TwoSum.java
// Two Sum Problem using HashMap
package Collection;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        if (res.length == 2) {
            System.out.println(res[0] + ", " + res[1]); // Output: 0, 1
        } else {
            System.out.println("No solution");
        }
    }
}

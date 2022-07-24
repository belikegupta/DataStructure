package Array.medium;

import java.util.*;

/*https://www.code-recipe.com/post/three-sum
  Brute Force: TC=O(N^3)
  Space complexity is O(k) since we use hashmap to store unique triplets. k here is the number of unique triplets with sum = 0 for the given array.*/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> triplet = new ArrayList<Integer>();
                            triplet.add(nums[i]);
                            triplet.add(nums[j]);
                            triplet.add(nums[k]);
                            Collections.sort(triplet);
                            result.add(triplet);
                        }
                    }
                }
            }
            result = new ArrayList<List<Integer>>(new LinkedHashSet<List<Integer>>(result));
            return result;
        }
    }

    /*Optimize :TC =O(N^2) and SC=O(1)*/

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // Sort the given array
            Arrays.sort(nums);

            List<List<Integer>> result = new ArrayList<>();
            for (int num1Idx = 0; num1Idx + 2 < nums.length; num1Idx++) {
                // Skip all duplicates from left
                // num1Idx>0 ensures this check is made only from 2nd element onwards
                if (num1Idx > 0 && nums[num1Idx] == nums[num1Idx - 1]) {
                    continue;
                }
                int num2Idx = num1Idx + 1;
                int num3Idx = nums.length - 1;
                while (num2Idx < num3Idx) {
                    int sum = nums[num2Idx] + nums[num3Idx] + nums[num1Idx];
                    if (sum == 0) {
                        // Add triplet to result
                        result.add(Arrays.asList(nums[num1Idx], nums[num2Idx], nums[num3Idx]));
                        num3Idx--;
                        // Skip all duplicates from right
                        while (num2Idx < num3Idx && nums[num3Idx] == nums[num3Idx + 1]) num3Idx--;
                    } else if (sum > 0) {
                        // Decrement num3Idx to reduce sum value
                        num3Idx--;
                    } else {
                        // Increment num2Idx to increase sum value
                        num2Idx++;
                    }
                }
            }
            return result;
        }
    }


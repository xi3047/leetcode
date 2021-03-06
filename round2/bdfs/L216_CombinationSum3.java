package round2.bdfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Xi Zhang
 * @date 12/10/2020 12:40 AM
 * @topic round2.bdfs
 * @link https://leetcode.com/problems/combination-sum-iii/
 * @description
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 *
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.
 * Example 4:
 *
 * Input: k = 3, n = 2
 * Output: []
 * Explanation: There are no valid combinations.
 * Example 5:
 *
 * Input: k = 9, n = 45
 * Output: [[1,2,3,4,5,6,7,8,9]]
 * Explanation:
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
 */
public class L216_CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        backtrack(res, path, k, n, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int k, int n, int start) {
        if (n < 0 ) {
            return;
        }
        if (path.size() == k) {
            if (n == 0) res.add(new LinkedList<>(path));
            else return;
        }
        for (int i = start; i < 10; i++) {
            path.add(i);
            backtrack(res, path, k, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(combinationSum3(3, 9));
    }
}

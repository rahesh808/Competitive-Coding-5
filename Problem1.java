import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Using BFS approach
Time COmplexity -> O(N)
Space Complexity -> O(N)
*/
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }

            }
            result.add(max);
        }
        return result;
    }
}
/*
Using DFS approach
Time COmplexity -> O(N)
Space Complexity -> O(H)
*/

class Solution2 {
    List<Integer> result;

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0);
        return result;

    }

    private void dfs(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        if(result.size() == level) {
            result.add(root.val);
        }else {
            result.set(level,Math.max(result.get(level), root.val));
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}
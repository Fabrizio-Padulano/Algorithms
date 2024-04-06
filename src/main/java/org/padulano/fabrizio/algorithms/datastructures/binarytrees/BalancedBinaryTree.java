package org.padulano.fabrizio.algorithms.datastructures.binarytrees;

// https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {
    private boolean res = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);

        return res;
    }

    private int dfs(TreeNode root) {
        if (!res) return 0;
        if (root == null) return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);

        if (Math.abs(l - r) > 1) this.res = false;

        return 1 + Math.max(l, r);
    }
}

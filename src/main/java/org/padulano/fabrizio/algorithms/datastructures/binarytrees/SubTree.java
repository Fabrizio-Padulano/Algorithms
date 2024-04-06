package org.padulano.fabrizio.algorithms.datastructures.binarytrees;

public class SubTree {
    private static boolean isValid = false;

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isValid) return true;
        if (root == null || subRoot == null) return root == subRoot;

        if (root.val == subRoot.val && isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

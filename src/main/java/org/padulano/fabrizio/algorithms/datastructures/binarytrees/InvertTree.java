package org.padulano.fabrizio.algorithms.datastructures.binarytrees;

public class InvertTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        invertTree(root.left);
        invertTree(root.right);

        var temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}

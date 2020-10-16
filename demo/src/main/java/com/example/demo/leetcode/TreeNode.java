package com.example.demo.leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode tmp = root;
            if (root == null || root.val == 0 || root.left == null && root.right == null) {
                root = new TreeNode(val, null, null);
                return tmp;
            } else {
                while (true) {
                    if (val > root.val) {
                        if (root.right == null) {
                            root.right = new TreeNode(val, null, null);
                            break;
                        } else {
                            root = root.right;
                        }
                    }
                    if (val < root.val) {
                        if (root.left == null) {
                            root.left = new TreeNode(val, null, null);
                            break;
                        } else {
                            root = root.left;
                        }
                    }
                }
            }
            return tmp;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();


        s.insertIntoBST(new TreeNode())
    }
}

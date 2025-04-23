//  insert a node into a binary tree using level-order insertion
import java.util.*;

public class Tree3 {
    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void insert(TreeNode root, TreeNode x) {
        if (root == null) {
            root = x;
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp.left == null) {
                temp.left = x;
                return;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = x;
                return;
            } else {
                q.add(temp.right);
            }
        }
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void print(TreeNode root, int level) {
        if (root == null) return;
        if (level == 1) {
            System.out.print(root.data + " ");
        } else {
            print(root.left, level - 1);
            print(root.right, level - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int val = 5;
        TreeNode x = new TreeNode(val);

        insert(root, x);

        int treeHeight = height(root);

        for (int i = 1; i <= treeHeight; i++) {
            print(root, i);
            System.out.println();
        }
    }
}


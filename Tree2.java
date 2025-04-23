
//count the number of nodes on a specific level
import java.util.*;

public class Tree2 {
    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
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
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);

        print(root, 3);
    }
}

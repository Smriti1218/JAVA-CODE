import java.util.LinkedList;
import java.util.Queue;

public class Tree5 {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int val) {
            data = val;
            left = right = null;
        }
    }

    static void deleteDeepest(TreeNode root, TreeNode delNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == delNode) {
                temp = null;
                return;
            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
        }
    }

    static TreeNode delete(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null) {
            if (root.data == key)
                return null;
            else
                return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode keyNode = null;
        TreeNode temp = null;

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.data == key)
                keyNode = temp;

            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }

        if (keyNode != null) {
            int x = temp.data;
            deleteDeepest(root, temp);
            keyNode.data = x;
        }

        return root;
    }

    static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(12);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);

        System.out.print("Inorder before deletion: ");
        inorder(root);

        int key = 11;
        root = delete(root, key);

        System.out.print("\nInorder after deletion: ");
        inorder(root);
    }
}
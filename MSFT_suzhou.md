LIME面试，其实就是看你刷题的水平到什么层次了，刷的多和少其实看的很清楚，你对语言的熟悉程度

1. 509. Fibonacci Number
```java
public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int a = 0, b = 1, sum = 0;
        while (N > 1) {
            sum = a + b;
            a = b;
            b = sum;
            N--;
        }
        return sum;
    }
```
2. 226. Invert Binary Tree
```java
// recursive
public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = invertTree(left);
        root.left = invertTree(right);

        return root;
    }

// iterative
public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

```

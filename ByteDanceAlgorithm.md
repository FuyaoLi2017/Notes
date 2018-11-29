### 最长公共子序列，顺序可以间隔
```java
public int longestCommonSubsequence(String str1, String str2) {
        if(str1.isEmpty()||str2.isEmpty()) return 0;
        int m=str1.length(), n=str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
```

### 最长公共子串
```java
public int longestCommonSubsequence(String str1, String str2) {
        if(str1.isEmpty()||str2.isEmpty()) return 0;
        int m=str1.length(), n=str2.length();
        int[][] dp = new int[m+1][n+1];
        // 边界自动是0
        for(int i=1; i<=m; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m][n];
    }
```

### 输出abcd的全排列
```java
public void permutation(char[] input, int index) {
    if (index == input.length - 1) {
        System.out.println(input);
        return;
    }

    for (int i = index; i < input.length; i++) {
        swap(input, index, i);
        permutation(input, index + 1);
        swap(input, index, i);
    }
}

public void swap(char[] input, int first, int second) {
    int temp = input[first];
    input[first] = input[second];
    input[second] = temp;
}
```
### two sums


### n个整数的无序数组，找到每个元素后面比它大的第一个数，要求时间复杂度为O(N)，在面试官提醒下写出来了，用栈+栈底指针

- 如果没有更大的就返回 null
```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}

```


### 用rand5实现rand7
正确的方法是利用rand5()函数生成1-25之间的数字，然后将其中的1-21映射成1-7，丢弃22-25。例如生成(1，1)，(1，2)，(1，3)，则看成rand7()中的1，如果出现剩下的4种，则丢弃重新生成。
```java
public class Test {    
    public int rand7() {    
        int x = 22;    
        while(x > 21) {    
            x = rand5() + (rand5() - 1)*5;    
        }    
        return 1 + x%7;    
    }    

}  
```

### Two sum
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
                }
            }
        return res;
        }
    }
```

### LRU CACHE
```java
public class LRUCache {
    private class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if( !hs.containsKey(key)) {
            return -1;
        }

        // remove current
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        move_to_tail(current);

        return hs.get(key).value;
    }

    public void set(int key, int value) {
        // get 这个方法会把key挪到最末端，因此，不需要再调用 move_to_tail
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity) {
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        hs.put(key, insert);
        move_to_tail(insert);
    }

    private void move_to_tail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}
```

### 2个链表
```java
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListOrdering {
//    一个链表，假设第一个节点我们定为下标为1，第二个为2，那么下标为奇数的结点是升序排序，偶数的结点是降序排序，如何让整个链表有序？（分离链表，合并两个有序链表）


    public ListNode order (ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyDecrease = new ListNode(0);

        ListNode cur = head;
        dummyDecrease.next = head.next;
        ListNode decreaseHead = dummyDecrease.next;

        // 之后的三个点都不是null
        while (cur != null && decreaseHead != null) {
            if (cur.next != null) {
                cur.next = cur.next.next;
                cur = cur.next;
            } else break;
            if (decreaseHead.next != null) {
                decreaseHead.next = decreaseHead.next.next;
                decreaseHead = decreaseHead.next;
            } else break;
        }
        // head is the increasing linkedlist and dummyDecrease.next is the decreasing list
        // reverse the decreasing linkedlist
        ListNode reverse = reverseLinkedList(dummyDecrease.next);

        ListNode dummyRes = new ListNode(0);
        ListNode resCur = dummyRes;

        while (head != null && reverse != null) {
            if (head.val >= reverse.val) {
                resCur.next = reverse;
                reverse = reverse.next;
            } else {
                resCur.next = head;
                head = head.next;
            }
            resCur = resCur.next;
        }

        if (head != null) {
            resCur.next = head;
        }

        if (reverse != null) {
            resCur.next = reverse;
        }

        return dummyRes.next;
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        ListNode test2 = new ListNode(6);
        ListNode test3 = new ListNode(3);
        ListNode test4 = new ListNode(4);
        ListNode test5 = new ListNode(5);
        ListNode test6 = new ListNode(2);

        test1.next = test2;
        test2.next = test3;
        test3.next = test4;
        test4.next = test5;
        test5.next = test6;

        LinkedListOrdering test = new LinkedListOrdering();

        ListNode res = test.order(test1);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }


    }
}
```

```java
public int Depth(ListNode root) {
    if (root == null) return 0;
    int left = Depth(root.left);
    int right = Depth(root.right);
    return Math.max(left, right) + 1;
}




```

### 反转链表
```java

// iterative
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

// recursive
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
```

### lowest common ancestor
```JAVA
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // just one node in a subtree, then the another one must be its descendant
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        // 如果left == null，就返回一个right, 跟另一侧的相同
        return left == null ? right : left;
    }
}
```

### Implement stack with two queues
```java
class MyStack {
    private ArrayDeque<Integer> q1;
    private ArrayDeque<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new ArrayDeque<Integer>();
        q2 = new ArrayDeque<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!q1.isEmpty()) {
            q1.offerFirst(x);
        }
        else {
            q2.offerFirst(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (q1.isEmpty()) {
            int size = q2.size();
            for (int i = 1; i < size; i++) {
                q1.offerFirst(q2.pollLast());
            }
            return q2.poll();
        } else {
            int size = q1.size();
            for (int i = 1; i < size; i++) {
                q2.offerFirst(q1.pollLast());
            }
            return q1.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (q1.isEmpty()) {
            int size = q2.size();
            for (int i = 1; i < size; i++) {
                q1.offerFirst(q2.pollLast());
            }
            int res = q2.poll();
            q1.offerFirst(res);
            return res;
        } else {
            int size = q1.size();
            for (int i = 1; i < size; i++) {
                q2.offerFirst(q1.pollLast());
            }
            int res = q1.poll();
            q2.offerFirst(res);
            return res;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
```
### implement queue with two stacks
```java
class MyQueue {

    private LinkedList<Integer> in;
    private LinkedList<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.offerFirst(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        move();
        return out.isEmpty() ? null : out.pollFirst();
    }

    /** Get the front element. */
    public int peek() {
        move();
        return out.isEmpty() ? null : out.peekFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.size() == 0 && out.size() == 0;
    }
}
```

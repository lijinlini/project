package com.lijinlin.project.learn.leetcode.easy;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class BinaryTree {
    public static class TreeNode {
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
    }

    /**
     * 二叉树中序遍历
     * 中序： 左-自己-右-返回上一级  左-自己-右-返回上一级 左-自己-右-返回上一级 。。。。。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        result = middleOrder(root, result);
        return result;
    }

    public List<Integer> middleOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        if (node.left != null) {
            list = middleOrder(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            list = middleOrder(node.right, list);
        }
        return list;
    }

    /**
     * 100. 相同的树
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = true;
        //1先判断根是否为空
        if (p == null && q == null) {
            return result;
        }
        //从根节点开始判断是否相同，在判断左子树，再判断右子树递归判断
        result = isSameTreeIterator(p, q);

        return result;
    }

    public static boolean isSameTreeIterator(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            //节点相同 往下继续判断
            return true;
        }
        if (p != null && q == null) {
            //节点不相同 则直接返回
            return false;
        }
        if (p == null && q != null) {
            //节点不相同 则直接返回
            return false;
        }

        if (p.val == q.val) {
            //节点相同 往下继续判断
            boolean leftRes = isSameTreeIterator(p.left, q.left);
            boolean rightRes = isSameTreeIterator(p.right, q.right);
            if (leftRes && rightRes) {
                return true;
            }
            return false;
        } else {
            //节点不相同 则直接返回
            return false;
        }
    }


    public boolean isSymmetric(TreeNode root) {
        boolean result = true;
        result = isSymmetricDeep(root.left, root.right);
        return result;
    }

    /**
     * 101 给你一个二叉树的根节点 root ， 检查它是否轴对称。 深度优先
     * https://leetcode.cn/problems/symmetric-tree/
     *
     * @param root1 root2
     * @return
     */
    public boolean isSymmetricDeep(TreeNode root1, TreeNode root2) {
        boolean result = true;
        if (root1 == null && root2 == null) {
            return result;
        }

        if (root1 == null) {
            result = false;
            return result;
        }
        if (root2 == null) {
            result = false;
            return result;
        }
        if (root1.val != root2.val) {
            result = false;
            return result;
        }

        boolean left = isSymmetricDeep(root1.left, root2.right);
        boolean right = isSymmetricDeep(root1.right, root2.left);
        return left && right;
    }

    /**
     * 101 给你一个二叉树的根节点 root ， 检查它是否轴对称。广度优先
     * https://leetcode.cn/problems/symmetric-tree/
     *
     * @param root1 root2
     * @return
     */
    public boolean isSymmetricScope(TreeNode root1, TreeNode root2) {
        boolean result = true;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root1);
        queue.add(root2);
        while (!queue.isEmpty()) {
            TreeNode poll1 = queue.poll();
            TreeNode poll2 = queue.poll();
            if (poll1 == null && poll2 == null) {
                continue;
            }
            if (poll1 == null || poll2 == null) {
                result = false;
                break;
            }
            if (poll1.val != poll2.val) {
                result = false;
                break;
            }
            queue.add(poll1.left);
            queue.add(poll2.right);
            queue.add(poll1.right);
            queue.add(poll2.left);
        }
        return result;
    }

    /**
     * 104. 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     * <p>
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 循环迭代
     *
     * @param root
     * @param
     * @return
     */
    public int maxDepthIterator(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (nodes.size() > 0) {
            int size = nodes.size();
            while (size-- > 0) {
                TreeNode poll = nodes.poll();
                if (poll.left != null) {
                    nodes.offer(poll.left);
                }
                if (poll.right != null) {
                    nodes.offer(poll.right);
                }
            }
            res++;
        }
        return res;
    }

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
     *
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(Integer[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    //给定一个升序数组根据不停循环创建左右子树
    public static TreeNode sortedArrayToBST(Integer[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //先找到根节点，然后根据根节点分别构建左右子树
        int rootNum = (left + right) / 2;
        TreeNode root = new TreeNode();
        root.val = nums[rootNum];
        root.left = sortedArrayToBST(nums, left, rootNum - 1);
        root.right = sortedArrayToBST(nums, rootNum + 1, right);
        return root;
    }


    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * <p>
     * 本题中，一棵高度平衡二叉树定义为： 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     *
     * @param node
     * @return
     */
    public static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftNum = depth(root.left);
        int rightNum = depth(root.right);
        return Math.abs(leftNum - rightNum) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 111. 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度。
     * <p>
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * <p>
     * 说明：叶子节点是指没有子节点的节点。
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = 0;
        Queue<HashMap<TreeNode, Integer>> lineNodeList = new LinkedList<>();
        if (root.left != null) {
            HashMap<TreeNode, Integer> map = new HashMap<>();
            map.put(root.left, 2);
            lineNodeList.add(map);
        }
        if (root.right != null) {
            HashMap<TreeNode, Integer> map = new HashMap<>();
            map.put(root.right, 2);
            lineNodeList.add(map);
        }
        while (lineNodeList.size() > 0) {
            HashMap<TreeNode, Integer> nodeMap = lineNodeList.poll();
            Set<TreeNode> treeNodeSet = nodeMap.keySet();
            Iterator<TreeNode> it = treeNodeSet.iterator();
            TreeNode cur = new TreeNode();
            Integer depth = null;
            while (it.hasNext()) {
                TreeNode key = it.next();
                cur = key;
                depth = nodeMap.get(key);
            }
            if (cur.left == null && cur.right == null) {
                //当一个节点左右子节点都为空的时候就不在判断直接返回
                minDepth = depth;
                break;
            } else {
                if (cur.left != null) {
                    HashMap<TreeNode, Integer> map = new HashMap<>();
                    map.put(cur.left, depth + 1);
                    lineNodeList.add(map);
                }
                if (cur.right != null) {
                    HashMap<TreeNode, Integer> map = new HashMap<>();
                    map.put(cur.right, depth + 1);
                    lineNodeList.add(map);
                }
            }

        }
        return minDepth;
    }

    /**
     * 112. 路径总和
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
     * <p>
     * 叶子节点 是指没有子节点的节点。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        boolean leftFlag = false;
        boolean rightFlag = false;
        if (root.left != null) {
            leftFlag = hasPathSum(root.left, targetSum - root.val);
        }
        if (root.right != null) {
            rightFlag = hasPathSum(root.right, targetSum - root.val);
        }
        if (leftFlag || rightFlag) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 给你一个根节点，和树的高度创建一个满二叉树
     * <p>
     * 1
     * 2          3
     * 4    5     6     7
     * 8 9 10 11 12 13 14 15
     *
     * @param height
     * @param root
     */
    private static TreeNode createFullBinaryTree(int height, TreeNode root) {
        if (height == 0) {
            return root;
        }
        int curNum = 1;
        root.val = curNum;
        //上一行节点
        Queue<TreeNode> preNodeQueue = new LinkedList<>();
        //是否是第一次
        boolean firstFlag = true;
        for (int i = 1; i <= height; i++) {
            //把每层节点放入一个队列中
            Queue<TreeNode> curNodeQueue = new LinkedList<>();
            Queue<TreeNode> tempNodeQueue = new LinkedList<>();
            //计算这一层要创建多少个节点
            double layerNum = Math.pow(2, i - 1);
            for (int j = 1; j <= layerNum; j++) {
                TreeNode node = new TreeNode();
                node.val = curNum;
                curNum++;
                curNodeQueue.add(node);
                tempNodeQueue.add(node);
            }
            while (preNodeQueue.size() > 0) {
                TreeNode node = preNodeQueue.poll();
                if (preNodeQueue.size() == 0 && firstFlag) {
                    firstFlag = false;
                    root = node;
                }
                TreeNode left = tempNodeQueue.poll();
                TreeNode right = tempNodeQueue.poll();
                node.left = left;
                node.right = right;
            }
            preNodeQueue = curNodeQueue;
        }
        return root;
    }

    /**
     * 二叉树查找
     *
     * @param num  查找的数值大小
     * @param root 查找的二叉树根节点
     * @return
     */
    private static TreeNode searchBinaryTree(int num, TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.val == num) {
            return root;
        }
        if (num < root.val) {
            searchBinaryTree(num, root.left);
        }
        if (num > root.val) {
            searchBinaryTree(num, root.right);
        }
        return root;
    }

    /**
     * 输出两个节点之间最近的路径
     *
     * @param num1
     * @param num2
     * @return
     */
    private static String searchBinaryTree(TreeNode root, int num1, int num2) {
        List res = new ArrayList();
        if (root == null) {
            return res.toString();
        }
        Stack<String> num1Stack = new Stack<>();
        num1Stack = searchNodeFromRoot(root, num1, num1Stack);
        Stack<String> num2Stack = new Stack<>();
        num2Stack = searchNodeFromRoot(root, num2, num2Stack);
        Stack<String> num3Stack = new Stack<>();
        String aroundNum = "";

        if (Integer.valueOf(num1Stack.peek()) == num1 && Integer.valueOf(num2Stack.peek()) == num2) {
            int i = 0;
            while (num1Stack.size() > 0) {
                if(i == 1){
                    aroundNum = num1Stack.peek();
                }
                i++;
                res.add(num1Stack.pop());
            }
            while (num2Stack.size() > 0) {
                if(num2Stack.peek().equals(aroundNum)){
                    List res1 = new ArrayList();
                    res1.add(num1);
                    res1.add(aroundNum);
                    res1.add(num2);
                    return res1.toString();
                }
                num3Stack.add(num2Stack.pop());
            }
            while (num3Stack.size() > 0) {
                if (num3Stack.peek().equals(res.get(res.size()-1))){
                    num3Stack.pop();
                    continue;
                }
                res.add(num3Stack.pop());
            }
        }
        return res.toString();
    }

    private static Stack<String> searchNodeFromRoot(TreeNode node, int num, Stack<String> numStack) {
        Stack<String> newNumStack = new Stack<>();
        newNumStack.addAll(numStack);
        if (node != null) {
            newNumStack.add(String.valueOf(node.val));
        }
        if (node != null && node.val == num) {
            return newNumStack;
        }
        if (node != null) {
            numStack = searchNodeFromRoot(node.left, num, newNumStack);
            if(numStack != null){
                return numStack;
            }
            numStack = searchNodeFromRoot(node.right, num, newNumStack);
            if(numStack != null){
                return numStack;
            }

        }
        return null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        System.out.println(root = createFullBinaryTree(3, root));
        System.out.println(searchBinaryTree(root, 4, 7));
        // System.out.println(createFullBinaryTree(3, root));
        /*TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode rootLeft = new TreeNode();
        rootLeft.val = 2;
        TreeNode rootRight = new TreeNode();
        rootRight.val = 3;
        TreeNode leftLeft = new TreeNode();
        leftLeft.val = 4;
        TreeNode leftRight = new TreeNode();
        leftRight.val = 5;
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = leftLeft;
        rootLeft.right = leftRight;
        System.out.println(minDepth(root));*/


        /*TreeNode root = new TreeNode();
        root.val = 0;
        System.out.println(minDepth(root));*/


        /*TreeNode root = new TreeNode();
        root.val = 2;
        TreeNode rootRight = new TreeNode();
        rootRight.val = 3;
        TreeNode rightRight = new TreeNode();
        rightRight.val = 4;
        TreeNode rightRR = new TreeNode();
        rightRR.val = 5;
        TreeNode rightRRR = new TreeNode();
        rightRRR.val = 6;

        root.right = rootRight;
        rootRight.right = rightRight;
        rightRight.right = rightRR;
        rightRR.right = rightRRR;
        System.out.println(minDepth(root));*/

        /*TreeNode root = new TreeNode();
        root.val = 3;
        TreeNode rootLeft = new TreeNode();
        rootLeft.val = 9;
        TreeNode rootRight = new TreeNode();
        rootRight.val = 20;
        TreeNode rightLeft = new TreeNode();
        rightLeft.val = 15;
        TreeNode rightRight = new TreeNode();
        rightRight.val = 7;
        root.left = rootLeft;
        root.right = rootRight;
        rootRight.left = rightLeft;
        rootRight.right = rightRight;
        System.out.println(minDepth(root));*/
    }
}

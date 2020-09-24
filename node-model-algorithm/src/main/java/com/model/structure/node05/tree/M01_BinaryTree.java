package com.model.structure.node05.tree;

/**
 * 二叉树基础用法
 */
public class M01_BinaryTree {
    public static void main(String[] args) {
        BinaryTree01 binaryTree = new BinaryTree01 () ;
        TreeNode root = new TreeNode("A") ;
        TreeNode bRoot = new TreeNode("B") ;
        TreeNode cRoot = new TreeNode("C") ;
        TreeNode fRoot = new TreeNode("F") ;
        TreeNode gRoot = new TreeNode("G") ;

        binaryTree.setRoot(root);
        root.setLeftNode(bRoot);
        root.setRightNode(cRoot);
        cRoot.setLeftNode(fRoot);
        cRoot.setRightNode(gRoot);

        // 遍历方法测试
        // binaryTree.prevTraverse();  // A B C F G
        // binaryTree.midTraverse();   // B A F C G
        // binaryTree.lastTraverse();  // B F G C A

        // 查找方法测试
        // System.out.println(binaryTree.prevSearch("A"));
        // System.out.println(binaryTree.midSearch("C"));
        // System.out.println(binaryTree.lastSearch("G"));

        // 删除方法测试
        binaryTree.deleteNode("A");
        binaryTree.prevTraverse();
    }
}

/**
 * 二叉树定义
 */
class BinaryTree01 {
    private TreeNode root ;
    public void setRoot(TreeNode root) {
        this.root = root;
    }
    /**
     * 前序遍历
     */
    public void prevTraverse() {
        if(this.root != null) {
            this.root.prevTraverse();
        } else {
            System.out.println("空二叉树无法遍历");
        }
    }

    /**
     * 中序遍历
     */
    public void midTraverse() {
        if(this.root != null) {
            this.root.midTraverse();
        } else {
            System.out.println("空二叉树无法遍历");
        }
    }
    /**
     * 后序遍历
     */
    public void lastTraverse() {
        if(this.root != null) {
            this.root.lastTraverse();
        } else {
            System.out.println("空二叉树无法遍历");
        }
    }

    /**
     * 前序查找
     */
    public TreeNode prevSearch(String num) {
        if(root != null) {
            return root.prevSearch(num);
        }
        return null;
    }

    /**
     * 中序查找
     */
    public TreeNode midSearch(String num) {
        if(root != null) {
            return root.midSearch(num);
        }
        return null;
    }

    /**
     * 后序查找
     */
    public TreeNode lastSearch(String num) {
        if(root != null) {
            return this.root.lastSearch(num);
        }
        return null;
    }

    /**
     * 删除结点
     */
    public void deleteNode (String num) {
        if(root != null) {
            // 判断root是否删除
            if(root.getNum().equals(num)) {
                root = null;
            } else {
                //递归删除
                root.deleteNode(num);
            }
        }else{
            System.out.println("空树没有节点");
        }
    }
}

/**
 * 树节点定义
 */
class TreeNode {
    private String num ;
    private TreeNode leftNode ;
    private TreeNode rightNode ;
    public TreeNode(String num) {
        this.num = num;
    }
    @Override
    public String toString() {
        return "TreeNode{num=" + num +'}';
    }

    /**
     * 前序遍历
     */
    public void prevTraverse() {
        // 输出父结点
        System.out.println(this);
        // 向左子树递归前序遍历
        if(this.leftNode != null) {
            this.leftNode.prevTraverse();
        }
        // 向右子树递归前序遍历
        if(this.rightNode != null) {
            this.rightNode.prevTraverse();
        }
    }

    /**
     * 中序遍历
     */
    public void midTraverse() {
        // 向左子树递归中序遍历
        if(this.leftNode != null) {
            this.leftNode.midTraverse();
        }
        // 输出父结点
        System.out.println(this);
        // 向右子树递归中序遍历
        if(this.rightNode != null) {
            this.rightNode.midTraverse();
        }
    }

    /**
     * 后序遍历
     */
    public void lastTraverse() {
        // 向左子树递归后序遍历
        if(this.leftNode != null) {
            this.leftNode.lastTraverse();
        }
        // 向右子树递归后序遍历
        if(this.rightNode != null) {
            this.rightNode.lastTraverse();
        }
        // 输出父结点
        System.out.println(this);
    }

    /**
     * 前序查找
     */
    public TreeNode prevSearch(String num) {
        //比较当前结点
        if(this.num.equals(num)) {
            return this ;
        }
        // 递归遍历左子树查找
        TreeNode findNode = null;
        if(this.leftNode != null) {
            findNode = this.leftNode.prevSearch(num);
        }
        // 左子树遍历命中
        if(findNode != null) {
            return findNode ;
        }
        // 递归遍历右子树查找
        if(this.rightNode != null) {
            findNode = this.rightNode.prevSearch(num);
        }
        return findNode ;
    }

    /**
     * 中序查找
     */
    public TreeNode midSearch(String num) {
        // 递归遍历左子树查找
        TreeNode findNode = null;
        if(this.leftNode != null) {
            findNode = this.leftNode.midSearch(num);
        }
        if(findNode != null) {
            return findNode ;
        }
        // 比较当前结点
        if(this.num.equals(num)) {
            return this ;
        }
        // 递归遍历右子树查找
        if(this.rightNode != null) {
            findNode = this.rightNode.midSearch(num);
        }
        return findNode ;
    }

    /**
     * 后序查找
     */
    public TreeNode lastSearch(String num) {
        // 递归遍历左子树查找
        TreeNode findNode = null;
        if(this.leftNode != null) {
            findNode = this.leftNode.lastSearch(num);
        }
        if(findNode != null) {
            return findNode ;
        }
        // 递归遍历右子树查找
        if(this.rightNode != null) {
            findNode = this.rightNode.lastSearch(num);
        }
        if(findNode != null) {
            return findNode ;
        }
        // 比较当前结点
        if(this.num.equals(num)) {
            return this ;
        }
        return null ;
    }

    /**
     * 删除节点
     */
    public void deleteNode(String num) {
        // 判断左节点是否删除
        if(this.leftNode != null && this.leftNode.num.equals(num)) {
            this.leftNode = null ;
            return ;
        }
        // 判断右节点是否删除
        if(this.rightNode != null && this.rightNode.num.equals(num)) {
            this.rightNode = null;
            return ;
        }
        // 向左子树遍历进行递归删除
        if(this.leftNode != null) {
            this.leftNode.deleteNode(num);
        }
        // 向右子树遍历进行递归删除
        if(this.rightNode != null) {
            this.rightNode.deleteNode(num);
        }
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
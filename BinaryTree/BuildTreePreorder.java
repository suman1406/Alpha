package BinaryTree;
import java.util.*;

public class BuildTreePreorder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // preorder traversal
        public void preorder(Node root) {
            if(root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // inorder traversal
        public void inorder(Node root) {
            if(root == null) {
                return;
            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // post order traversal
        public void postorder(Node root) {
            if(root == null) {
                return;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // Level order Traversal
        public void levelOrder(Node root) {
            if(root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");

                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        // height of a tree
        public int height(Node root) {
            if(root == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        //count of nodes of a tree
        public int countNodes(Node root) {
            if(root == null) {
                return 0;
            }

            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);

            return leftCount + rightCount + 1;
        }

        // sum of nodes
        public int sumOfNodes(Node root) {
            if(root == null) {
                return 0;
            }

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);

            return leftSum + rightSum + root.data;
        }

        // sum of nodes at kth level
        public int sumOfNodesAtKthLevel(Node root, int k) {
            if(root == null) {
                return 0;
            }

            if(k == 0) {
                return root.data;
            }

            int leftSum = sumOfNodesAtKthLevel(root.left, k - 1);
            int rightSum = sumOfNodesAtKthLevel(root.right, k - 1);

            return leftSum + rightSum;
        }

        // diameter of a tree -- approach 1
        public int diameter(Node root) {
            if(root == null) {
                return 0;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            int leftDiameter = diameter(root.left);
            int rightDiameter = diameter(root.right);

            return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
        }

        // diameter of a tree -- approach 2 -- return diameter and height in the same function
        public int[] diameter2(Node root) {
            if(root == null) {
                int[] arr = new int[2];
                arr[0] = 0;
                arr[1] = 0;
                return arr;
            }

            int[] leftAns = diameter2(root.left);
            int[] rightAns = diameter2(root.right);

            int[] ans = new int[2];
            ans[0] = Math.max(leftAns[0], Math.max(rightAns[0], leftAns[1] + rightAns[1] + 1));
            ans[1] = Math.max(leftAns[1], rightAns[1]) + 1;

            return ans;
        }

        // isIdentical
        public boolean isIdentical(Node root1, Node root2) {
            if(root1 == null && root2 == null) {
                return true;
            }

            if(root1 == null || root2 == null) {
                return false;
            }

            if(root1.data != root2.data) {
                return false;
            }

            boolean leftAns = isIdentical(root1.left, root2.left);
            boolean rightAns = isIdentical(root1.right, root2.right);

            return leftAns && rightAns;
        }

        // subtree of another tree
        public boolean isSubtree(Node root, Node subRoot) {
            if(root == null) {
                return false;
            }

            if(subRoot == null) {
                return true;
            }

            if(isIdentical(root, subRoot)) {
                return true;
            }

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        // Top View of a tree
        public void topView(Node root) {
            if(root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");

                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);

        tree.preorder(root);

        System.out.println();

        tree.inorder(root);

        System.out.println();

        tree.postorder(root);

        System.out.println();

        System.out.println(tree.height(root));

        System.out.println(tree.countNodes(root));

        System.out.println(tree.sumOfNodes(root));

        System.out.println(tree.sumOfNodesAtKthLevel(root, 2));

        System.out.println(tree.diameter(root));

        System.out.println(tree.diameter2(root)[0]);

        System.out.println(tree.isIdentical(root, root));

        System.out.println(tree.isSubtree(root, root));

        tree.topView(root);
    }
}
package trees.bst;

import java.util.Scanner;

public class BSTMain {
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    private Node root;

    public void add(int data) {
        root = insert(root, data);
    }

    private Node insert(Node curr, int data) {
        if (curr == null) return new Node(data);
        if (data < curr.data) curr.left = insert(curr.left, data);
        else if (data > curr.data) curr.right = insert(curr.right, data);
        return curr;
    }

    public void inorder(Node n) {
        if (n == null) return;
        inorder(n.left);
        System.out.print(n.data + " ");
        inorder(n.right);
    }

    public void preorder(Node n) {
        if (n == null) return;
        System.out.print(n.data + " ");
        preorder(n.left);
        preorder(n.right);
    }

    public void postorder(Node n) {
        if (n == null) return;
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.data + " ");
    }

    public int height(Node n) {
        return n == null ? -1 : 1 + Math.max(height(n.left), height(n.right));
    }

    public int heightOfNode(int key) {
        Node target = search(root, key);
        return target == null ? -1 : height(target);
    }

    public Node search(Node n, int key) {
        if (n == null || n.data == key) return n;
        return key < n.data ? search(n.left, key) : search(n.right, key);
    }

    public Node[] searchWithParent(int key) {
        Node curr = root, parent = null;
        while (curr != null && curr.data != key) {
            parent = curr;
            curr = (key < curr.data) ? curr.left : curr.right;
        }
        return new Node[]{curr, parent};
    }

    public Node bfs(int key) {
        if (root == null) return null;
        QueueDemo<Node> q = new QueueDemo<>(20);
        q.offer(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == key) return curr;
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
        return null;
    }

    public Node dfs(int key) {
        if (root == null) return null;
        StackDemo<Node> s = new StackDemo<>(20);
        s.push(root);
        while (!s.isEmpty()) {
            Node curr = s.pop();
            if (curr.data == key) return curr;
            if (curr.right != null) s.push(curr.right);
            if (curr.left != null) s.push(curr.left);
        }
        return null;
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node curr, int data) {
        if (curr == null) return null;
        if (data < curr.data) curr.left = deleteRec(curr.left, data);
        else if (data > curr.data) curr.right = deleteRec(curr.right, data);
        else {
            if (curr.left == null) return curr.right;
            if (curr.right == null) return curr.left;
            Node succ = curr.right;
            while (succ.left != null) succ = succ.left;
            curr.data = succ.data;
            curr.right = deleteRec(curr.right, succ.data);
        }
        return curr;
    }

    public static void main(String[] args) {
        BSTMain bst = new BSTMain();
        int[] nodes = {50, 30, 10, 90, 100, 40, 70, 80, 60, 20};
        for (int val : nodes) bst.add(val);

        System.out.print("Preorder:  "); bst.preorder(bst.root);  System.out.println();
        System.out.print("Inorder:   "); bst.inorder(bst.root);   System.out.println();
        System.out.print("Postorder: "); bst.postorder(bst.root); System.out.println();

        System.out.println("Tree Height: " + bst.height(bst.root));


        Scanner sc = new Scanner(System.in);

        // 1. Height of a node input
        System.out.print("\n1. Enter node dataue to find its height: ");
        int hKey = sc.nextInt();
        int h = bst.heightOfNode(hKey);
        System.out.println("Height: " + (h == -1 ? "Node not found" : h));

        // 2. Search key input
        System.out.print("\n2. Enter key to search: ");
        int key = sc.nextInt();
        System.out.println("BFS: " + (bst.bfs(key) != null ? "Found" : "Not Found"));
        System.out.println("DFS: " + (bst.dfs(key) != null ? "Found" : "Not Found"));
        Node[] res = bst.searchWithParent(key);
        System.out.println("BS:  " + (res[0] != null ? "Found " + res[0].data : "Not Found"));
        System.out.println("Parent: " + (res[1] != null ? res[1].data : (res[0] != null ? "Root (No Parent)" : "N/A")));

        // 3. Delete a node input
        System.out.print("\n3. Enter element to delete: ");
        int deldata = sc.nextInt();
        bst.delete(deldata);
        System.out.print("Inorder after delete: ");
        bst.inorder(bst.root);
        System.out.println();

        sc.close();

    }
}
/**
 * 
 */
package com.practice.tree;

/**
 * @author swamygorli
 *
 */
public class BinaryTreeHeight {

	private static int height(Node root) {
		if (root == null)
			return 0;
		int lheight = height(root.left);
		int rheight = height(root.right);

		return 1 + (Math.max(lheight, rheight));

	}

	public static void main(String[] args) {

		Node root = new Node(6);
		root.left = new Node(4);
		root.left.left = new Node(3);
		root.left.right = new Node(5);

		root.right = new Node(9);
		root.right.left = new Node(8);
		root.right.right = new Node(11);

		root.right.right.left = new Node(10);
		root.right.right.right = new Node(12);

		System.out.println(height(root));

	}

}

class Node {

	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

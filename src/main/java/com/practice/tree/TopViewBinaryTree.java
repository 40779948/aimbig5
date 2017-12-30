/**
 * 
 */
package com.practice.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author swamygorli
 *
 */
public class TopViewBinaryTree {

	private static void printTopView(Node root) {

		Set<Integer> hdSet = new HashSet<Integer>();

		Queue<HdNode> queue = new LinkedList<HdNode>();

		queue.add(new HdNode(root, 0));

		while (!queue.isEmpty()) {

			HdNode current = queue.poll();

			Node node = current.node;

			if (hdSet.add(current.hd))
				System.out.println(node.data);
			if (node.left != null)
				queue.add(new HdNode(node.left, current.hd - 1));
			if (node.right != null)
				queue.add(new HdNode(node.right, current.hd + 1));

		}
		
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);
		printTopView(root);

	}

}

class HdNode {
	Node node;
	int hd;

	public HdNode(Node node, int hd) {
		this.node = node;
		this.hd = hd;
	}
}
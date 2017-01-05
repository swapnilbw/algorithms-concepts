package com.example;

public class BinaryTreeAddAndPrint {

	public static void main(String[] args) {

		BinaryTreeAddAndPrint btree = new BinaryTreeAddAndPrint();
		Node root = new Node(7);
		btree.addNewElementToTree(root, 3);
		btree.addNewElementToTree(root, 2);
		btree.addNewElementToTree(root, 9);
		btree.addNewElementToTree(root, 63);
		btree.addNewElementToTree(root, 8);
		btree.addNewElementToTree(root, 77);

		// print result
		btree.printAllTreeValues(root);
	}

	// Binary tree
	// add 7 3 2 9 63 8 7 8 2 77
	// result
	private void addNewElementToTree(Node root, int value) {

		// get root
		Node currNode = root;
		Node tmpNode;
		// navigate the tree and add new node
		while (currNode != null) {
			tmpNode = currNode;
			if (value > currNode.value) {
				currNode = currNode.right;
				if (currNode == null) {
					currNode = new Node(value);
					tmpNode.right = currNode;
					break;
				}

			} else {
				currNode = currNode.left;
				if (currNode == null) {
					currNode = new Node(value);
					tmpNode.left = currNode;
					break;
				}

			}
		}

	}

	private void printAllTreeValues(Node root) {

		if(root==null) return;
		
		printAllTreeValues(root.left);
		System.out.println(root.value);
		printAllTreeValues(root.right);
	}

	private void printLeftSideOfTree(Node root) {
		if (root == null) {
			return;
		}
		printLeftSideOfTree(root.left);
		System.out.println(root.value);
	}

	private void printRightSideOfTree(Node root) {
		while (root != null) {
			System.out.println(root.value);
			root = root.right;
		}
	}

	private static class Node {

		private int value;

		private Node left;

		private Node right;

		Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}
}

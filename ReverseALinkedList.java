package com.example;

public class ReverseALinkedList {

	private static Node head;

	public static void main(String[] args) {
		addToEnd(new Node(1));
		addToEnd(new Node(2));
		addToEnd(new Node(3));
		addToEnd(new Node(4));
		addToEnd(new Node(5));
		// reverseList(lList.getFirst());

		// print linked list
		head = reverseList(head);
		printList(head);
	}

	private static void printList(Node head2) {
		Node temp = head2;
		while (temp != null) {
			System.out.println(temp.number);
			temp = temp.next;
		}
	}

	private static void addToEnd(Node node) {
		if (head == null) {
			head = node;
			head.next = null;
		} else {
			// find the tails and add element at the tail
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			// found the tail
			temp.next = node;
		}

	}

	private static Node reverseList(Node currNode) {

		// point head to next to null
		head = currNode;
		Node preNode = null;
		Node nextNode;
		// in loop
		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = preNode;
			preNode = currNode;
			currNode = nextNode;
		}
		return preNode;
	}

	private static class Node {
		int number;
		Node next;

		Node(int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [number=" + number + ", next=" + next + "]";
		}
	}
}

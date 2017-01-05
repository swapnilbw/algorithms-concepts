package com.example;

import java.util.LinkedList;

public class FindCenterOfLinkedList {

	private static Node head;

	public static void main(String[] args) {
		addToEnd(new Node(1));
		addToEnd(new Node(2));
		addToEnd(new Node(3));
		addToEnd(new Node(4));
		addToEnd(new Node(5));
		// reverseList(lList.getFirst());
		printList(head);

		// print linked list
		Node middleOne = findMiddleNode(head);
		//printList(head);
		System.out.println(middleOne.toString());
	}

	private static void printList(Node head2) {
		Node temp = head2;
		while (temp != null) {
			System.out.println(temp.number);
			temp = temp.next;
		}
	}



	private static Node findMiddleNode(Node head) {
		// get two pointers , make one move by 2 nodes and slow pointer by one node
		// when faster pointer at the end of the list , slow pointer at the middle 
		Node slowerPointer,fasterPointer;
		slowerPointer = fasterPointer = head;
		int counter = 0;
		while(fasterPointer.next !=null) {
			counter++;
			fasterPointer = fasterPointer.next;
			if(counter%2==0) 
				slowerPointer = slowerPointer.next;
		}
			
		return slowerPointer;
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

package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class PriorityQueue {

	public static void main(String[] args) {
		PriorityQueue obj = new PriorityQueue();
		//obj.testHeadOfQueue();
		obj.testArrayToString();
	}

	private void testArrayToString(){
		List<String> aList = new ArrayList<>();
		aList.add("B");
		aList.add("C");
		aList.add("F");
		aList.add("A");
		Collections.sort(aList);
		System.out.println(Objects.toString(aList));
	}
	private void testHeadOfQueue() {
		Queue<Integer> pQueue = new java.util.PriorityQueue<>(10);
		pQueue.add(5);
		pQueue.add(10);
		pQueue.add(1);
		pQueue.add(4);

		System.out.println(pQueue.peek());

		Queue<String> pQueueStr = new java.util.PriorityQueue<>(10);
		pQueueStr.add("F");
		pQueueStr.add("G");
		pQueueStr.add("A");
		pQueueStr.add("C");
		
		System.out.println(pQueueStr.peek());

	}
}

package DSA_Project;
import java.util.Scanner;

import DSA_Project.Single_LinkedList.Node;

public class Doubly_linkedList {
	
	static Scanner sc = new Scanner(System.in);
	static int choice;
	static int count=0;
	
	static class Node{
		int info;
		Node next;
		Node prev;
		Node(int info){
			this.info = info;
			this.next = null;
			this.prev = null;
		}
	}
	static Node start = null;
	static Node tail = null;
	
	Doubly_linkedList() {
		do {
			System.out.println("Press 1 to Traverse");
			System.out.println("Press 2 for Insertion at First");
			System.out.println("Press 3 for Insertion at last");
			System.out.println("Press 4 for Insertion at Middle before given node");
			System.out.println("Press 5 for Insertion at Middle After given node");
			System.out.println("Press 6 for deletion at first");
			System.out.println("Press 7 for deletion at Last.");
			System.out.println("Press 8 for deletion of middle given node");
			System.out.println("Press 9 for deletion through item value.");
			System.out.println("Press 10 to Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				traverse_dll();
				break;
			case 2:
				InsertionAtFirst();
				count++;
				break;
			case 3:
				InsertionAtLast();
				count++;
				break;
			case 4:
				int mid = (count/2)+1;
				Node ptr = start;
				for(int i=1;i<mid;i++) {
					ptr = ptr.next;
				}
				System.out.println("Enter the item you went to insert: ");
				int item = sc.nextInt();
				InsertionInMiddleBGN(ptr,item);
				count++;
				break;
			case 5:
				mid = (count/2);
				ptr = start;
				for(int i=1;i<mid;i++) {
					ptr = ptr.next;
				}
				
				System.out.println("Enter the item you went to insert: ");
				item = sc.nextInt();
				InsertionInMiddleAGN(ptr,item);
				count++; 
				break;
			case 6:
				deletionAtFirst();
				count--;
				break;
			case 7:
				deletionAtLast();
				count--;
				break;
			case 8:
				mid = (count/2)+1;
				ptr = start;
				for(int i=1;i<mid;i++) {
					ptr = ptr.next;
				}
				deletionOfMiddleNode(ptr);
				count--;
				break;
			case 9:
				System.out.println("Enter the item value you went to delete: ");
				item = sc.nextInt();
				deletionFromValue(item);
				count--;
				break;
			}
		}
		while(choice!=10);
	 }
	
	
	static void traverse_dll() {
		Node ptr = start;
		
		if(start==null)
			System.out.println("Linkedlist doesn't exist");
		
		else {
			while(ptr!=null) {
			System.out.println(ptr.info + " ");
			ptr = ptr.next;
		}}
	}
	
	static void InsertionAtFirst() {
		System.out.println("Enter the item you went to insert: ");
		int item = sc.nextInt();
		Node ptr = new Node(item);
		ptr.next = start;
		start = ptr;
	}
	
	
	static void InsertionAtLast() {
		System.out.println("Enter the item you went to insert: ");
		int item = sc.nextInt();
		Node ptr = new Node(item);
		
		if(start==null) {
			start = ptr;
			return;
		}
		Node ptr1 = start;
		while(ptr.next!=null)
			ptr1 = ptr1.next;
		ptr1.next = ptr;
		ptr.prev = ptr1;
	}
	
	
	static void InsertionInMiddleBGN(Node ptr1,int item) {
		Node ptr = new Node(item);
		ptr.info = item;
		if(start==null) {
			start = ptr;
			return;
		}
		Node ptr2 = start;
		if(ptr2.next==null) {
			ptr.next = start;
			start.prev = ptr;
			start = ptr;
			return;
		}
		while(ptr2.next!=ptr1) {
			ptr2 = ptr2.next;
		}
		ptr2.next = ptr;
		ptr.prev = ptr2;
		ptr.next = ptr1;
		ptr1.prev = ptr;
	}
	
	static void InsertionInMiddleAGN(Node ptr1,int item) {
		Node ptr = new Node(item);
		ptr.info = item;
		
		if(start==null) {
			start = ptr;
			return;
		}
		ptr1.next.prev = ptr;
		ptr1.next = ptr;
		ptr.prev = ptr1;
		ptr.next = ptr1.next;
	}
	
	static void deletionAtFirst() {
		if(start==null) {
			System.out.println("Double linkedlist is empty.");
			return;
		}
		Node ptr = start;
		start = start.next;
		if(start!=null)
			start.prev = null;
		System.out.println("******Item Deleted Successfully**********");
	}
	
	static void deletionAtLast() {
		if(start==null) {
			System.out.println("Double linkedlist is empty.");
			return;
		}
		Node ptr = start;
		if(ptr.next==null) {
			start = null;
			System.out.println("******Item Deleted Successfully**********");
			return;
		}
		while(ptr.next.next!=null)
			ptr = ptr.next;
//		Node ptr1 = ptr.next;Memory free
		ptr.next = null;
	}
	
	static void deletionOfMiddleNode(Node ptr) {
		if(start==null) {
			System.out.println("Double linkedlist is empty.");
			return;
		}
		if(start.next==null) {
			start = null;
			System.out.println("******Item Deleted Successfully**********");
			return;
		}
		Node ptr1 = ptr.prev;
		ptr1.next = ptr.next;
		ptr.next.prev = ptr1;
		System.out.println("******Item Deleted Successfully**********");
	}
	
	static void deletionFromValue(int item) {
		if(start==null) {
			System.out.println("Double linkedlist is empty.");
			return;
		}
		if(start.info==item) {
			start = null;
			System.out.println("******Item Deleted Successfully**********");
			return;
		}
		Node ptr = start;
		while(ptr.info!=item && ptr.next!=null)
			ptr = ptr.next;
		if(ptr.info==item) {
			Node ptr1 = ptr.prev;
			ptr1.next = ptr.next;
			ptr.next.prev = ptr1;
			System.out.println("******Item Deleted Successfully**********");
		}
		else
			System.out.println("Item not found!");
	}
	
}

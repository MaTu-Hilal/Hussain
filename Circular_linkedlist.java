package DSA_Project;
import java.util.Scanner;

import DSA_Project.Single_LinkedList.Node;

public class Circular_linkedlist {
	
	static Scanner sc = new Scanner(System.in);
	static int choice;
	static int count=0;
	
	static class Node{
		int info;
		Node next;
		Node(int info){
			this.info = info;
			this.next = null;
		}
	}
	static Node start = null;
	static Node tail = null;
	
	Circular_linkedlist() {
		do {
			System.out.println("Press 1 to Traverse");
			System.out.println("Press 2 for Insertion at First");
			System.out.println("Press 3 for Insertion at last");
			System.out.println("Press 4 to Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				traverse_cll();
				break;
			case 2:
				InsertionAtFirst();
				count++;
				break;
			case 3:
				InsertionAtlast();
				count++;
				break;
			}
		}
		while(choice!=4);
	 }
	
	
	static void traverse_cll() {
		if(start==null) {
			System.out.println("Cll is Empty.");
			return;
		}
		Node ptr = start;
		 do{
			System.out.print(ptr.info +"\n");
			ptr = ptr.next;
		}
		while(ptr!=start);
	}
	
	
	static void InsertionAtFirst() {
		System.out.println("Enter the item you went to insert: ");
		int item = sc.nextInt();
		Node ptr = new Node(item);
		ptr.info = item;
		Node ptr1 = start;
		if(ptr1==null) {
			start = ptr;
			tail = ptr;
			ptr.next = start;
			return;
		}
		else {
			ptr.next = start;
			start = ptr;
			tail.next = start;
		}
	}
	
	
	static void InsertionAtlast() {
		System.out.println("Enter the item you went to insert: ");
		int item = sc.nextInt();
		Node ptr = new Node(item);
		ptr.info = item;
		
		if(start==null) {
			start = ptr;
			tail = ptr;
			ptr.next = start;
			return;
		}
		
		Node ptr1 = start;
		while(ptr1.next!=start) {
			ptr1 = ptr1.next;
		}
		ptr1.next = ptr;
		ptr.next = start;
		tail = ptr;
	}
	
	
}
			

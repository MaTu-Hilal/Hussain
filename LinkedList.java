package DSA_Project;
import java.util.Scanner;
//Ya Zehra


public class LinkedList {

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
	
	LinkedList() {
		do {
			System.out.println("Press 1 to Traverse");
			System.out.println("Press 2 for Insertion at First");
			System.out.println("Press 3 for Insertion at last");
			System.out.println("Press 4 for Insertion at Middle before given node");
			System.out.println("Press 5 to Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				traverse_sll();
				break;
			case 2:
				InsertionAtFirst();
				break;
			case 3:
				InsertionAtEnd();
				break;
			case 4:
				Node ptr = findMiddleNode();
				InsertionInMiddleBGN(ptr);
				break;
			}
		}
		while(choice!=5);
	 }
	
	static Node findMiddleNode() {
	    if (start == null) {
	        return null;
	    }

	    Node slow = start;
	    Node fast = start;

	    while (fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }

	    return slow;
	}
	
	
	
	static void traverse_sll() {
		if(start==null) {
			System.out.println("Sll is Empty.");
			return;
		}
		Node ptr = start;
		while(ptr!=null) {
			System.out.print(ptr.info +"\n");
			ptr = ptr.next;
		}
	}
	
	static void InsertionAtFirst() {
		System.out.println("Enter the item you went to insert: ");
		int item = sc.nextInt();
		Node ptr = new Node(item);
		ptr.info = item;
		ptr.next = start;
		start = ptr;
	}
	
	static void InsertionAtEnd() {
		System.out.println("Enter the item you went to insert: ");
		int item = sc.nextInt();
		Node ptr = new Node(item);
		ptr.info = item;
		ptr.next = null;
		
		if(start==null) {
			start = ptr;
			return;
		}
		
		Node ptr1 = start;
		while(ptr1.next!=null) {
			ptr1 = ptr1.next;
		}
		ptr1.next = ptr;
	}
	
	
	static void InsertionInMiddleBGN(Node ptr) {
		System.out.println("Enter the item you went to insert: ");
		int item = sc.nextInt();
		
		Node ptr1 = new Node(item);
		ptr1.info = item;
		ptr1.next = ptr;
		
		Node ptr2 = start;
		if((ptr2.next==null) || (ptr2==null) || (ptr==start)) {
			start = ptr1;
		}
		else {
			while(ptr2.next != null && ptr2.next != ptr)
				ptr2 = ptr2.next;
			ptr2.next = ptr1;
		}
		
	}
	
}

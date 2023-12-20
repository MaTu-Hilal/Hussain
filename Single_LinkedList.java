package DSA_Project;
import java.util.Scanner;

public class Single_LinkedList {

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
		
		Single_LinkedList() {
			do {
				System.out.println("Press 1 to Traverse");
				System.out.println("Press 2 for Insertion at First");
				System.out.println("Press 3 for Insertion at last");
				System.out.println("Press 4 for Insertion at Middle before given node");
				System.out.println("Press 5 for Insertion at Middle After given node");
				System.out.println("Press 6 to insert item in descending order");
				System.out.println("Press 7 to insert item in ascending order");
				System.out.println("Press 8 to Exit");
				System.out.println("Enter your choice: ");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					traverse_sll();
					break;
				case 2:
					InsertionAtFirst();
					count++;
					break;
				case 3:
					InsertionAtEnd();
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
					Insertion_SLL_Descending();
					count++;
					break;
				case 7:
					Insertion_SLL_Ascending();
					count++;
					break;
				}
			}
			while(choice!=8);
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
		
		
		static void InsertionInMiddleBGN(Node ptr,int item) {
			
			Node ptr1 = new Node(item);
			ptr1.info = item;
			ptr1.next = ptr;
			
			Node ptr2 = start;
			if( (ptr2==null) || (ptr==start)) {
				start = ptr1;
			}
			else {
				while(ptr2.next != null && ptr2.next != ptr)
					ptr2 = ptr2.next;
				ptr2.next = ptr1;
			}
			
		}
		
		static void InsertionInMiddleAGN(Node ptr,int item) {
			
			Node ptr1 = new Node(item);
			Node ptr2 = start;
			if(ptr2==null) 
				start = ptr1;
			else {
				ptr1.info = item;
				ptr1.next = ptr.next;
				ptr.next = ptr1;}
		}
		
		static void Insertion_SLL_Descending() {
			System.out.println("Enter the item you went to insert: ");
			int item = sc.nextInt();
			
			Node ptr = start;
			while((ptr!=null) && (ptr.info>item))
				ptr = ptr.next;
			InsertionInMiddleBGN(ptr,item);
		}
		
		
		static void Insertion_SLL_Ascending() {
			System.out.println("Enter the item you went to insert: ");
			int item = sc.nextInt();
			
			Node ptr = start;
			while((ptr!=null) && (ptr.info<item))
				ptr = ptr.next;
			InsertionInMiddleBGN(ptr,item);
		}
		
	}


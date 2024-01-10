package Linkedlist;
import java.util.Scanner;

public class Queue_Dll {

			static Scanner sc = new Scanner(System.in);
			static int choice;
			static class Node{
				int info;
				Node next;
				Node prev;
				Node(int info){
					this.info = info;
					this.next = null;
				}
			}
			static Node R = null;
			static Node F = null;

			Queue_Dll(){
				do {
				System.out.println("Press 1 for Enqueue");
				System.out.println("Press 2 for Dequeue");
				System.out.println("Press 3 for Display");
				System.out.println("Press 4 for Exit");
				System.out.println("Enter your choice");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Enter the item value you went to insert: ");
					int item = sc.nextInt();
					Enqueue(item);
					break;
				case 2:
					Dequeue();
					break;
				case 3:
					display();
					break;
				}
				}
				while(choice!=4);
			}
			
		/**************************************************************/			
		/******************** Queue Insertion ****************/		
		/**************************************************************/		

			static void Enqueue(int item) {
				Node ptr = new Node(item);
				ptr.info = item;
				ptr.next = null;
				ptr.prev = R;
				if(R==null) {
					F= ptr;
					R = ptr;
				}
				else {
					R = R.next;
					R = ptr;
				}
				
			}
			
		/**************************************************************/			
		/******************** Stack deletion ****************/		
		/**************************************************************/		

			static void Dequeue() {
				if(F==null) {
					System.out.println("Queue Empty!");
					return;
				}
				F = F.next;
				F.prev = null;
				System.out.println("Item deleted Successfully!");
			}
			
		/**************************************************************/			
		/******************** Stack Display ****************/		
		/**************************************************************/		

			static void display() {
				Node ptr = F;
				while(ptr!=null) {
					System.out.println(ptr.info);
					ptr = ptr.next;
				}
			}

}

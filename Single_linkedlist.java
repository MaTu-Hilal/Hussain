package Linkedlist;
import java.util.Scanner;
public class Single_linkedlist {

			static Scanner sc = new Scanner(System.in);
			static int choice;
			
			static class Node{
				int info;
				Node next;
				Node(int info){
					this.info = info;
					this.next = null;
				}
			}
			static Node start = null;
			
			Single_linkedlist() {
				do {
					System.out.println("Press 1 to Traverse");
					System.out.println("Press 2 to Insertion");
					System.out.println("Press 3 to deletion");
					System.out.println("Press 4 to Exit");
					System.out.println("Enter your choice: ");
					choice = sc.nextInt();
					switch(choice) {
					case 1:
						Traverse_SLL();
						break;
					case 2:
						System.out.println("Press 1 for Insertion at First");
						System.out.println("Press 2 for Insertion at last");
						System.out.println("Press 3 for Insertion_InMiddle_BGN");
						System.out.println("Press 4 Insertion_InMiddle_AGN");
						System.out.println("Press 5 for Insertion_InMiddle_Exact_Mid_BGN_SLL");
						System.out.println("Press 6 for Insertion_InMiddle_Exact_Mid_AGN_SLL");
						System.out.println("Press 7 for Insertion_InSortedList_Ascending_SLL");
						System.out.println("Press 8 for Insertion_InSortedList_Descending_SLL");
						System.out.println("Enter your choice: ");
						int choice1 = sc.nextInt();
						
						System.out.println("Enter the item you went to insert: ");
						int item = sc.nextInt();
						switch(choice1) {
						case 1:
							Insertion_AtFirst_SLL(item);
							break;
						case 2:
							Insertion_AtLast_SLL(item);
							break;
						case 3:
							System.out.println("Enter the SItem: ");
							int SItem = sc.nextInt();
							Insertion_InMiddle_BGN(SItem,item);
							break;
						case 4:
							System.out.println("Enter the SItem: ");
							SItem = sc.nextInt();
							Insertion_InMiddle_AGN(SItem,item);
							break;
						case 5:
							Insertion_InMiddle_Exact_Mid_BGN_SLL(item);
							break;
						case 6:
							Insertion_InMiddle_Exact_Mid_AGN_SLL(item);
							break;
						case 7:
							Insertion_InSortedList_Ascending_SLL(item);
							break;
						case 8:
							Insertion_InSortedList_Descending_SLL(item);
							break;
						default:
							System.out.println("Invalid Input");
						}
						break;
					case 3:
						System.out.println("Press 1 to Deletion at first");
						System.out.println("Press 2 to Deletion at last");
						System.out.println("Press 3 to Deletion_InMiddle_SearchNode_SLL");
						System.out.println("Press 4 to Deletion_InMiddle_ExactMiddleNode_Sll");
						System.out.println("Enter your choice: ");
						choice = sc.nextInt();
						switch(choice) {
							case 1:
								Deletion_AtFirst_SLL();
								break;
							case 2:
								Deletion_AtLast_SLL();
								break;
							case 3:
								System.out.println("Enter the SItem to delete: ");
								int SItem = sc.nextInt();
								Deletion_InMiddle_SearchNode_SLL(SItem);
								break;
							case 4:
								Deletion_InMiddle_ExactMiddleNode_Sll();
								break;
							default:
								System.out.println("Invalid Input");
								}
							break;
					}
				}
				while(choice!=4);
			 }
			
/**************************************************************/			
/******************** Traverse Single Linkedlist ****************/		
/**************************************************************/		
			
			static void Traverse_SLL() {
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
			
/**************************************************************/			
/******************** Insertion At first ****************/		
/**************************************************************/		
	
			static void Insertion_AtFirst_SLL(int item) {
				Node ptr = new Node(item);
				ptr.info = item;
				ptr.next = start;
				start = ptr;
			}
			
/**************************************************************/			
/******************** Insertion at last ****************/		
/**************************************************************/		
	
			static void Insertion_AtLast_SLL(int item) {
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
			
/**************************************************************/			
/******************** Insertion In middle BGN ****************/		
/**************************************************************/		
	
			static void Insertion_InMiddle_BGN(int SItem,int item) {
				
				Node ptr = start;
				while((ptr!=null) && (ptr.info!=SItem))
					ptr = ptr.next;
				if(ptr==null) {
					System.out.println("Required item not found.");
					return;
				}
				Node ptr1 = new Node(item);
				ptr1.info = item;
				ptr1.next = ptr;
				if(ptr==start) {
		        	start = ptr1;
		        	return;
		        }
				Node ptr2 = start;
				while(ptr2.next!=ptr)
					ptr2 = ptr2.next;
				ptr2.next = ptr1;
				
			}
			
/**************************************************************/			
/******************** Insertion in Middle AGN ****************/		
/**************************************************************/		
	
			static void Insertion_InMiddle_AGN(int SItem,int item) {
				
				Node ptr = start;
				while((ptr!=null) && (ptr.info!=SItem))
					ptr = ptr.next;
				if(ptr==null) {
					System.out.println("Required item not found.");
					return;
				}
				Node ptr1 = new Node(item);
				ptr1.info = item;
				
				ptr1.next = ptr.next;
				ptr.next = ptr1;
			}
			
/**************************************************************/			
/******************** Insertion In Exact middle BGN ****************/		
/**************************************************************/		
	
			static void Insertion_InMiddle_Exact_Mid_BGN_SLL(int item){
				int count = 0;
				Node ptr1 = start;
				while(ptr1!=null) {
					count = count+1;
					ptr1 = ptr1.next;
				}
				int mid = (count/2)+1;
				Node ptr = new Node(item);
				ptr.info = item;
				
				if((count==0) || (count==1)){
					ptr.next = start;
					start = ptr;
					return;
				}
				Node ptr2 = start;
				for(int i=1;i<=(mid-2);i++) {
					ptr2 = ptr2.next;
				}
				ptr.next = ptr2.next;
				ptr2.next = ptr;
			}
			
/**************************************************************/			
/******************** Insertion in Exact Middle AGN ****************/		
/**************************************************************/		
	
			static void Insertion_InMiddle_Exact_Mid_AGN_SLL(int item){
				int count = 0;
				Node ptr1 = start;
				while(ptr1!=null) {
					count = count+1;
					ptr1 = ptr1.next;
				}
				int mid = (count/2);
				Node ptr = new Node(item);
				ptr.info = item;
				
				if(count==0) {
					ptr.next = null;
					start = ptr;
					return;
				}
				Node ptr2 = start;
				for(int i=1;i<=(mid-1);i++) {
					ptr2 = ptr2.next;
				}
				ptr.next = ptr2.next;
				ptr2.next = ptr;
			}
			
/**************************************************************/			
/******************** Insertion in sorted ascending ****************/		
/**************************************************************/		
	
			static void Insertion_InSortedList_Ascending_SLL(int item) {
				Node ptr = start;
				while((ptr!=null) && (ptr.info<item))
					ptr = ptr.next;
				Node ptr1 = new Node(item);
				ptr1.info = item;
				if(ptr==null) {
					ptr1.next = null;
					if(start==null) {
						start = ptr1;
						return;
					}
					Node ptr2  = start;
					while(ptr2.next != null)
						ptr2 = ptr2.next;
					ptr2.next = ptr1;
					return;
				}
				if(ptr==start) {
					ptr1.next = start;
					start = ptr1;
					return;
				}
				Node ptr2 = start;
				while(ptr2.next !=ptr) 
					ptr2 = ptr2.next;
				ptr2.next = ptr1;
				ptr1.next = ptr;
			}
			
/**************************************************************/			
/******************** Insertion in sorted descending ****************/		
/**************************************************************/		
	
			static void Insertion_InSortedList_Descending_SLL(int item) {
				Node ptr = start;
				while((ptr!=null) && (ptr.info>item))
					ptr = ptr.next;
				Node ptr1 = new Node(item);
				ptr1.info = item;
				if(ptr==null) {
					ptr1.next = null;
					if(start==null) {
						start = ptr1;
						return;
					}
					Node ptr2  = start;
					while(ptr2.next != null)
						ptr2 = ptr2.next;
					ptr2.next = ptr1;
					return;
				}
				if(ptr==start) {
					ptr1.next = start;
					start = ptr1;
					return;
				}
				Node ptr2 = start;
				while(ptr2.next !=ptr) 
					ptr2 = ptr2.next;
				ptr2.next = ptr1;
				ptr1.next = ptr;
			}
			
/**************************************************************/			
/******************** Deletion At first ****************/		
/**************************************************************/		
	
			static void Deletion_AtFirst_SLL() {
				if(start==null) {
					System.out.println("Empty Linkedlist");
					return;
				}
				Node ptr = start;
				start = start.next;
				System.out.println("******Item Deleted Successfully**********");
			}
			
/**************************************************************/			
/******************** Deletion at last ****************/		
/**************************************************************/		
	
			static void Deletion_AtLast_SLL() {
				if(start==null) {
					System.out.println("SLL is Empty");
					return;
				}
				if(start.next == null) {
					start = null;
					System.out.println("******Item Deleted Successfully**********");
					return;
				}
				Node ptr = start;
				while(ptr.next.next!=null) {
					ptr = ptr.next;
				}
				ptr.next = null;
				System.out.println("******Item Deleted Successfully**********");
			}
			
/**************************************************************/			
/******************** Deletion at last ****************/		
/**************************************************************/		
	
			static void Deletion_InMiddle_SearchNode_SLL(int SItem) {
				Node ptr = start;
				while(ptr!=null && ptr.info!=SItem)
					ptr = ptr.next;
				if(ptr==null) {
					System.out.println("Required Item doesn't found");
					return;
				}
				if(ptr==start) {
					start = ptr.next;
					System.out.println("******Item Deleted Successfully**********");
					return;
				}
				Node ptr1 = start;
				while(ptr1.next !=ptr) 
					ptr1 = ptr1.next;
				ptr1.next = ptr.next;
				System.out.println("******Item Deleted Successfully**********");
			}
			
/**************************************************************/			
/******************** Deletion at Exact Middle ****************/		
/**************************************************************/		
		
			static void Deletion_InMiddle_ExactMiddleNode_Sll() {
				int count = 0;
				Node ptr = start;
				while(ptr!=null) {
					count = count+1;
					ptr = ptr.next;
				}
				int mid = (count/2)+1;
				
				if(count==0) {
					System.out.println("SLL is Empty");
					return;
				}
				if(count==1) {
					start = null;
					System.out.println("******Item Deleted Successfully**********");
					return;
				}
				ptr = start;
				for(int i=1;i<=(mid-1);i++) {
					ptr = ptr.next;
				}
				Node ptr1 = ptr.next;
				ptr.next = ptr1.next;
			}	
			

}

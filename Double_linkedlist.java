package Linkedlist;
//Ya Zehra sa

import java.util.Scanner;
public class Double_linkedlist {

				static Scanner sc = new Scanner(System.in);
				static int choice;
				
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
				
				Double_linkedlist() {
					do {
						System.out.println("Press 1 to Traverse");
						System.out.println("Press 2 to Insertion");
						System.out.println("Press 3 to deletion");
						System.out.println("Press 4 to Exit");
						System.out.println("Enter your choice: ");
						choice = sc.nextInt();
						switch(choice) {
						case 1:
							Traverse_DLL();
							break;
						case 2:
							System.out.println("Press 1 for Insertion at First");
							System.out.println("Press 2 for Insertion at last");
							System.out.println("Press 3 for Insertion_InMiddle_BGN");
							System.out.println("Press 4 Insertion_InMiddle_AGN");
							System.out.println("Press 5 for Insertion_InMiddle_Exact_Mid_BGN_DLL");
							System.out.println("Press 6 for Insertion_InMiddle_Exact_Mid_AGN_DLL");
							System.out.println("Press 7 for Insertion_InSortedList_Ascending_DLL");
							System.out.println("Press 8 for Insertion_InSortedList_Descending_DLL");
							System.out.println("Enter your choice: ");
							int choice = sc.nextInt();
							
							System.out.println("Enter the item you went to insert: ");
							int item = sc.nextInt();
							switch(choice) {
							case 1:
								Insertion_AtFirst_DLL(item);
								break;
							case 2:
								Insertion_AtLast_DLL(item);
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
								Insertion_InMiddle_Exact_Mid_BGN_DLL(item);
								break;
							case 6:
								Insertion_InMiddle_Exact_Mid_AGN_DLL(item);
								break;
							case 7:
								Insertion_InSortedList_Ascending_DLL(item);
								break;
							case 8:
								Insertion_InSortedList_Descending_DLL(item);
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
									Deletion_AtFirst_DLL();
									break;
								case 2:
									Deletion_AtLast_DLL();
									break;
								case 3:
									System.out.println("Enter the SItem to delete: ");
									int SItem = sc.nextInt();
									Deletion_InMiddle_SearchNode_DLL(SItem);
									break;
								case 4:
									Deletion_InMiddle_ExactMiddleNode_Dll();
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
	/******************** Traverse double Linkedlist ****************/		
	/**************************************************************/		
				
				static void Traverse_DLL() {
					if(start==null) {
						System.out.println("Dll is Empty.");
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
		
				static void Insertion_AtFirst_DLL(int item) {
					Node ptr = new Node(item);
					ptr.info = item;
					ptr.next = start;
					ptr.prev = null;
					start = ptr;
				}
				
	/**************************************************************/			
	/******************** Insertion at last ****************/		
	/**************************************************************/		
		
				static void Insertion_AtLast_DLL(int item) {
					Node ptr = new Node(item);
					ptr.info = item;
					ptr.next = null;
					
					if(start==null) {
						ptr.prev = null;
						start = ptr;
						return;
					}
					
					Node ptr1 = start;
					while(ptr1.next!=null) {
						ptr1 = ptr1.next;
					}
					ptr1.next = ptr;
					ptr.prev = ptr1;
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
					ptr1.prev = ptr.prev;
					ptr.prev = ptr1;
					if(ptr1.prev==null) 
			        	start = ptr1;
					else
						ptr1.prev.next = ptr1;
					
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
					if(ptr.next!=null)
						ptr.next.prev = ptr1;
					ptr1.prev = ptr;
					ptr.next = ptr1;
				}
				
	/**************************************************************/			
	/******************** Insertion In Exact middle BGN ****************/		
	/**************************************************************/		
		
				static void Insertion_InMiddle_Exact_Mid_BGN_DLL(int item){
					int count = 0;
					Node ptr1 = start;
					while(ptr1!=null) {
						count = count+1;
						ptr1 = ptr1.next;
					}
					int mid = (count/2)+1;
					Node ptr = new Node(item);
					ptr.info = item;
					
					if(count==0) {
						ptr.next = null;
						ptr.prev = null;
						start = ptr;
						return;
					}
					if(count==1) {
						ptr.next = start;
						start.prev = ptr;
						ptr.prev = null;
						start = ptr;
						return;
					}
					Node ptr2 = start;
					for(int i=1;i<mid-1;i++) {
						ptr2 = ptr2.next;
					}
					ptr.next = ptr2;
					ptr.prev = ptr2.prev;
					ptr.prev.next = ptr;
					ptr2.prev = ptr;
				}
				
	/**************************************************************/			
	/******************** Insertion in Exact Middle AGN ****************/		
	/**************************************************************/		
		
				static void Insertion_InMiddle_Exact_Mid_AGN_DLL(int item){
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
						ptr.prev = null;
						start = ptr;
						return;
					}
					ptr1 = start;
					for(int i=1;i<mid-1;i++) {
						ptr1 = ptr1.next;
					}
					ptr.next = ptr1.next;
					if(ptr.next!=null)
						ptr.next.prev = ptr;
					ptr1.next = ptr;
					ptr.prev = ptr1;
				}
				
	/**************************************************************/			
	/******************** Insertion in sorted ascending ****************/		
	/**************************************************************/		
		
				static void Insertion_InSortedList_Ascending_DLL(int item) {
					Node ptr = start;
					while((ptr!=null) && (ptr.info<item))
						ptr = ptr.next;
					Node ptr1 = new Node(item);
					ptr1.info = item;
					if(ptr==null) {
						ptr1.next = null;
						if(start==null) {
							ptr1.prev = null;
							start = ptr1;
							return;
						}
						Node ptr2  = start;
						while(ptr2.next != null)
							ptr2 = ptr2.next;
						ptr2.next = ptr1;
						ptr1.prev = ptr2;
						return;
					}
					if(ptr==start) {
						ptr.prev = ptr1;
						ptr1.next = start;
						start = ptr1;
						ptr1.prev = null;
						return;
					}
					Node ptr2 = start;
					while(ptr2.next !=ptr) 
						ptr2 = ptr2.next;
					ptr.prev = ptr1;
					ptr2.next = ptr1;
					ptr1.next = ptr;
					ptr1.prev = ptr2;
				}
				
	/**************************************************************/			
	/******************** Insertion in sorted descending ****************/		
	/**************************************************************/		
		
				static void Insertion_InSortedList_Descending_DLL(int item) {
					Node ptr = start;
					while((ptr!=null) && (ptr.info>item))
						ptr = ptr.next;
					Node ptr1 = new Node(item);
					ptr1.info = item;
					if(ptr==null) {
						ptr1.next = null;
						if(start==null) {
							ptr1.prev = null;
							start = ptr1;
							return;
						}
						Node ptr2  = start;
						while(ptr2.next != null)
							ptr2 = ptr2.next;
						ptr2.next = ptr1;
						ptr1.prev = ptr2;
						return;
					}
					if(ptr==start) {
						ptr.prev = ptr1;
						ptr1.next = start;
						start = ptr1;
						ptr1.prev = null;
						return;
					}
					Node ptr2 = start;
					while(ptr2.next !=ptr) 
						ptr2 = ptr2.next;
					ptr.prev = ptr1;
					ptr2.next = ptr1;
					ptr1.next = ptr;
					ptr1.prev = ptr2;
				}
				
	/**************************************************************/			
	/******************** Deletion At first ****************/		
	/**************************************************************/		
		
				static void Deletion_AtFirst_DLL() {
					if(start==null) {
						System.out.println("Empty Linkedlist");
						return;
					}
					Node ptr = start;
					start = start.next;
					if(start!=null)
						start.prev = null;
					System.out.println("******Item Deleted Successfully**********");
				}
				
	/**************************************************************/			
	/******************** Deletion at last ****************/		
	/**************************************************************/		
		
				static void Deletion_AtLast_DLL() {
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
					ptr.next = null;
					System.out.println("******Item Deleted Successfully**********");
				}
				
	/**************************************************************/			
	/******************** Deletion at last ****************/		
	/**************************************************************/		
		
				static void Deletion_InMiddle_SearchNode_DLL(int SItem) {
					Node ptr = start;
					while(ptr!=null && ptr.info!=SItem)
						ptr = ptr.next;
					if(ptr==null) {
						System.out.println("Required Item doesn't found");
						return;
					}
					if(ptr==start) {
						ptr = ptr.next;
						ptr.prev = null;
						start = ptr;
						System.out.println("******Item Deleted Successfully**********");
						return;
					}
					Node ptr1 = start;
					while(ptr1.next !=ptr) 
						ptr1 = ptr1.next;
					ptr1.next = ptr.next;
					ptr.next.prev = ptr1;
					System.out.println("******Item Deleted Successfully**********");
				}
				
	/**************************************************************/			
	/******************** Deletion at Exact Middle ****************/		
	/**************************************************************/		
			
				static void Deletion_InMiddle_ExactMiddleNode_Dll() {
					int count = 0;
					Node ptr = start;
					while(ptr!=null) {
						count = count+1;
						ptr = ptr.next;
					}
					int mid = (count/2)+1;
					
					if(count==0) {
						System.out.println("DLL is Empty");
						return;
					}
					if(count==1) {
						start = null;
						System.out.println("******Item Deleted Successfully**********");
						return;
					}
					ptr = start;
					for(int i=1;i<=(mid-2);i++) {
						ptr = ptr.next;
					}
					Node ptr1 = ptr.next;
					ptr.next = ptr1.next;
					 if (ptr1.next != null) {
					        ptr1.next.prev = ptr;
					}
					System.out.println("******Item Deleted Successfully**********");
				}	

}

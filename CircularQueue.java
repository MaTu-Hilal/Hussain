package DSA_Project;

import java.util.Scanner;

public class CircularQueue {
	Scanner sc = new Scanner(System.in);
	static int size;
	static int lb = 0;
	static int F = lb-1;
	static int R = lb-1;
	static int CQ[];
	static int choiceCQ;
	static int item;
	
	CircularQueue() {
		System.out.println("Enter the Size of Circular Queue: ");
		size = sc.nextInt();
		CQ = new int[size];
		do {
			System.out.println("Press 1 for Insertion");
			System.out.println("Press 2 for Deletion");
			System.out.println("Press 3 to Exit");
			System.out.println("Enter your choice: ");
			choiceCQ = sc.nextInt();
			switch(choiceCQ) {
			case 1:
				System.out.println("Enter the Item you went to insert: ");
				item  = sc.nextInt();
				Insert();
				break;
			case 2:
				Delete();
				break;
			}
		}
		while(choiceCQ!=3);
	 }
	
	
	static void Insert() {
		if((R==size+lb-1 && F==lb) || (R==F-1)) {
			System.out.println("Overflow Condition");
			return;
		}
		if(R==lb-1) {
			F = lb;
			R = lb;}
		else if(R==size+lb-1)
			R = lb;
		else
			R = R+1;
		
		CQ[R] = item;
		System.out.println("Insertion Done!");
	}
	
	static void Delete() {
		if(F==lb-1) {
			System.out.println("Underflow Condition");
			return;
		}
		System.out.println("Deleted Item is: "+ CQ[F]);
		if(F==R) {
			F = lb-1;
			R = lb-1;
		}
		else if(F == size+lb-1)
			F = lb;
		else
			F = F+1;
	}
}
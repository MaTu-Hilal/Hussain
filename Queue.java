package DSA_Project;

import java.util.Scanner;

public class Queue {
	
		Scanner sc = new Scanner(System.in);
		static int size;
		static int lb = 0;
		static int F = lb-1;
		static int R = lb-1;
		static int Q[];
		static int choiceQ;
		static int item;
		
		Queue() {
			System.out.println("Enter the Size of Queue: ");
			size = sc.nextInt();
			 Q = new int[size];
			do {
				System.out.println("Press 1 for Insertion");
				System.out.println("Press 2 for Deletion");
				System.out.println("Press 3 to Display");
				System.out.println("Press 4 to Exit");
				System.out.println("Enter your choice: ");
				choiceQ = sc.nextInt();
				switch(choiceQ) {
				case 1:
					System.out.println("Enter the Item you went to insert: ");
					item  = sc.nextInt();
					Insert();
					break;
				case 2:
					Delete();
					break;
				case 3:
					display();
					break;
				}
			}
			while(choiceQ!=4);
		 }
		
		
		static void Insert() {
			if(R==size+lb-1) {
				System.out.println("Overflow Condition");
				return;
			}
			if(R==lb-1)
				F = F+1;
			R = R+1;
			Q[R] = item;
			System.out.println("Item Inserted!");
		}
		
		static void Delete() {
			if(F==lb-1) {
				System.out.println("Underflow Condition");
				return;
			}
			System.out.println("Delete item is: "+Q[F]);
			if(F==R) {
				F = lb-1;
				R = lb-1;
			}
			F = F+1;
		}
		static void display() {
			System.out.println("Queue Value is:");
			for(int i=F;i<=R;i++) {
			System.out.println(Q[i]);
			}
		}
	

}

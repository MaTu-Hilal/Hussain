package Linkedlist;
//Ya Zehra sa

import java.util.Scanner;
public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Press 1 for Single linkedlist.");
			System.out.println("Press 2 for double linkedlist.");
			System.out.println("Press 3 for Stack linkedlist.");
			System.out.println("Press 4 for Queue linkedlist.");
			System.out.println("Press 5 for exit.");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				Single_linkedlist sll = new Single_linkedlist();
				break;
			case 2:
				Double_linkedlist dll = new Double_linkedlist();
				break;
			case 3:
				System.out.println("Press 1 for Stack single  linkedlist.");
				System.out.println("Press 2 for stack double linkedlist.");
				System.out.println("Enter your choice");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					Stack_Sll ssll = new Stack_Sll();
					break;
				case 2:
					Stack_Dll sdll = new Stack_Dll();
					break;
				default:
					System.out.println("You Enter invalid key");
				}
				break;
			case 4:
				System.out.println("Press 1 for Queue single  linkedlist.");
				System.out.println("Press 2 for Queue double linkedlist.");
				System.out.println("Enter your choice");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					Queue_Sll qsll = new Queue_Sll();
					break;
				case 2:
					Queue_Dll qdll = new Queue_Dll();
					break;
				default:
					System.out.println("You Enter invalid key");
				}
				break;
		}
		}
		while(choice!=5);
	}

}

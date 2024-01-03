package DSA_Project;

import java.util.Scanner;

public class Final {
	static int choiceM;

//*************Main Function***************
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Press 1 for Array");
			System.out.println("Press 2 for CircularQueue");
			System.out.println("Press 3 for Stack");
			System.out.println("Press 4 for Queue");
			System.out.println("Press 5 for Single LinkedList");
			System.out.println("Press 6 for doubly LinkedList");
			System.out.println("Press 7 for Exit");
			System.out.println("Enter your choice: ");
			choiceM = sc.nextInt();
			switch(choiceM) {
			case 1:
				Array ar = new Array();
				break;
			case 2:
				CircularQueue cq = new CircularQueue();
				break;
			case 3:
				Stack st = new Stack();
				break;
			case 4:
				Queue Q = new Queue();
				break;
			case 5:
				Single_LinkedList sll = new Single_LinkedList();
				break;
			case 6:
				Doubly_linkedList dll = new Doubly_linkedList();
				break;
			}
	}
	while(choiceM!=7);
}
}



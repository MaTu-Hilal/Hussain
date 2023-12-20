package DSA_Project;

import java.util.Scanner;

public class Stack {
	
	Scanner sc = new Scanner(System.in);
	static int size;
	static int lb = 0;
	static int top = lb-1;
	static int st[];
	static int choiceS;
	static int item;
	
	Stack() {
		System.out.println("Enter the Size of Stack: ");
		size = sc.nextInt();
		 st = new int[size];
		do {
			System.out.println("Press 1 to push");
			System.out.println("Press 2 to pop");
			System.out.println("Press 3 to Display");
			System.out.println("Press 4 to Exit");
			System.out.println("Enter your choice: ");
			choiceS = sc.nextInt();
			switch(choiceS) {
			case 1:
				System.out.println("Enter the Item you went to insert: ");
				item  = sc.nextInt();
				push();
				break;
			case 2:
				pop();
				break;
			case 3:
				display();
				break;
			}
		}
		while(choiceS!=4);
	 }
	 
	static void push() {
		if(top==size+lb-1) {
			System.out.println("Stack Overflow!");
			return;
		}
		top = top+1;
		st[top] = item;
		System.out.println("Item Insert!");
	}
	
	static void pop() {
		if(top==lb-1) {
			System.out.println("Stack Empty!");
			return;
		}
		System.out.println("Delete item is: "+st[top]);
		top = top-1;
		System.out.println("Deletion Done");
	}
	static void display() {
		System.out.println("Stack Value is:  ");
		for(int i=top;i>lb-1;i--) {
		System.out.println(st[i]);
		}
	}

}

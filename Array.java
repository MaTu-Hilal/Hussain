package DSA_Project;
import java.util.Scanner;

public class Array {
	Scanner sc = new Scanner(System.in);
	static int lb=0;
	static int choice,choice1,choice2,choiceM,choiceS,choiceQ;
	static int size;
	static int n=0;
	static int[] ar;
	
	Array(){
		System.out.println("Enter the size of array");
		size = sc.nextInt();
		ar = new int[size];
		
		
		do {
			System.out.println("Press 1 to Treverse");
			System.out.println("Press 2 to Insertion");
			System.out.println("Press 3 to Deletion");
			System.out.println("Press 4 to Searching");
			System.out.println("Press 5 to Sorting");
			System.out.println("Press 6 to Exit");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				Treverse(ar,lb,n);
				break;
			case 2: 
				System.out.println("Enter the Index where you went to Insert Data");
				int idx = sc.nextInt();
				System.out.println("Enter the value:");
				int val = sc.nextInt();
				try {
					Insertion(ar,lb,n,size,idx,val);
				}
				catch (Exception e) {
					System.out.println("Index out of Range");
				}
				n = n+1;
				break;
			case 3:
				System.out.println("Enter the index value you went to delete");
				int item= sc.nextInt();
				Deletion(ar,lb,n,item);
				n = n-1;
				break;
			case 4:
				System.out.println("Press 1 to Linear Search");
				System.out.println("Press 2 to Binary Search");
				System.out.println("Enter your choice");
				choice = sc.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("Press 1 for Linear Single Search");
					System.out.println("Press 2 for Linear Multi Search");
					System.out.println("Enter your choice");
					int z = sc.nextInt();
					switch(z) {
					case 1:
						System.out.println("Enter the value you went to Search");
						item= sc.nextInt();
						LinearSearchSingle(ar,lb,n,item);
						break;
					case 2:
						System.out.println("Enter the value you went to Search");
						item= sc.nextInt();
						LinearSearchMulti(ar,lb,n,item);
						break;
					default:
						System.out.println("Invalid Input");
					}
					break;
				case 2:
					System.out.println("Press 1 for Binary Single Search");
					System.out.println("Press 2 for Binary Multi Search");
					System.out.println("Enter your choice");
					z = sc.nextInt();
					switch(z) {
					case 1:
						System.out.println("Enter the value you went to Search");
						item= sc.nextInt();
						BinarySearchSingle(ar,lb,n,item);
						break;
					case 2:
						System.out.println("Enter the value you went to Search");
						item= sc.nextInt();
						BinarySearchMulti(ar,lb,n,item);
						break;
					default:
						System.out.println("Invalid Input");
					}
					break;
				default:
					System.out.println("Invalid Input");
				}
				break;
			case 5:
				System.out.println("Press 1 to Sort in Ascending Order.");
				System.out.println("Press 2 to Sort in Decending Order.");
				System.out.println("Enter your choice");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Press 1 for Bubble Sort Ascending Order");
					System.out.println("Press 2 for Selection Sort Ascending Order");
					System.out.println("Press 3 for Insertion Sort Ascending Order");
					System.out.println("Press 4 for Shell Sort Ascending Order");
					System.out.println("Press 5 for Merge Sort Ascending Order");
					System.out.println("Press 6 for Quick Sort Ascending Order");
					System.out.println("Enter your choice");
					int z = sc.nextInt();
					switch(z) {
					case 1:
						BubbleSortAsc(ar, lb, n);
						break;
					case 2:
						SelectionSortAsc(ar, lb, n);
						break;
					case 3:
						InsertionSortAsc(ar, lb, n);
						break;
					case 4:
						ShellSortAsc(ar, lb, n);
						break;
					case 5:
						MergeSort(ar, lb, n);
						break;
					case 6:
						QuickSort_Asc(ar, lb, n);
						break;
					default:
						System.out.println("Invalid Input");
					}
					break;
				case 2:
					System.out.println("Press 1 for Bubble Descending Sort");
					System.out.println("Press 2 for Selection Descending Sort");
					System.out.println("Press 3 for Insertion Descending Sort");
					System.out.println("Press 4 for Shell Descending Sort");
					System.out.println("Press 5 for Merge Descending Sort");
					System.out.println("Press 6 for Quick Descending Sort");
					System.out.println("Enter your choice");
					z = sc.nextInt();
					switch(z) {
					case 1:
						BubbleSortDec(ar, lb, n);
						break;
					case 2:
						SelectionSortDec(ar, lb, n);
						break;
					case 3:
						InsertionSortDec(ar, lb, n);
						break;
					case 4:
						ShellSortDec(ar,lb,n);
						break;
					case 5:
						MergeSort_Dec(ar, lb, n);
						break;
					case 6:
						QuickSort_Dec(ar, lb, n);
						break;
					default:
						System.out.println("Invalid Input");
					}
					break;
				}
				break;
			}
		}
		while(choice!=6);
		System.out.println("Exit Successfully");
		
	}
		
//		*****************Treverse******************	
		static void Treverse(int a[],int lb,int n) {
			for(int i=lb;i<=n+lb-1;i++) {
				System.out.println(a[i]);
			}
		}
		
//		*****************Insertion******************
		static void Insertion(int a[],int lb,int n,int size,int k,int item) {
			if(n==size) {
				System.out.println("Overflow Condition");
			 return;}
			if(k>n+lb || k<lb) {
				System.out.println("Invalid Position for Range");
				return;
			}
			for(int i=n+lb-1;i>=k;i--) {
				a[i+1] = a[i];
			}
			a[k] = item;
		}
		
//		*****************Deletion******************
		static void Deletion(int a[],int lb,int n,int k) {
			if(n==0)
				System.out.println("Underflow Condition");
			if(k<lb || k>n+lb-1) {
				System.out.println("Deletion position is not valid");
			}
			for(int i=k+1;i<=n+lb-1;i++) {
				a[i-1] = a[i];
			}
		}
		
		
//		*****************Linear Search Single******************
		static void LinearSearchSingle(int a[],int lb,int n,int item) {
			for(int i=lb;i<=n+lb-1;i++) {
				if(a[i]==item) {
					System.out.println("Item Found at index +"+i);
					return;
					}
			}
			System.out.println("Item not found!");
		}
		
		
//		*****************Linear Search Multiple******************		
		static void LinearSearchMulti(int a[],int lb,int n,int item) {
			int count=0;
			for(int i=lb;i<=n+lb-1;i++) {
				if(a[i]==item)
					count = count+1;
			}
			if(count==0)
				System.out.println("Item not found");
			else
				System.out.println(item+" found "+ count + " times.");
		}
		
//		*****************Binary Search Single******************		
		static void BinarySearchSingle(int a[],int lb,int n,int item) {
			int low = lb;
			int high = n+lb-1;
			
			while(low<=high) {
				int mid = (low+high)/2;
				if(a[mid]==item) {
					System.out.println("Item Found at index: "+mid);
					return;
				}
				else if(item<a[mid]) {
					high = mid-1;
				}
				else
					low = mid + 1;
			}
		}

		 
//		*****************Binary Search Multiple******************	
		static void BinarySearchMulti(int a[],int lb,int n,int item) {
			int low = lb;
			int high = n+lb-1;
			int count=0;
			while(low<=high) {
				int mid = (low+high)/2;
				if(a[mid]==item) {
				    count = count+1;
					int i=mid+1;
					while(i<=high && a[i]==item) {
						count++;
						i++;
					}
					i=mid-1;
					while(i>=low && a[i]==item) {
						count++;
						i--;
					}
					if(count==0) {
						System.out.println("Item doesn't found!");
					return;}
					else {
						System.out.println("Item found "+count+" times.");
						return;}
				}
				else if(item<a[mid]) {
					high = mid-1;
				}
				else
					low = mid + 1;
			}
		}
		
//		*****************Bubble Sort Ascending******************
		static void BubbleSortAsc(int a[],int lb,int n) {   
			for(int i=0;i<n-1;i++) {
				for(int j=0;j<n-i-1;j++) {
					if(a[j]>a[j+1]) {
						int temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
					}}}
			
			System.out.println("********Done******");
		}
		
//		*****************Bubble Sort Descending******************	
		static void BubbleSortDec(int a[],int lb,int n) {
			for(int i=0;i<n-1;i++) {
				for(int j=0;j<n-i-1;j++) {
					if(a[j]<a[j+1]) {
						int temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
					}}}
			
			System.out.println("********Done******");
			}
		
//		*****************Selection Sort Asc******************	
		static void SelectionSortAsc(int a[],int lb,int n) {
			for(int i=0;i<n-1;i++) {
				int loc = i;
				for(int j=i+1;j<n;j++) {
					if(a[j]<a[loc]) {
						loc = j;
					}}
				int temp = a[i];
				a[i] = a[loc];
				a[loc] = temp;
			}
			
			System.out.println("********Done******");
	}
		
//		*****************Selection SOrt Descending******************
		static void SelectionSortDec(int a[],int lb,int n) {
			for(int i=0;i<n-1;i++) {
				int loc = i;
				for(int j=i+1;j<n;j++) {
					if(a[j]>a[loc]) {
						loc = j;
					}}
				int temp = a[i];
				a[i] = a[loc];
				a[loc] = temp;
			}
			
			System.out.println("********Done******");
		}
//		*****************Insertion SOrt accending******************	
		static void InsertionSortAsc(int a[],int lb,int n) {
			int last = lb+1;
			for(int j=lb;j<n-1;j++) {
				int min = a[last];
				int i = last-1;
				while((i>=lb) && (a[i]>min)) {
					a[i+1] = a[i];
					i = i-1;
				}
				a[i+1] = min;
				last = last+1;
			}
			
			System.out.println("********Done******");
		}
		
//		*****************InsertionSort Descending******************	
		static void InsertionSortDec(int a[],int lb,int n) {
			int last = lb+1;
			for(int j=lb;j<n-1;j++) {
				int min = a[last];
				int i = last-1;
				while((i>=lb) && (a[i]<min)) {
					a[i+1] = a[i];
					i = i-1;
				}
				a[i+1] = min;
				last = last+1;
			}
			
			System.out.println("********Done******");
		}

//		*****************ShellSOrt Ascending******************	
		static void ShellSortAsc(int a[],int lb,int n) {
			int gap = n/2;
			while(gap!=0) {
				int last = lb+gap		;
				for(int i=lb;i<n+lb-1;i++) {
					int min = a[last];
					i = last-gap;
					while((i>=lb) && (a[i]>min)) {
						a[i+gap] = a[i];
						i = i-gap;
					}
					a[i+gap] = min;
				}
				gap = gap/2;
			}
			System.out.println("********Done******");
		}
		
//		*****************Shell SOrt Descending******************
		
		static void ShellSortDec(int a[],int lb,int n) {
			int gap = n/2;
			while(gap!=0) {
				int last = lb+gap		;
				for(int i=lb;i<n+lb-1;i++) {
					int min = a[last];
					i = last-gap;
					while((i>=lb) && (a[i]<min)) {
						a[i+gap] = a[i];
						i = i-gap;
					}
					a[i+gap] = min;
				}
				gap = gap/2;
			}
			System.out.println("********Done******");
		}
		
		
//		*****************MergeSort Ascending******************
		
		static void MergeSort(int a[],int lb,int n) {
			int low = lb;
			int high = n+lb-1;
			MergeSort_sub(a,low,high);
			System.out.println("**************Done******************");
		}
		
		static void MergeSort_sub(int a[],int low,int high) {
			if(low<high) {
				int mid = (low+high)/2;
				MergeSort_sub(a,low,mid);
				MergeSort_sub(a,mid+1,high);
				Merge(a,low,mid,high);
			}
		}
		
		static void Merge(int a[],int low,int mid,int high) {
			int lb=0;
			int nL = mid-low+1;
			int nR = high-mid;
			int k = 0;
			int left[] = new int[nL];
			int right[] = new int[nR];
			
			for(int i=low;i<=mid;i++) {
				left[k] = a[i];
				k = k+1;
			}
			int j=0;
			for(int i=mid+1;i<=high;i++) {
				right[j] = a[i];
				j = j+1;
			}
			
			int ptrL = lb;
			int ptrR = lb;
			int ptrA = low;
			
			while(ptrL < nL && ptrR < nR) {
				if(left[ptrL]<right[ptrR]) {
					a[ptrA] = left[ptrL];
					ptrL = ptrL+1;
					ptrA++;
				}
				else {
					a[ptrA] = right[ptrR];
					ptrR = ptrR+1;
					ptrA++;
				}
			}
			
			if(ptrL>(nL)) {
				while(ptrR<(nR)) {
					a[ptrA] = right[ptrR];
					ptrR++;
					ptrA++;
				}}
			else
				{
				while(ptrL<(nL)) {
					a[ptrA] = left[ptrL];
					ptrL++;
					ptrA++;
				}
			}
		}
		
//		*****************MergeSortDescending******************
		
		static void MergeSort_Dec(int a[],int lb,int n) {
			int low = lb;
			int high = n+lb-1;
			MergeSort_sub_Dec(a,low,high);
			System.out.println("**************Done******************");
		}
		
		static void MergeSort_sub_Dec(int a[],int low,int high) {
			if(low<high) {
				int mid = (low+high)/2;
				MergeSort_sub_Dec(a,low,mid);
				MergeSort_sub_Dec(a,mid+1,high);
				Merge_Dec(a,low,mid,high);
			}
		}
		
		static void Merge_Dec(int a[],int low,int mid,int high) {
			int lb=0;
			int nL = mid-low+1;
			int nR = high-mid;
			int k = 0;
			int left[] = new int[nL];
			int right[] = new int[nR];
			
			for(int i=low;i<=mid;i++) {
				left[k] = a[i];
				k = k+1;
			}
			int j=0;
			for(int i=mid+1;i<=high;i++) {
				right[j] = a[i];
				j = j+1;
			}
			
			int ptrL = lb;
			int ptrR = lb;
			int ptrA = low;
			
			while(ptrL < nL && ptrR < nR) {
				if(left[ptrL]>right[ptrR]) {
					a[ptrA] = left[ptrL];
					ptrL = ptrL+1;
					ptrA++;
				}
				else {
					a[ptrA] = right[ptrR];
					ptrR = ptrR+1;
					ptrA++;
				}
			}
			
			if(ptrL>(nL)) {
				while(ptrR<(nR)) {
					a[ptrA] = right[ptrR];
					ptrR++;
					ptrA++;
				}}
			else
				{
				while(ptrL<(nL)) {
					a[ptrA] = left[ptrL];
					ptrL++;
					ptrA++;
				}
			}
		}
		

//		*******************QuickSOrt Ascending****************


		static void QuickSort_Asc(int a[],int lb,int n) {
			int low = lb;
			int high = n+lb-1;
			QuickSort_Asc_sub(a,low,high);
			System.out.println("**************Done******************");
		}
		
		static void QuickSort_Asc_sub(int a[],int low,int high) {
			if(low<high) {
				int idx = Partition(a,low,high);
				QuickSort_Asc_sub(a,low,idx-1);
				QuickSort_Asc_sub(a,idx+1,high);
			}
		}
		
		static int Partition(int a[],int low,int high){
			int pivot = a[low];
			int i = low+1;
			int j = high;
			
			while(i<j) {
				while((i<=high) && (a[i]<=pivot)) 
					i++;
				while(a[j]>pivot) 
					j--;
				if(i<j) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
				else {
					int temp = a[low];
					a[low] = a[j];
					a[j] = temp;
				}
			}
			return j;
		}
		
		
//		*******************QuickSOrt Descending****************


		static void QuickSort_Dec(int a[],int lb,int n) {
			int low = lb;
			int high = n+lb-1;
			QuickSort_Dec_sub(a,low,high);
			System.out.println("**************Done******************");
		}
		
		static void QuickSort_Dec_sub(int a[],int low,int high) {
			if(low<high) {
				int idx = PartitionDec(a,low,high);
				QuickSort_Dec_sub(a,low,idx-1);
				QuickSort_Dec_sub(a,idx+1,high);
			}
		}
		
		static int PartitionDec(int a[],int low,int high){
			int pivot = a[low];
			int i = low+1;
			int j = high;
			
			while(i<=j) {
				while(a[i]>=pivot)
					i++;
				while((j>=lb) && (a[j]<pivot))
					j--;
				if(i<j) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
				else {
					int temp = a[low];
					a[low] = a[j];
					a[j] = temp;
				}
			}
			return j;
		}

}

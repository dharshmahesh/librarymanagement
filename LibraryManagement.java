import java.util.Scanner;

public class LibraryManagement {
	static String arr[] = new String[100];
	static int ptr = 0;
	static String takenBooks[] = new String[100];
	static int ptr2 = 0;
	static String name = "";

	public static void addBook(String book) {
		arr[ptr] = book;
		ptr++;
		System.out.println("---------------------------------");
		System.out.println("Book has been successfully added");
		System.out.println("---------------------------------");
	}

	public static void listBooks() {
		if (ptr == 0) {
			System.out.println("--------------------------------");
			System.out.println("There are no books to display!!!");
			System.out.println("--------------------------------");
		} else {
			System.out.println("--------------------");
			for (int i = 0; i < ptr; i++) {
				if (arr[i].equals("")) {
					continue;
				}
				System.out.println(arr[i]);
			}
			System.out.println("--------------------");
		}
	}

	public static void takeBook() {
		if (ptr == 0) {
			System.out.println("------------------------------");
			System.out.println("There are no books to take!!!");
			System.out.println("------------------------------");
		} else {
			for (int i = 0; i < ptr; i++) {
				if (arr[i].equals("")) {
					continue;
				}
				System.out.println("Enter " + (i + 1) + " to take " + arr[i]);
			}
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			if (arr[input - 1].equals("")) {
				System.out.println("---------------------------------------------");
				System.out.println("Sorry, The book is currently not available!!!");
				System.out.println("---------------------------------------------");
			} else {
				takenBooks[ptr2] = arr[input - 1];
				arr[input - 1] = "";
				System.out.println("---------------------------------");
				System.out.println("Book has been successfully taken");
				System.out.println("---------------------------------");
				ptr2++;
			}
		}
	}

	public static void returnBook() {
		if (ptr2 == 0) {
			System.out.println("-------------------------------");
			System.out.println("There are no books to return!!!");
			System.out.println("-------------------------------");
		} else {
			System.out.println("------------------------------------------------------------");
			for (int i = 0; i < ptr2; i++) {
				System.out.println("Enter " + (i + 1) + " to return " + takenBooks[i]);
			}
			System.out.println("------------------------------------------------------------");

			Scanner sc = new Scanner(System.in);
			int returnChoice = sc.nextInt();
			if (returnChoice >= 1 && returnChoice <= ptr2) {
				int index = returnChoice - 1;
				arr[ptr] = takenBooks[index];
				ptr++;
				System.out.println("------------------------------------");
				System.out.println("Book has been successfully returned");
				System.out.println("------------------------------------");
				for (int i = index; i < ptr2 - 1; i++) {
					takenBooks[i] = takenBooks[i + 1];
				}
				takenBooks[ptr2 - 1] = "";
				ptr2--;
			} else {
				System.out.println("---------------------------------");
				System.out.println("Invalid choice. No book returned.");
				System.out.println("---------------------------------");
			}
		}
	}

	public static void printRegister() {
		System.out.println("------------------------------------");
		System.out.println("Register as a student to continue!!!");
		System.out.println("------------------------------------");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("----------------------------------");
			System.out.println("Enter 1 for Student Registration");
			System.out.println("Enter 2 to Add book");
			System.out.println("Enter 3 to view the list of books");
			System.out.println("Enter 4 to take a book");
			System.out.println("Enter 5 to return a book");
			System.out.println("Enter 6 to Exit");
			System.out.println("----------------------------------");
			System.out.println("Enter your choice : ");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println("Enter the name of the Student : ");
       sc.nextLine();
				name = sc.nextLine();
				System.out.println("Enter Student ID : ");
				String id = sc.next();
				System.out.println("Welcome " + name + " !");
				break;
			case 2:
				if (name.equals("")) {
					printRegister();
				} else {
					System.out.println("Enter the name of the book : ");
         sc.nextLine();
					String book = sc.nextLine();
					addBook(book);
				}
				break;
			case 3:
				if (name.equals("")) {
					printRegister();
				} else {
					listBooks();
				}
				break;
			case 4:
				if (name.equals("")) {
					printRegister();
				} else {
					takeBook();
					break;
				}
			case 5:
				if (name.equals("")) {
					printRegister();
				} else {
					returnBook();
				}
				break;
			case 6:
				System.out.println("----------------------------------------");
				System.out.println("Thank you " + name + " !");
				System.out.println("----------------------------------------");
				System.exit(0);
			}
		}
	}
}
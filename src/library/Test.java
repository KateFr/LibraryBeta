package library;

import java.util.Scanner;

public class Test {
	public static void main(String[] arguments) 
    {
		
		//Create Library
		Library library  = new Library();
		//Add books
		library.addBook(new Book ("It", "S.King", 1998));
		library.addBook( new Book ("Game of thrones", "G.R.R.Martin", 2000));			
		library.addBook( new Book ("Diune", "F.Herbert", 1965));	
		//List all books
		System.out.println("*****  Book list *****");
		library.listBooks();
		
		//Search options:
		//Title and Author,Title or Author, Title, Author,Year 	

		System.out.println(library.searchBook("It","S.king")); 
		System.out.println(library.searchBook("S.king")); 
		System.out.println(library.searchBook("Diune")); 
		System.out.println(library.searchBook(2000)); 
		
		//Borrow a book
		Scanner sc =new Scanner(System.in);
		System.out.println("Give ID of book you want to lent");
		library.borrowBook(sc.next());
		
		//Show details of selected book		
		System.out.println("Give ID of book to see details");
		library.showBook(sc.next());
		
		//Remove a book	
		System.out.println("\nGive ID of book you want to remove");
		library.removeBook(sc.next());
		System.out.println("Book list");
		library.listBooks();
    
    }
    
}

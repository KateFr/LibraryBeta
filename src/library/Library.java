package library;
import java.util.ArrayList;
import java.util.Scanner;


public class Library {
	
	private static ArrayList <Book> books;

	public Library() {
	books = new ArrayList<Book>();
	}
	
	public void addBook (Book book) {
		books.add(book);
	}
		
	public void listBooks () {
		for (int i=0;i<books.size();i++) {			
			System.out.println( books.get(i).getBook());						
		}
	}	
	
		
	public String searchTitle (String searchTitle) {
		
		for (Book book: books) {
			if (searchTitle.equalsIgnoreCase(book.getTitle())) {
				return book.toString();}									
		}
		return "\n No Books Avaliable ";
		}
	//This method search book by title ,author or year
	public String searchBook (String search) {
		
		for (Book book: books) {			
			if( book.toString().toLowerCase().contains(search.toLowerCase())) {
				 return book.getBook();}									
		}
		return "\n No Books Avaliable ";
	}
	
	
	public String showBook(String id) {	
  		Book libBook; 	
		for (int i=0;i<books.size();i++){
			libBook = books.get(i);
			if (libBook.getId().equals(id)){				
					System.out.println("Book details: " + libBook.getBook());
					return null;				
			}			
		}
		System.out.println("This book is not in our catalog.");
		return null;
	}
		
	
	public String borrowBook(String id) {	
	  		Book libBook; 	
			for (int i=0;i<books.size();i++){
				libBook = books.get(i);
				if (libBook.getId().equals(id)){
					if(libBook.isBorrowed()==false) {
						libBook.borrowed();
						System.out.println("Type your name:");					
						Scanner sc= new Scanner(System.in);						
						libBook.setBorrower(sc.next());
						libBook.borrowed();
						System.out.println("You successfully borrowed " + libBook.getBook());
						return null;
					}
					else
					{
						System.out.println("This book is already borrowed.");
						return null;
					}
				}			
			}
			System.out.println("This book is not in our catalog.");
			return null;
	}
		
	
		public String removeBook(String id) {
			Book libBook; 	
			for (int i=0;i<books.size();i++){
				libBook = books.get(i);
				if (libBook.getId().equals(id)){
					if(libBook.isBorrowed()==true) {
						
						System.out.println("Cannot remove, this book is borrowed " + libBook.getBook());
						return null;
					}
					else
					{
						books.remove(i);
						System.out.println("This book has been removed.");
						return null;
					}
				}			
			}
			System.out.println("This book is not in our catalog.");
			return null;
		}
		
		//Tests
				public static void main(String[] arguments) 
		    {
				
				//Create Library
				Library library  = new Library();
				//Add books
				library.addBook(new Book ("It", "S.King", 1998));
				library.addBook( new Book ("Game of thrones", "G.R.R.Martin", 2000));			
				library.addBook( new Book ("Diune", "F.Herbert", 1965));	
				//List all books
				System.out.println("Book list");
				library.listBooks();
				
				//Search book using search phrase
				/*System.out.println(library.searchBook("Martin")); */
				
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

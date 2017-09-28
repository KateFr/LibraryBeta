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
	
	//This methods search book by title ,author or year	
	public String searchBook (String searchString) {
		
		for (Book book: books) {
			if (searchString.equalsIgnoreCase(book.getTitle())) {
				return "\n Search results: " + book.getBook();}
			else {
				if(searchString.equalsIgnoreCase(book.getAuthor())) {
					return "\n Search results: " + book.getBook();}
				}
				
		}
		return "\n No Books Avaliable ";
		}
	
	public String searchBook (String searchTitle,String searchAuthor ) {
		
		for (Book book: books) {
			if (searchTitle.equalsIgnoreCase(book.getTitle()) && searchAuthor.equalsIgnoreCase(book.getAuthor())) {
				return "\n Search results: " + book.getBook();}			
				
		}
		return "\n No Books Avaliable ";
		}
	
	public String searchBook (int year) {
		
		for (Book book: books) {
			if (year == book.getYear()) {
				return "\n Search results: " + book.getBook();}									
		}
		return "\n No Books Avaliable ";
		}
	
	public String searchBook (String searchString, int year) {
		
		for (Book book: books) {
			if (year == book.getYear()) {
				return "\n Search results: " + book.getBook();}								
		}
		return "\n No Books Avaliable ";
		}
	
	
	/*public String searchBook (String search) {
		
		for (Book book: books) {			
			if( book.toString().toLowerCase().contains(search.toLowerCase())) {
				 return book.getBook();}									
		}
		return "\n No Books Avaliable ";
	} */
		
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
				
			
}

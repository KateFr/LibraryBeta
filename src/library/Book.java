package library;
import java.util.UUID;

public class Book {

	private final String title;
	private final String author;
	private final int year;
	boolean borrowed;
	private String borrower;
	private String id;
	
	public Book(String title, String author, int year) {
		this.title =title;
		this.author=author;
		this.year =year;
		this.borrowed = false;
		id = UUID.randomUUID().toString();

	}
	
	public void borrowed() 
	    {
	        borrowed = true;
	    }

	public void returned() 
    {
    	borrowed = false;
    }
	
	public boolean isBorrowed() {
		return borrowed;
	}

	public String getTitle() {
		return title;
	}
	
	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getAuthor() {
		return author;
	}
	public int getYear () {
		return year;
	}
	
	public String getId() {
		return id;
	}		
	
	public String toString () {
		return title +" " + author +" "+year;
	}
	
	public String getBook () {
		return "\nTitle: "+ title +"\nAuthor: " + author +"\nYear: "+year+"\nId: "+id+"\nBorrowed: "+isBorrowed() +" by "+borrower;
	}

	//Tests
	/*public static void main(String[] arguments) 
    {
        //test of the Book class      
        Book book1 = new Book ("It", "S.King", 1998);
    	Book book2 = new Book ("Game of thrones", "G.R.R.Martin", 2000);
        System.out.println("Title : " + book1.getTitle());
        System.out.println("Author : " + book1.getAuthor());
        System.out.println("Year : " + book1.getYear());
        System.out.println("ISBN: " + book1.getId());
        System.out.println(book2.toString());
        System.out.println("Book details: " + book2.getBook());
        System.out.println("Borrowed? (should be false): " + book1.isBorrowed());
        book1.borrowed();
        System.out.println("Borrowed? (should be true): " + book1.isBorrowed());
        book1.returned();
        System.out.println("Borrowed? (should be false): " + book1.isBorrowed());
    }*/
	
	
	
}

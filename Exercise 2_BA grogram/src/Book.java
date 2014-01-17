import java.util.Date;


public class Book {
	String Isbn;
	int CopyNumber;
	String Title;
	String Author;
	String Publisher;
	int Year;
	int Statistics;
	Date BorrowDate;
	Date ReturnDate;
	int LibraryCardNumber;

	
	public Book(String Isbn, int CopyNumber, String Title, String Author, 
			String Publisher, int Year, int Statistics, 
			Date BorrowDate, Date ReturnDate, int LibraryCardNumber ){
			
			this.Isbn = Isbn;
			this.CopyNumber = CopyNumber;
			this.Title = Title;
			this.Author = Author;
			this.Publisher = Publisher;
			this.Year = Year;
			this.Statistics = Statistics;
			this.BorrowDate = BorrowDate;
			this.ReturnDate = ReturnDate;
			this.LibraryCardNumber = LibraryCardNumber;
	}

	public Book(String Isbn, int CopyNumber, String Title, String Author, 
			String Publisher, int Year, int Statistics, 
			Date BorrowDate){
			
			this.Isbn = Isbn;
			this.CopyNumber = CopyNumber;
			this.Title = Title;
			this.Author = Author;
			this.Publisher = Publisher;
			this.Year = Year;
			this.Statistics = Statistics;
			this.BorrowDate = BorrowDate;
				}

	
	/*
	 * Getters and Setters
	 */
	
	public String getIsbn(){
		return Isbn;
	}
	public void setIsbn(String Isbn){
		//check Isbn number here
		
		this.Isbn = Isbn;
	
	}
	
	public int getCopyNumber(){
		return CopyNumber;
	}
	
	public void setCopyNumber(int CopyNumber){
		this.CopyNumber = CopyNumber;
	}
	
	public String getTitle(){
		return Title;
	}
	public void setTitle(String Title){
		this.Title = Title;
	}
	
	public String getAuthor(){
		return Author;
	}
	public void setAuthor(String Author){
		this.Author = Author;
	}
	
	public String getPublisher(){
		return Publisher;
	}
	public void setPublisher(String Publisher){
		this.Publisher = Publisher;
	}
	
	public int getYear(){
		return Year;
	}
	public void setYear(int Year){
		this.Year = Year;
	}
	
	public int getStatistics(){
		return Statistics;
	}
	public void setStatistics(int Statistics){
		this.Statistics = Statistics;
	}
	
	public Date getBorrowDate(){
		return BorrowDate;
	}
	public void setBorrowDate(Date BorrowDate){
		this.BorrowDate = BorrowDate;
	}
	
	public Date getReturnDate(){
		return ReturnDate;
	}
	public void setReturnDate(Date ReturnDate){
		this.ReturnDate = ReturnDate;
	}
	
	public int getLibraryCardNumber(){
		return LibraryCardNumber;
	}
	public void setLibraryCardNumber(int LibraryCardNumber){
		this.LibraryCardNumber = LibraryCardNumber;
	}
	
	
}

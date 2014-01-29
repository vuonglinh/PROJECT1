import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	validateInput checkInput = new validateInput();

	public Book(String Isbn, int CopyNumber, String Title, String Author,
			String Publisher, int Year, int Statistics, Date BorrowDate,
			Date ReturnDate, int LibraryCardNumber) {

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
			String Publisher, int Year, int Statistics, Date BorrowDate) {

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

	public String getIsbn() {
		return Isbn;
	}

	public void setIsbn(String nIsbn) {
		if (validateInput.isISBN13Valid(nIsbn)) {
			Isbn = nIsbn;
		}
	}

	public int getCopyNumber() {
		return CopyNumber;
	}

	public void setCopyNumber(String nCopyNumber) {

		if (validateInput.isValidCopyNumber(nCopyNumber)) {
			CopyNumber = Integer.parseInt(nCopyNumber);
		}
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String nTitle) {
		if (validateInput.isValidTitle(nTitle)) {
			Title = nTitle;
		}
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String nAuthor) {
		if (validateInput.isValidAuthor(nAuthor)) {
			Author = nAuthor;
		}

	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String nPublisher) {
		if (validateInput.isValidPublisher(nPublisher)) {
			Publisher = nPublisher;
		}

	}

	public int getYear() {
		return Year;
	}

	public void setYear(String nYear) {
		if (validateInput.isValidYear(nYear)) {
			Year = Integer.parseInt(nYear);
		}
	}

	public int getStatistics() {
		return Statistics;
	}

	public void setStatistics(String nStatistics) {
		if (validateInput.isValidStatistics(nStatistics)) {
			Statistics = Integer.parseInt(nStatistics);
		}

	}

	public Date getBorrowDate() {
		return BorrowDate;
	}

	public void setBorrowDate(String nBorrowDate) {
		try {

			SimpleDateFormat fmd = new SimpleDateFormat("yyMMdd");
			if (validateInput.isValidBorrowDate(nBorrowDate)) {

				BorrowDate = fmd.parse(nBorrowDate);
			}
		} catch (ParseException pex) {
			pex.printStackTrace();
		}
	}

	public Date getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(String nReturnDate) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyMMdd");

			if (validateInput.isValidReturnDate(nReturnDate)) {
				ReturnDate = df.parse(nReturnDate);
			}
		} catch (ParseException pex) {
			pex.printStackTrace();
		}

	}

	public int getLibraryCardNumber() {
		return LibraryCardNumber;
	}

	public void setLibraryCardNumber(String nLibraryCardNumber) {
		if (validateInput.isValidLibraryCardNumber(nLibraryCardNumber)) {
			LibraryCardNumber = Integer.parseInt(nLibraryCardNumber);
		}
	}

	public boolean isValidForAllDataField() {
		// TODO Auto-generated method stub
		return false;
	}

}

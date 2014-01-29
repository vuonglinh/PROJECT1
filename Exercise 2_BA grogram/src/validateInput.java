import java.text.ParseException;
import java.text.SimpleDateFormat;

public class validateInput {
	public static void main(String[] args) {

	}

	// check values for ISBN 13 number

	public static boolean isISBN13Valid(String isbn) {
		int check = 0;

		for (int i = 0; i < 12; i += 2) {
			check += Integer.valueOf(isbn.substring(i, i + 1));
		}
		for (int i = 1; i < 12; i += 2) {
			check += Integer.valueOf(isbn.substring(i, i + 1)) * 3;
		}
		check += Integer.valueOf(isbn.substring(12));
		return check % 10 == 0;
	}

	// check values for number of copies
	public static boolean isValidCopyNumber(String numberOfCopies) {
		try {
			Integer.parseInt(numberOfCopies);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	// check values for Year

	public static boolean isValidYear(String Year) {
		try {
			Integer.parseInt(Year);
			return true;
		} catch (NumberFormatException fex) {
			return false;
		}
	}

	// check values for Statistics
	public static boolean isValidStatistics(String statistics) {
		try {
			Integer.parseInt(statistics);
			return true;
		} catch (NumberFormatException fex) {
			return false;
		}
	}

	// check values for book title
	public static boolean isValidTitle(String bookTitle) {
		if (bookTitle == null || bookTitle.isEmpty()) {
			System.err.println("This data cannot be null or empty !");
			return false;
		} else {
			return true;
		}
	}

	// check values for book author
	public static boolean isValidAuthor(String bookAuthor) {
		if (bookAuthor == null || bookAuthor.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	// check values for publisher

	public static boolean isValidPublisher(String publisher) {
		if (publisher == null || publisher.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	// check values for BorrowDate
	public static boolean isValidBorrowDate(String borrowDate) {

		try {
			SimpleDateFormat df = new SimpleDateFormat("yyMMdd");
			df.setLenient(false);
			df.parse(borrowDate);
			return true;
		} catch (ParseException pex) {
			return false;
		}
	}

	// check values for ReturnDate
	public static boolean isValidReturnDate(String returnDate) {
		if (returnDate == null) {
			return true;
		} else {
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyMMdd");
				df.setLenient(false);
				df.parse(returnDate);
				return true;
			} catch (ParseException pex) {
				return false;
			}
		}

	}

	// check value for LibraryCardNumber
	public static boolean isValidLibraryCardNumber(String LibraryCardNumber) {
		try {
			Integer.parseInt(LibraryCardNumber);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.FormatterClosedException;

public class HandlingBook {

	public ArrayList<Book> readingBook(String filename) {
		ArrayList<Book> bookManagement = new ArrayList<>();
		String line = null;

		try {
			BufferedReader reading = new BufferedReader(
					new FileReader(filename));

			while ((line = reading.readLine()) != null) {
				Book singleBook = null;
				if ((singleBook = parseToBook(line)) != null) {
					if (singleBook.getYear() >= 2005) {
						bookManagement.add(singleBook);
					}
				} else {
					continue;
				}
			}
			reading.close();
		} catch (FileNotFoundException fex) {
			System.err.println("Cannot find this file !");
			System.exit(-1);
		} catch (IOException ex) {
			System.err.println("Could not read this file !");
			System.exit(-1);
		}

		return bookManagement;
	}

	public void writeToFile(ArrayList<Book> bookList, String filename) {
		try {
			BufferedWriter writing = new BufferedWriter(
					new FileWriter(filename));
			for (Book eachBook : bookList) {
				String bookLine = eachBook.getIsbn() + "#"
						+ eachBook.getCopyNumber() + "#" + eachBook.getTitle()
						+ "#" + eachBook.getAuthor() + "#"
						+ eachBook.getPublisher() + "#" + eachBook.getYear()
						+ "#" + eachBook.getStatistics() + "#"
						+ eachBook.getBorrowDate() + "#"
						+ eachBook.getReturnDate() + "#"
						+ eachBook.getLibraryCardNumber();
			}
			writing.close();
		} catch (IOException ex) {
			System.err.println("Cannot print this file !");
			System.exit(-1);
		}
	}

	private Book parseToBook(String line) {
		String[] bookLine;
		Book eachBook = null;

		if (line == null || line.isEmpty()) {
			return null;
		}

		if ((bookLine = line.split("#")).length == 10) {
			int CopyNumber = Integer.parseInt(bookLine[1]);
			int Year = Integer.parseInt(bookLine[5]);
			int Statistics = Integer.parseInt(bookLine[6]);
			
			// Here I want to convert from String to Date
			try{
			DateFormat df = new SimpleDateFormat("yyMMDD");
			
			Date BorrowDate = df.parse(bookLine[7]);
			Date ReturnDate = df.parse(bookLine[8]);
			}catch(FormatterClosedException fex){
				System.err.println("Cannot convert from String to Date !");
				System.exit(-1);
			}
			int LibraryCardNumber = Integer.parseInt(bookLine[9]);
			eachBook = new Book(bookLine[0], CopyNumber, bookLine[2],
					bookLine[3], bookLine[4], Year, Statistics, BorrowDate, ReturnDate, LibraryCardNumber);
		}else{
			int CopyNumber = Integer.parseInt(bookLine[1]);
			int Year = Integer.parseInt(bookLine[5]);
			int Statistics = Integer.parseInt(bookLine[6]);
			
			try{
			DateFormat df = new SimpleDateFormat("yyMMDD");
			
			Date BorrowDate = df.parse(bookLine[7]);
			
			}catch(FormatterClosedException fex){
				System.err.println("Cannot convert from String to Date !");
				System.exit(-1);
			}
			
			eachBook = new Book(bookLine[0], CopyNumber, bookLine[2],
					bookLine[3], bookLine[4], Year, Statistics, BorrowDate);
		}
		
		
		if (eachBook == null) {
			return null;
		}
		return eachBook;
	}
}
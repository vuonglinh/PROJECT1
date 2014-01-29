import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.FormatterClosedException;

public class HandlingBook {

	public ArrayList<Book> readingBook(String filename) throws ParseException {
		ArrayList<Book> bookManagement = new ArrayList<>();
		String line = null;

		try {
			BufferedReader reading = new BufferedReader(
					new FileReader(filename));

			while ((line = reading.readLine()) != null) {
				Book singleBook = null;

				if ((singleBook = parseToBook(line)) != null) {

					bookManagement.add(singleBook);
				} else {
					continue;

				}

			}
			reading.close();
		} catch (FileNotFoundException fex) {
			System.err.println("Cannot find this file !");
			// return null;
			System.exit(-1);
		} catch (IOException ex) {
			System.err.println("Could not read this file !");
			System.exit(-1);
		}

		return bookManagement;
	}

	public void writeToFile(ArrayList<Book> bookList, String fileCorrect,
			String fileError) {
		try {
			BufferedWriter writing1 = new BufferedWriter(new FileWriter(
					fileCorrect));

			BufferedWriter writing2 = new BufferedWriter(new FileWriter(
					fileError));

			SimpleDateFormat df = new SimpleDateFormat("yyMMdd");

			for (Book eachBook : bookList) {
				String bookLine;

				if (eachBook.getReturnDate() != null) {
					bookLine = eachBook.getIsbn() + "#"
							+ eachBook.getCopyNumber() + "#"
							+ eachBook.getTitle() + "#" + eachBook.getAuthor()
							+ "#" + eachBook.getPublisher() + "#"
							+ eachBook.getYear() + "#"
							+ eachBook.getStatistics() + "#"
							+ df.format(eachBook.getBorrowDate()) + "#"
							+ df.format(eachBook.getReturnDate()) + "#"
							+ eachBook.getLibraryCardNumber();
				} else {

					bookLine = eachBook.getIsbn() + "#"
							+ eachBook.getCopyNumber() + "#"
							+ eachBook.getTitle() + "#" + eachBook.getAuthor()
							+ "#" + eachBook.getPublisher() + "#"
							+ eachBook.getYear() + "#"
							+ eachBook.getStatistics() + "#"
							+ df.format(eachBook.getBorrowDate());
				}

				if ((eachBook.getReturnDate() == null
						&& eachBook.getYear() >= 2007
						&& validateInput.isISBN13Valid(eachBook.getIsbn()) == true
						&& validateInput.isValidCopyNumber(Integer
								.toString((eachBook.getCopyNumber())))
						&& validateInput.isValidTitle(eachBook.getTitle()) == true
						&& validateInput.isValidAuthor(eachBook.getAuthor()) == true
						&& validateInput.isValidPublisher(eachBook
								.getPublisher()) == true
						&& validateInput.isValidYear(Integer.toString(eachBook
								.getYear()))
						&& validateInput.isValidStatistics(Integer
								.toString(eachBook.getStatistics())) && validateInput
							.isValidBorrowDate(df.format(eachBook
									.getBorrowDate())))
						|| (eachBook.getReturnDate() != null
								&& eachBook.getYear() >= 2007
								&& validateInput.isISBN13Valid(eachBook
										.getIsbn()) == true
								&& validateInput.isValidCopyNumber(Integer
										.toString((eachBook.getCopyNumber())))
								&& validateInput.isValidTitle(eachBook
										.getTitle()) == true
								&& validateInput.isValidAuthor(eachBook
										.getAuthor()) == true
								&& validateInput.isValidPublisher(eachBook
										.getPublisher()) == true
								&& validateInput.isValidYear(Integer
										.toString(eachBook.getYear()))
								&& validateInput.isValidStatistics(Integer
										.toString(eachBook.getStatistics()))
								&& validateInput.isValidBorrowDate(df
										.format(eachBook.getBorrowDate()))
								&& validateInput.isValidReturnDate(df
										.format(eachBook.getReturnDate())) && validateInput
									.isValidLibraryCardNumber(Integer
											.toString(eachBook
													.getLibraryCardNumber())))) {
					writing1.write(bookLine);
					writing1.newLine();
				} else {
					writing2.write(bookLine);
					writing2.newLine();
				}

			}
			writing1.close();
			writing2.close();
		} catch (IOException ex) {
			System.err.println("Cannot print this file !");
			ex.printStackTrace();
			System.exit(-1);
		}
	}

	private Book parseToBook(String line) throws ParseException {
		String[] bookLine;
		Book eachBook = null;

		if (line == null || line.isEmpty()) {
			return null;
		}

		if ((bookLine = line.split("#")).length == 10) {

			try {
				int CopyNumber = Integer.parseInt(bookLine[1]);
				int Year = Integer.parseInt(bookLine[5]);
				int Statistics = Integer.parseInt(bookLine[6]);

				SimpleDateFormat df = new SimpleDateFormat("yyMMdd");
				Date BorrowDate = df.parse(bookLine[7]);
				Date ReturnDate = df.parse(bookLine[8]);
				int LibraryCardNumber = Integer.parseInt(bookLine[9]);

				eachBook = new Book(bookLine[0], CopyNumber, bookLine[2],
						bookLine[3], bookLine[4], Year, Statistics, BorrowDate,
						ReturnDate, LibraryCardNumber);

			} catch (ParseException pex) {
				pex.printStackTrace();
			} catch (NumberFormatException nex) {
//				System.err.println("Cannot convert from string to number");
//				nex.printStackTrace();
			return null;
				// System.exit(-1);

			}

		}

		if ((bookLine = line.split("#")).length == 8) {

			try {
				int CopyNumber = Integer.parseInt(bookLine[1]);
				int Year = Integer.parseInt(bookLine[5]);
				int Statistics = Integer.parseInt(bookLine[6]);

				SimpleDateFormat df = new SimpleDateFormat("yyMMdd");
				Date BorrowDate = df.parse(bookLine[7]);
				eachBook = new Book(bookLine[0], CopyNumber, bookLine[2],
						bookLine[3], bookLine[4], Year, Statistics, BorrowDate);
			} catch (NumberFormatException nex) {
				//System.err.println("Cannot convert from string to number");
				//nex.printStackTrace();
				return null;

			} catch (ParseException pex) {
				pex.printStackTrace();
			}

		}

		if (eachBook == null) {
			return null;
		}
		return eachBook;
	}
}
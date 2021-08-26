package library;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataController {
    private FileWriter fileWriter;
    private Scanner sc;

    public void openFileToWrite(String fileName) {
        try {
            fileWriter = new FileWriter(fileName, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openFileToRead(String fileName) {
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeFileAfterRead() {
        sc.close();
    }

    public void writeBookToFile (Book book, String fileName){
        openFileToWrite(fileName);
        try {
        fileWriter.write(book.getBookID() + "|" + book.getBookName() + "|"
                + book.getAuthor() + "|" + book.getPublishYear() + "|" + book.getSpecialization());

            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeFileAfterWrite();
    }

    public void writeReaderToFile (Reader reader, String fileName) throws IOException {
        openFileToWrite(fileName);

        fileWriter.write(reader.getReaderID() + "|" + reader.getFullName() + "|"
                + reader.getAddress() + "|" + reader.getPhoneNumber() + "|" + reader.getSpecialization());
        fileWriter.write("\n");
        closeFileAfterWrite();
    }

    public void writeBRMToFile (BookReaderManagerment brm, String fileName) throws IOException {
        openFileToWrite(fileName);

        fileWriter.write(brm.getReader().getReaderID() + "|" + brm.getBook().getBookID() + "|"
                + brm.getNumOfBorrow() + "|" + brm.getState());
        fileWriter.write("\n");
        closeFileAfterWrite();
    }

    public void closeFileAfterWrite() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Reader> readReadersFromFile(String fileName) {
        openFileToRead(fileName);
        ArrayList<Reader> readers = new ArrayList<>();
        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            Reader reader = createReaderFromData(data);
            readers.add(reader);
        }

        closeFileAfterRead();
        return readers;
    }

    public Reader createReaderFromData(String data) {
        String[] dat = data.split("\\|");
        //reader.getReaderID() + "|" + reader.getFullName() + "|"
        //                + reader.getAddress() + "|" + reader.getPhoneNumber() + "|" + reader.getSpecialization()

        //int readerID, String fullName, String address, String phoneNumber, String specialization
        Reader reader = new Reader(Integer.parseInt(dat[0]), dat[1], dat[2], dat[3], dat[4]);
        return  reader;
    }

    public ArrayList<Book> readBooksFromFile (String fileName) {
        openFileToRead(fileName);
        ArrayList<Book> books = new ArrayList<>();
        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            Book book = createBookFromData(data);
            books.add(book);
        }

        closeFileAfterRead();
        return books;
    }

    public Book createBookFromData(String data) {
        String[] dat = data.split("\\|");
        Book book = new Book(Integer.parseInt(dat[0]), Integer.parseInt(dat[3]), dat[1], dat[2], dat[4]);
        return book;
    }

    public ArrayList<BookReaderManagerment> readBRMsFromFile(String fileName) {
        openFileToRead(fileName);
        ArrayList<BookReaderManagerment> brms = new ArrayList<>();
        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            BookReaderManagerment brm = createBRMfromData(data);
            brms.add(brm);
        }

        closeFileAfterRead();
        return brms;
    }

    public BookReaderManagerment createBRMfromData(String data) {
        String[] dat = data.split("\\|");
        BookReaderManagerment brm = new BookReaderManagerment(new Book(Integer.parseInt(dat[1])),
                new Reader(Integer.parseInt(dat[0])), Integer.parseInt(dat[2]), dat[3], 0);


        return brm;
    }
}

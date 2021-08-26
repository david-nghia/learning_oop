package library;

public class Book {
    private static int id = 10000;
    private int bookID, publishYear;
    private String bookName, author, specialization;

    public Book() {
    }

    public Book(int bookID) {
        this.bookID = bookID;
    }

    public Book(int bookID, int publishYear, String bookName, String author, String specialization) {
        if (bookID == 0) {
            this.bookID = id++;
        }
        else {
            this.bookID = bookID;
        }
        this.publishYear = publishYear;
        this.bookName = bookName;
        this.author = author;
        this.specialization = specialization;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Book.id = id;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return
                "bookID=" + bookID +
                ", publishYear=" + publishYear +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", specialization='" + specialization + '\'' ;

    }
}
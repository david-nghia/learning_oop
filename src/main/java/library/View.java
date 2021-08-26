package library;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bookFileName = "Book.txt";
        String readerFileName = "Reader.txt";
        DataController controller = new DataController();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Reader> readers = new ArrayList<>();
        boolean isBookChecked = false;
        boolean isReaderChecked = false;

        int choice = 0;
        do {
            System.out.println("___________Menu___________");
            System.out.println("1. Them 1 dau sach vao file");
            System.out.println("2. Hien thi dach sach co trong file");
            System.out.println("3. Them ban doc vao file");
            System.out.println("4. Hien thi danh sach ban doc");
            System.out.println("0. Thoat");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Bye");
                    break;
                case 1:
                    if (!isBookChecked) {
                        checkBookID(controller, bookFileName);
                        isBookChecked = true;
                    }
                    //int bookID, int publishYear, String bookName, String author, String specialization
                    checkBookID(controller, bookFileName);
                    String bookName, author, specialization;
                    int year, sp;
                    String[] specs = {"Science", "Art", "Electronic", "IT"};
                    System.out.println("Nhap ten sach: ");
                    bookName = sc.nextLine();
                    System.out.println("Nhap tac gia: ");
                    author = sc.nextLine();
                    do {
                        System.out.println("Nhap the loai: ");
                        System.out.println("1. Science\n2. Art\n3. Electronic\n4. IT");
                        sp = sc.nextInt();
                    }
                    while (sp > 4 || sp < 1);

                    specialization = specs[sp - 1];

                    System.out.println("Nhap nam xb: ");
                    year = sc.nextInt();


                    Book b = new Book(0, year, bookName, author, specialization);
                    controller.writeBookToFile(b, bookFileName);
                    break;
                case 2:
                    System.out.println("___________Thong tin sach___________");
                    books = controller.readBooksFromFile(bookFileName);
                    showBookInfo(books);
                    break;
                case 3:


                    break;
                case 4:
                    break;
            }

        }
        while (choice != 0);
    }

    private static void checkBookID(DataController controller, String bookFileName) {
        ArrayList<Book> listBooks = controller.readBooksFromFile(bookFileName);
        Book.setId(listBooks.get(listBooks.size() - 1).getBookID() + 1);

    }

    private static void showBookInfo(ArrayList<Book> books) {
        for (var b : books) {
            System.out.println(b);
        }
    }
}

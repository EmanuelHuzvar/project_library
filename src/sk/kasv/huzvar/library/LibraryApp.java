package sk.kasv.huzvar.library;

import sk.kasv.huzvar.library.book.Book;
import sk.kasv.huzvar.library.book.Library;
import sk.kasv.huzvar.library.db.Database;
import sk.kasv.huzvar.library.member.Member;
import sk.kasv.huzvar.library.member.Reader;

import java.util.*;

public class LibraryApp {
    private Map<Book,Reader> map = new HashMap<>();
    private int input;
    private Scanner sc = new Scanner(System.in);
    private  Reader reader;
    private Library library;
    private Database db = new Database();
    private  ArrayList<Book> list = new ArrayList<>();
    private Library r = new Library();
    private Member mem ;
    public void run(){
        r.readBooksFromFile();
        reader = new Reader();
        reader.readMemberFromDb();
        library = new Library();
        library.readBooksFromFile();


        System.out.println("Welcome ! LibraryApp is running ... " + "\nNumber of books: "+library.getNumberOfBooks()+"\n"+ "number of readers: "+ reader.getNumberOfReader()+"\nSelect: ");
        while (true){
            System.out.println("0 - Show all books and readers");
            System.out.println("1 - borrow a new book");
            System.out.println("2 - return a new book");
            System.out.println("3 - show borrowed books");
            System.out.println("4 - show available books");
            System.out.println("5 - insert a new book");
            System.out.println("6 - insert a new reader");
            System.out.println("7 - find a book by title");
            System.out.println("8 - find a book by author");
            System.out.println("9 - exit");
            System.out.println("----------------------------------");
            System.out.println("Enter your choice");
            input = sc.nextInt();
            if (input==9) break;
            switch (input){
                case 0 : method0ShowBooksAndReaders(); break;
                case 1 : method1BorrowBook(); break;
                case 2 : method2ReturnBook(); break;
                case 3 : method3ShowBorrowedBooks(); break;
                case 4 : method4ShowAvailableBooks(); break;
                case 5 : method5InsertNewBook(); break;
                case 6 : method6InsertNewReader(); break;
                case 7 : method7FindBookByTitle(); break;
                case 8 : method8FindBookByAuthor(); break;



            }
        }

    }

    private void method8FindBookByAuthor() {
        System.out.println("tell me your Author: ");
        String author = sc.next();
        System.out.println(r.getBookByTitle(author).toString());
    }

    private void method7FindBookByTitle() {

        System.out.println("tell me your title: ");
        String title = sc.next();
        System.out.println(r.getBookByTitle(title));


    }

    private void method6InsertNewReader() {
        System.out.println("Whats the first name of the reader: ");
        String fname = sc.nextLine();
        System.out.println("Whats the last name of the reader: ");
        String lname = sc.nextLine();

        try {
            mem = new Member(fname,lname);
            db.addNewReader(mem);
        }
        catch (Exception e){
            System.out.println("cant add reader");
        }


    }

    private void method5InsertNewBook() {

        library.writeInFile(r.newBook());

    }

    private void method4ShowAvailableBooks() {

        r.getAllBooks();

    }

    private void method3ShowBorrowedBooks() {
        if (list.size() == 0){
            System.out.println("no book is borrowed");
        }
        for (int i = 0; i<list.size();i++){
            System.out.println(i+" "+list.get(i).toString());
        }

    }

    private void method2ReturnBook() {

        System.out.println("what book you want to return");
        int temp = sc.nextInt();
        try {
            r.addBook(list.get(temp));
            list.remove(temp);

        }
        catch (Exception e){
            System.out.println("this book by id isnt borrowed");
        }



    }

    private void method1BorrowBook() {
        System.out.println("Select number: ");
        int temp = sc.nextInt();
        list.add(r.getBookByID(temp));
        r.removeBook(temp);


    }

    private void method0ShowBooksAndReaders() {
        System.out.println("list of books: \n");
        System.out.println(library.toString());
        System.out.println("list of readers: \n");
        db.getAllMembers();
        System.out.println(db.toString());

    }
}

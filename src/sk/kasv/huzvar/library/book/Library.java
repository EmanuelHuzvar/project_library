package sk.kasv.huzvar.library.book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Library {
    private List<Book> books ;
    private static final String FILEBOOK = "Books.dat";

    public Library() {
        books = new ArrayList<>();
    }

    public void readBooksFromFile(){
        File file = new File(FILEBOOK);
        try {
           Scanner sc = new Scanner(file);
            String line;
            while (sc.hasNextLine()){
                line= sc.nextLine();
                String[] arr = line.split(" ") ;
                int id = Integer.parseInt(arr[0]) ;
                String title = arr[1];
                String author = arr[2];
                double price = Double.parseDouble(arr[3]);
                boolean sk = Boolean.parseBoolean(arr[4]);
                Book newBook = new Book(id,title,author,price,sk);
                books.add(newBook);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Book getBookByID(int id){

        for (Book b : books ){
            if (b.getId()==id){
                return b;
            }


        }


        return null;
    }

    public Set<Book> getBookByAuthor(String author){

        Set<Book> marek = new HashSet<>();

        for (Book b : books ){
            if (b.getAuthor().equalsIgnoreCase(author)){
                marek.add(b);
            }


        }


        return marek;
    }
    public Book getBookByTitle(String title){
        for (Book b : books ){
            if (b.getTitle().equalsIgnoreCase(title)){
                return b;
            }


        }


        return null;
    }

    public int getNumberOfBooks(){
        int i = 0;
        for (Book b : books){
            i++;
        }
        return i;
    }
    public int getNumberOfAuthor(){
        Set<String> autor = new HashSet<>();
        for (Book book:books){
            autor.add(book.getAuthor());
        }



        return autor.size();
      /*  int d = 0;
       for (int i = 0; i<books.size();i++){
           d++;
           for (int j = 0+i+1;j<books.size();j++){
               if (books.get(i).getAuthor().equalsIgnoreCase(books.get(j).getAuthor())){
                   d--;
               }
           }


       }*/




    }


    public int getMaxId(){

        return books.size()+1;
    }

    public Book newBook(){
        /* this.title = title;
        this.author = author;
        this.price = price;
        this.langSK = langSK;*/
        Scanner sc = new Scanner(System.in);
        System.out.println("GIve me title: ");
        String marek = sc.nextLine();
        System.out.println("Give me author");
        String marek2 = sc.nextLine();
        System.out.println("Give me price");
        double marek3 = Double.parseDouble(sc.next());
        System.out.println("Is it Writen in slovak laguage");
        boolean marek4 = sc.nextBoolean();

        Book book = new Book(getMaxId(),marek,marek2,marek3,marek4);

        return book;
    }

    public void writeInFile(Book book){
        try (FileWriter fw = new FileWriter(FILEBOOK,true)) {
            books.add(book);
            fw.write(System.lineSeparator());
            fw.write(book.getId()+" "+book.getTitle()+" "+book.getAuthor()+" "+book.getPrice()+" "+book.isLangSK());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        String out = "";
        for (Book b : books){
            out+= b.getId() + " "+b.getTitle()+b.getAuthor() + " "+b.getPrice()+"\n";
        }



        return out;
    }
    public void getAllBooks(){
        for (int i = 0; i<books.size();i++){
            System.out.println(i+1+" "+books.get(i).toString());
        }
    }
    public void removeBook(int temp){
        books.remove(temp);
    }
    public void addBook(Book book){
        books.add(book);
    }
}







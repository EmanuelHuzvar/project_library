package sk.kasv.huzvar.library.book;

public class Book {
    private String title;
    private String author;
    private int id;
    private double price;
    private boolean langSK;


    public Book(int id,String title ,String author , double price, boolean langSK) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.langSK = langSK;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public boolean isLangSK() {
        return langSK;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", langSK=" + langSK +
                '}';
    }
}


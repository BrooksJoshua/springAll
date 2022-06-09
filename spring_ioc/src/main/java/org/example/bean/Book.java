package org.example.bean;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-06 18:53
 */
public class Book {
    private String bname;
    private String author;

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {
        System.out.println("Books 无参构造");
    }

    public Book(String bname, String author) {
        System.out.println("Books AllArgsConstructor");
        this.bname = bname;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

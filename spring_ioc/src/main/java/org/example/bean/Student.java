package org.example.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Joshua.H.Brooks
 * @description 该类是用来演示DI注入集合的
 * @date 2022-06-06 18:49
 */
public class Student {
    private String[] books;
    private Set<String>  bookSet;
    private List<String> bookList;
    private Map<String,String> bookMap;
    private List<Book> bList;

    public String[] getBooks() {
        return books;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public Set<String> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<String> bookSet) {
        this.bookSet = bookSet;
    }

    public List<String> getBookList() {
        return bookList;
    }

    public void setBookList(List<String> bookList) {
        this.bookList = bookList;
    }

    public Map<String, String> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<String, String> bookMap) {
        this.bookMap = bookMap;
    }

    public List<Book> getbList() {
        return bList;
    }

    public void setbList(List<Book> bList) {
        this.bList = bList;
    }

    public Student() {
        System.out.println("student 无参构造");
    }

    public Student(String[] books, Set<String> bookSet, List<String> bookList, Map<String, String> bookMap) {
        System.out.println("Student AllArgsConstructor");
        this.books = books;
        this.bookSet = bookSet;
        this.bookList = bookList;
        this.bookMap = bookMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "books=" + Arrays.toString(books) +
                ", bookSet=" + bookSet +
                ", bookList=" + bookList +
                ", bookMap=" + bookMap +
                ", bList=" + bList +
                '}';
    }
}

package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {
    private Long id; // ID
    private String bookName; // Название книги
    private String publisher; // Издательство
    private String sName; // ФИО студента
    private LocalDate issueDate; // Дата выдачи книги студенту
    private LocalDate returnDate; // Дата сдачи книги студентом в библиотеку

    protected Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {return bookName;}
    public void setBookName(String bookName) {this.bookName = bookName;}
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getsName() {return sName;}
    public void setsName(String sName) {this.sName = sName;}

    public LocalDate getIssueDate() {return issueDate;}
    public void setIssueDate(LocalDate issueDate) {this.issueDate = issueDate;}

    public LocalDate getReturnDate() {return returnDate;}
    public void setReturnDate(LocalDate returnDate) {this.returnDate = returnDate;}



    @Override
    public String toString() {
        return "book [id=" + id + ", bookName=" + bookName + ", publisher=" + publisher + ", sName=" + sName + ", issueDate=" + issueDate + ", returnDate=" + returnDate + "]";
    }
}

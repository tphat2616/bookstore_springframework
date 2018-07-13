/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khuongnd.lab3.model;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author cattuan
 */
public class BorrowBook {
    private Integer id;
    private Integer idBook;
    private String userName;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date borrowDate;
    private Book currBook;

    public Book getCurrBook() {
        return currBook;
    }

    public void setCurrBook(Book currBook) {
        this.currBook = currBook;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    
}

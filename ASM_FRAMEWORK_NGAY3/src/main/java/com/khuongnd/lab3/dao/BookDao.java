/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khuongnd.lab3.dao;

import com.khuongnd.lab3.model.Book;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author KhuongND
 */
public class BookDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Book> findAll() {
        String sql = "select * from book";
        List<Book> list = jdbcTemplate.query(sql, new BookMapper());
        return list;
    }

    public Book find1Book(int id) {
        String sql = "select * from book where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BookMapper());
    }

    public boolean addBook(Book b) {
        boolean flag = false;
        try {
            String sql = "insert into book (name,author,releaseDate) values (?,?,?)";
            jdbcTemplate.update(sql, b.getName(), b.getAuthor(), b.getRelease_date());
            flag = true;
        } catch (Exception ex) {
        }
        return flag;
    }

    public void updateBook(Book b) {
        String sql = "update book set name=?, author=?, releaseDate=? where id=?";
        jdbcTemplate.update(sql, b.getName(), b.getAuthor(), b.getRelease_date(), b.getId());
    }
}

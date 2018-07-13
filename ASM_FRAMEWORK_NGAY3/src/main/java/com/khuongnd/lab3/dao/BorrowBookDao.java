/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khuongnd.lab3.dao;

import com.khuongnd.lab3.model.Book;
import com.khuongnd.lab3.model.BorrowBook;
import java.util.List;
import static jdk.nashorn.internal.runtime.Context.printStackTrace;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author cattuan
 */
public class BorrowBookDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<BorrowBook> findAll() {
        String sql = "select * from borrowbook";
        List<BorrowBook> list = jdbcTemplate.query(sql, new BorrowBookMapper());
        return list;
    }

    public BorrowBook find1Book(int id) {
        String sql = "select * from borrowbook where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BorrowBookMapper());
    }
    public List<BorrowBook>  findIdBook(int id) {
        String sql = "select * from borrowbook where idbook=?";
        List<BorrowBook> list = jdbcTemplate.query(sql, new Object[]{id}, new BorrowBookMapper());
        return list;
    }

    public boolean addBorrowBook(BorrowBook b) {
        boolean flag = false;
        try {
            String sql = "insert into borrowbook (username,idbook,borrowdate) values (?,?,?)";
            jdbcTemplate.update(sql, b.getUserName(), b.getIdBook(), b.getBorrowDate());
            flag = true;
        } catch (Exception ex) {
            printStackTrace(ex);
            System.out.println(ex.toString());
        }
        return flag;
    }

    
}

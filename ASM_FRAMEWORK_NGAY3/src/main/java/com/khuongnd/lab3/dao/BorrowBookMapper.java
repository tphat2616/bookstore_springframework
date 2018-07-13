/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khuongnd.lab3.dao;

import com.khuongnd.lab3.model.Book;
import com.khuongnd.lab3.model.BorrowBook;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author cattuan
 */
public class BorrowBookMapper implements RowMapper<BorrowBook>{
    @Override
    public BorrowBook mapRow(ResultSet rs, int i) throws SQLException {
        BorrowBook e = new BorrowBook();
        e.setId(rs.getInt("id"));
        e.setUserName(rs.getString("username"));
        e.setIdBook(rs.getInt("idbook"));
        e.setBorrowDate(rs.getDate("borrowdate"));
        return e;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khuongnd.lab3.dao;

import com.khuongnd.lab3.model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author KhuongND
 */
public class BookMapper implements RowMapper<Book>{

    @Override
    public Book mapRow(ResultSet rs, int i) throws SQLException {
        Book e = new Book();
        e.setId(rs.getInt("id"));
        e.setName(rs.getString("name"));
        e.setAuthor(rs.getString("author"));
        e.setRelease_date(rs.getDate("releaseDate"));
        return e;
    }
    
}

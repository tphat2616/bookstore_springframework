/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khuongnd.lab3.controller;

import com.khuongnd.lab3.dao.BookDao;
import com.khuongnd.lab3.dao.BorrowBookDao;
import com.khuongnd.lab3.model.Book;
import com.khuongnd.lab3.model.BorrowBook;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author KhuongND
 */
@Controller
public class HomeController {

    private static final Logger LOGGER = Logger.getLogger(HomeController.class.getName());
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BorrowBookDao borrowBookDao;  

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView viewHome() {
        List<Book> list = bookDao.findAll();
        ModelAndView m = new ModelAndView("home");
        m.addObject("listBooks", list);
        return m;
    }

    @RequestMapping(value = "add-book", method = RequestMethod.GET)
    public ModelAndView viewAddHome() {
        ModelAndView m = new ModelAndView("addBook");
        m.addObject("book", new Book());
        return m;
    }

    @RequestMapping(value = "edit-book", method = RequestMethod.GET)
    public ModelAndView editBook(@RequestParam("id") int id) {
        ModelAndView m = new ModelAndView("addBook");
        m.addObject("book", bookDao.find1Book(id));
        return m;
    }

    @RequestMapping(value = "create-book", method = RequestMethod.POST)
    public String addNewBook(@ModelAttribute("book") Book b, BindingResult result, Model model) {
        bookDao.addBook(b);
        return "redirect:/home";
    }

    @RequestMapping(value = "update-book", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book") Book b, BindingResult result, Model model) {
        bookDao.updateBook(b);
        return "redirect:/home";
    }
    
    @RequestMapping(value = "borrow-book", method = RequestMethod.GET)
    public ModelAndView borrowBook(@RequestParam("idBook") int idBook) {
        ModelAndView m = new ModelAndView("borrow-book");
        BorrowBook book = new BorrowBook();
        book.setIdBook(idBook);
        m.addObject("book", book);
        return m;
    }
    
    @RequestMapping(value = "list-book-history", method = RequestMethod.GET)
    public ModelAndView getHistorywBook(@RequestParam("idBook") int idBook) {
        ModelAndView m = new ModelAndView("book-history");
        List<BorrowBook> listHistory = borrowBookDao.findIdBook(idBook);
        Book curBook = new Book();
        curBook = bookDao.find1Book(idBook);
        for (BorrowBook borrow: listHistory) {
            borrow.setCurrBook(curBook);
            
        }
        m.addObject("listHistory", listHistory);
        return m;
    }
    
    @RequestMapping(value = "save-borrow-book", method = RequestMethod.POST)
    public String borrowBook(@ModelAttribute("book") BorrowBook b, BindingResult result, Model model) {
        borrowBookDao.addBorrowBook(b);
        return "redirect:/home";
    }

}

package com.ztj.springbootdemo.controller;

import com.ztj.springbootdemo.entity.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * restful api document and test at: http://localhost:8080/swagger-ui.html
 */
@RestController
@RequestMapping(value="/books")
@Api(value = "Book API interface", tags = "book")
public class BookSwaggerController {

    // multi-thread safe
    private static Map<Long, Book> bookMap = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value="Get books list")
    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<Book> getBookList() {
        return new ArrayList<>(bookMap.values());
    }

    @ApiOperation(value="Create a book", notes="Create a book based on a Book object")
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postBook(@ModelAttribute Book book) {
        bookMap.put(book.getId(), book);
        return "success";
    }

    @ApiOperation(value="Get a book", notes="Get a book based on book id in the url")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return bookMap.get(id);
    }

    @ApiOperation(value="Update a book", notes="Update a book based on book id in the url, with Book object")
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putBook(@PathVariable Long id, @ModelAttribute Book book) {
        Book b = bookMap.get(id);
        b.setName(book.getName());
        bookMap.put(id, b);
        return "success";
    }

    @ApiOperation(value="Delete a book", notes="Delete a book based on book id in the url")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id) {
        bookMap.remove(id);
        return "success";
    }

}

package com.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    private List<Book> bookList;
    private int id;


    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookController(){
        this.bookList = new ArrayList<Book>();
        this.id = 1;
    }

    // post request /create-book
    // pass book as request body
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        // Your code goes here.
        if(book != null){
            bookList.add(book);
        }
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // get request /get-book-by-id/{id}
    // pass id as path variable
    // getBookById()
    @GetMapping("/get-book-by-id/{id}")
    public Book getBookById(@PathVariable("id")int id){
            for(Book book :bookList){
                if(book.getId()==id){
                    return book;
                }
            }
            return null;
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public void deleteBookById(@PathVariable("id")int id){
        for(Book book :bookList){
            if(book.getId()==id){
                bookList.remove(book);
            }
        }
    }

    // delete request /delete-book-by-id/{id}
    // pass id as path variable
    // deleteBookById()

    // get request /get-all-books
    // getAllBooks()
    @GetMapping("/get-all-books")
    public List<Book> getAllBook(){
        return this.bookList;
    }

    // delete request /delete-all-books
    // deleteAllBooks()

    @DeleteMapping("/delete-all-books")
    public void deleteAllBooks(){
        bookList.clear();
    }

    // get request /get-books-by-author
    // pass author name as request param
    // getBooksByAuthor()
    @GetMapping("/get-books-by-author")
    public Book getBooksByAuthor(@RequestParam String authorName){
        for(Book book : bookList){
            if(book.getAuthor().equals(authorName)){
                return book;
            }
        }
        return null;
    }

    // get request /get-books-by-genre
    // pass genre name as request param
    // getBooksByGenre()
@GetMapping("/get-books-by-genre")
    public Book getBooksByGenre(@RequestParam String generName){
        for(Book book : bookList){
            if(book.getAuthor().equals(generName)){
                return book;
            }
        }
        return null;
    }

}

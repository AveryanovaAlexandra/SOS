package com.example.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.backend.entity.Book;
import com.example.backend.repository.BookRepository;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BookController {
	
	private Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookRepository bookRepository;

	@RequestMapping(path="/books", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Fetch all books")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Book.class),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Server Error")})
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}
	
	@GetMapping("/books/{id}")
	@ApiOperation(value = "Fetch a book")
	public ResponseEntity<Object> getBookById(@PathVariable("id") Long id) {
		try {
			Book book = bookRepository.findById(id).get();
			if(book != null) {
				return new ResponseEntity<Object>(book, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/books")
	public ResponseEntity<Object> createBook(@RequestBody Book book) {
		try {
			Book savedBook = bookRepository.save(book);
			return new ResponseEntity<Object>(savedBook, HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/books/{id}")
	@ApiOperation(value = "Update a book")
	public ResponseEntity<Object> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {

			book.setId(id);
			Book savedBook = bookRepository.save(book);
			return new ResponseEntity<Object>(savedBook, HttpStatus.OK);

	}
	@DeleteMapping("/Books/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") Long id) {
		try {
			bookRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch(Exception ex) {
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
	
}

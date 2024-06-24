package jagarcia.rest_api_library.controller;

import jagarcia.rest_api_library.dto.BookDto;
import jagarcia.rest_api_library.service.IBookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/books")
public class BookController {

    private IBookService iBookService;

    //build create book REST API
    @PostMapping
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto) {
        BookDto savedBook = iBookService.createBook(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    //build get book by id
    @GetMapping("{id}")
    public ResponseEntity<BookDto> getUserById(@PathVariable("id") Long bookId) {
        BookDto bookDto = iBookService.getBookById(bookId);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    //build get all books
    //http://localhost:8080/api/books
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> booksDto = iBookService.getAllBooks();
        return new ResponseEntity<>(booksDto, HttpStatus.OK);
    }

    //build update book
    @PutMapping("{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") Long bookId,
                                              @RequestBody @Valid BookDto bookDto) {
        bookDto.setId(bookId);
        BookDto updatedBook = iBookService.updateBook(bookDto);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    //build Delete BOOK
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId) {
        iBookService.deleteBook(bookId);
        return new ResponseEntity<>("Book succesfully deleted!", HttpStatus.OK);
    }

}

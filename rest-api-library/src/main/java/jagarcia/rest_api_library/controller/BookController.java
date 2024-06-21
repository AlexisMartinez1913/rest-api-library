package jagarcia.rest_api_library.controller;

import jagarcia.rest_api_library.dto.BookDto;
import jagarcia.rest_api_library.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/books")
public class BookController {

    private IBookService iBookService;

    //build create book REST API
    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        BookDto savedBook = iBookService.createBook(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    //build get book by id
    @GetMapping("{id}")
    public ResponseEntity<BookDto> getUserById(@PathVariable("id") Long bookId) {
        BookDto bookDto = iBookService.getBookById(bookId);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

}

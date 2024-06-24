package jagarcia.rest_api_library.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jagarcia.rest_api_library.dto.BookDto;
import jagarcia.rest_api_library.service.IBookService;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//DOCUMENTAR CONTROLLER
@Tag(
        name = "CRUD API REST for Library Resource",
        description = "CRUD REST APIs - Create Book, Update Book, Get All Books, Delete Book"
)

@RestController
@AllArgsConstructor
@RequestMapping("api/books")
public class BookController {

    private IBookService iBookService;

    //documentar Endpoints
    @Operation(
            summary = "Create Book REST API",
            description = "Create Book REST API is used to save book in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )

    //build create book REST API
    @PostMapping
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto) {
        BookDto savedBook = iBookService.createBook(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Gey Book By Id REST API",
            description = "Get Book by Id REST API is used to get a single book from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )

    //build get book by id
    @GetMapping("{id}")
    public ResponseEntity<BookDto> getUserById(@PathVariable("id") Long bookId) {
        BookDto bookDto = iBookService.getBookById(bookId);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Books REST API",
            description = "Get All Books REST API is used to get all books from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )

    //build get all books
    //http://localhost:8080/api/books
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> booksDto = iBookService.getAllBooks();
        return new ResponseEntity<>(booksDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Book REST API",
            description = "Update Book REST API is used to update a particular book from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 SUCCESS"
    )

    //build update book
    @PutMapping("{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") Long bookId,
                                              @RequestBody @Valid BookDto bookDto) {
        bookDto.setId(bookId);
        BookDto updatedBook = iBookService.updateBook(bookDto);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Book REST API",
            description = "Delete Book REST API is used to DELETE a particular book from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )

    //build Delete BOOK
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long bookId) {
        iBookService.deleteBook(bookId);
        return new ResponseEntity<>("Book succesfully deleted!", HttpStatus.OK);
    }

}

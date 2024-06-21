package jagarcia.rest_api_library.service;

import jagarcia.rest_api_library.dto.BookDto;

import java.util.List;

public interface IBookService {
    BookDto createBook(BookDto bookDto);
    BookDto getBookById(Long bookId);
    List<BookDto> getAllBooks();
    BookDto updateBook(BookDto bookDto);
    void deleteBook(Long bookId);

}

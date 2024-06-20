package jagarcia.rest_api_library.service;

import jagarcia.rest_api_library.dto.BookDto;

public interface IBookService {
    BookDto createBook(BookDto bookDto);

}

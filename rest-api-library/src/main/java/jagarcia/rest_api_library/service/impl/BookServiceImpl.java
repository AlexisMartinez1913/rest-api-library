package jagarcia.rest_api_library.service.impl;

import jagarcia.rest_api_library.dto.BookDto;
import jagarcia.rest_api_library.entity.Book;
import jagarcia.rest_api_library.repository.IBookRepository;
import jagarcia.rest_api_library.service.IBookService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements IBookService {

    private IBookRepository iBookRepository;

    //use modelmapper
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookDto createBook(BookDto bookDto) {

        Book book = modelMapper.map(bookDto, Book.class);
        //save the book entity
        Book savedBook = iBookRepository.save(book);

        //convert Book JPA entity to BookDto using modelMaper
        BookDto savedBookDto = modelMapper.map(savedBook, BookDto.class);
        return savedBookDto;
    }

    @Override
    public BookDto getBookById(Long bookId) {
        Optional<Book> optionalBook = iBookRepository.findById(bookId);
        Book book = optionalBook.get();

        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = iBookRepository.findAll();

        return books.stream().map((book) -> modelMapper.map(book, BookDto.class)).collect(Collectors.toList());
    }
}

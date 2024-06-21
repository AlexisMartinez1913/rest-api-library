package jagarcia.rest_api_library.service.impl;

import jagarcia.rest_api_library.dto.BookDto;
import jagarcia.rest_api_library.entity.Book;
import jagarcia.rest_api_library.exception.ResourceNotFoundException;
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
        //Optional<Book> optionalBook = iBookRepository.findById(bookId);
        //Book book = optionalBook.get();
        //EXCEPCION
        Book book = iBookRepository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book", "id", bookId)
        );

        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = iBookRepository.findAll();

        return books.stream().map((book) -> modelMapper.map(book, BookDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        //excepcion personalizada
        Book existingBook = iBookRepository.findById(bookDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Book", "Id", bookDto.getId())
        );
        existingBook.setTitle(bookDto.getTitle());
        existingBook.setAuthor(bookDto.getAuthor());
        existingBook.setCategory(bookDto.getCategory());
        existingBook.setIsbn(bookDto.getIsbn());
        existingBook.setNumberPages(bookDto.getNumberPages());
        existingBook.setCopiesAvailable(bookDto.getCopiesAvailable());

        Book updateBook = iBookRepository.save(existingBook);

        return modelMapper.map(updateBook, BookDto.class);
    }

    @Override
    public void deleteBook(Long bookId) {
        Book existingBook = iBookRepository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book", "Id", bookId)
        );

        iBookRepository.deleteById(bookId);
    }
}

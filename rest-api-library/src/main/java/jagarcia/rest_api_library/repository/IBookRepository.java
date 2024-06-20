package jagarcia.rest_api_library.repository;

import jagarcia.rest_api_library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {

}

package jagarcia.rest_api_library.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    @NotEmpty(message = "Book title should not be null or empty")
    private String title;
    @NotEmpty(message = "Book author should not be null or empty")
    private String author;
    @NotEmpty(message = "Book category should not be null or empty")
    private String category;
    @NotEmpty(message = "Book ISBN should not be null or empty")
    private String isbn;
    private Integer numberPages;
    private Integer copiesAvailable;

}

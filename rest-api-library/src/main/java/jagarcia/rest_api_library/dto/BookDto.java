package jagarcia.rest_api_library.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//documentar la API
@Schema(
        description = "BookDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    @Schema(
            description = "Book title"
    )
    @NotEmpty(message = "Book title should not be null or empty")
    private String title;
    @NotEmpty(message = "Book author should not be null or empty")
    @Schema(
            description = "Book Author"
    )
    private String author;
    @Schema(
            description = "Book Category"
    )
    @NotEmpty(message = "Book category should not be null or empty")
    private String category;
    @Schema(
            description = "Book ISBN"
    )
    @NotEmpty(message = "Book ISBN should not be null or empty")
    private String isbn;
    private Integer numberPages;
    private Integer copiesAvailable;

}

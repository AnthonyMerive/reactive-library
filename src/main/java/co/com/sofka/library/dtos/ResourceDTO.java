package co.com.sofka.library.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {

    private String id;

    private String name;

    private LocalDate returnDate;

    private String type;

    private String thematic;

    private boolean isAvailable;
}

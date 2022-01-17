package co.com.sofka.library.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "reactiveResources")
public class Resource {
    @Id
    private String id;

    private String name;

    private LocalDate returnDate;

    private String type;

    private String thematic;

    private boolean isAvailable;

}

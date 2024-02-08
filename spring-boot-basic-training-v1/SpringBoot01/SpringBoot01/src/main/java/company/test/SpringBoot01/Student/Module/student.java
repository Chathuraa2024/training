package company.test.SpringBoot01.Student.Module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(value = "student")
@AllArgsConstructor
public class student {
    @Id
    private Integer id;
    private String name;
    private String dateOfBirth;
    private Double average;
}

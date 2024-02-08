package company.test.SpringBoot01.Student.Module;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(value = "student")
public class student {
    @Id
    private Integer id;
    private String name;
    private String dateOfBirth;
    private Double average;

    public student(int id,String name,String dateOfBirth,double average) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.average = average;
    }
}

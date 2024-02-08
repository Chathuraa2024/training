package company.test.SpringBoot01.Student.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentRequestDto {
    private Integer id;
    private String name;
    private String dateOfBirth;
    private Double average;
}

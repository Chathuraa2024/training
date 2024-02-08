package company.test.SpringBoot01.Student.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentResponseDto {
    private String name;
    private String dateOfBirth;
    private Double average;


}

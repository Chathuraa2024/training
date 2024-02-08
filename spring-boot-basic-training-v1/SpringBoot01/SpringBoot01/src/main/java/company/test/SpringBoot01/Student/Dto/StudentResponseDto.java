package company.test.SpringBoot01.Student.Dto;

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

package company.test.SpringBoot01.Student.Controler;

import company.test.SpringBoot01.Student.Dto.StudentRequestDto;
import company.test.SpringBoot01.Student.Dto.StudentResponseDto;
import company.test.SpringBoot01.Student.Service.StudentService;
import company.test.SpringBoot01.Student.util.StandedResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentControler {
    @Autowired
    private StudentService studentService;


    @GetMapping("test")
    public ResponseEntity<StandedResponce> test(){
        String massege = "hellow springboot";
        return new ResponseEntity<StandedResponce>(new StandedResponce(200,"test case pass",massege),HttpStatus.OK);
    }

    @GetMapping("HTTP GET/student-management/students")
    public ResponseEntity<StandedResponce> getAllStudent(){
        List<StudentResponseDto> studentResponseDtos = studentService.getallStudent();
        return new ResponseEntity<StandedResponce>(new StandedResponce(201,"Success",studentResponseDtos),HttpStatus.OK);
    }

    @GetMapping("HTTP GET/student-management/students/{id}")
    public ResponseEntity<StandedResponce> getStudentById(@PathVariable int id){
        System.out.println(id);
        return studentService.getStudentFindById(id);
    }

    @PostMapping("HTTP POST/student-management/students")
    public String addNewStudent(@RequestBody StudentRequestDto student){
        return studentService.addStudent(student);

    }

    @DeleteMapping("HTTP DELETE/student-management/students/{id}")
    public String deleteStudentId(@PathVariable int id){
        String str = studentService.deleteStudentById(id);
        return str;
    }
}
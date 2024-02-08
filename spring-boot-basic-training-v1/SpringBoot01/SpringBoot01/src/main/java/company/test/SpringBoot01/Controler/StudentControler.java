package company.test.SpringBoot01.Controler;

import company.test.SpringBoot01.Module.student;
import company.test.SpringBoot01.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")
public class StudentControler {
    @Autowired
    private StudentService studentService;

    @GetMapping("test")
    public String test(){
        return "hellow spring ";
    }
    @GetMapping("getall")
    public List<student> getAllStudent(){
        return studentService.getallStudent();
    }

    @GetMapping(path = "getbyId",params = "id")
    public Optional<student> getStudentById(@RequestParam(value = "id") int StudentId){
        System.out.println(StudentId);
        return studentService.getStudentFindById(StudentId);
    }

    @PostMapping("addStudent")
    public student addNewStudent(@RequestBody student student){
        student student1 = studentService.addStudent(student);
        return student1;
    }

    @DeleteMapping("delete-by-id/{id}")
    public String deleteStudentId(@PathVariable int id){
        String str = studentService.deleteStudentById(id);
        return str;
    }
}

package company.test.SpringBoot01.Student.Service;

import company.test.SpringBoot01.Student.Dto.Request.StudentRequestDto;
import company.test.SpringBoot01.Student.Dto.Response.StudentResponseDto;
import company.test.SpringBoot01.Student.Module.student;
import company.test.SpringBoot01.Student.Repo.StudentRepo;
import company.test.SpringBoot01.Student.util.StandedResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentrepo;

    public List<StudentResponseDto> getAllStudent() {
        List<student> students = studentrepo.findAll();
        if (students.size() > 0) {
            List<StudentResponseDto> studentList = new ArrayList<>();
            for (student student : students) {
                StudentResponseDto studentDto = new StudentResponseDto(student.getName(),
                        student.getDateOfBirth(),
                        student.getAverage());
                studentList.add(studentDto);
            }
            return studentList;
        } else {
            throw new RuntimeException("empty database ");
        }
    }

//    public StudentResponseDto getStudentFindById(int studentId) {
//        if (studentrepo.existsById(studentId)) {
//            Optional<student> student = studentrepo.findById(studentId);
//            StudentResponseDto studentResponseDto = new StudentResponseDto(student.get().getName(), student.get().getDateOfBirth(), student.get().getAverage());
//            return studentResponseDto;
//        } else {
//            throw new RuntimeException("Id not in the data base ");
//        }
//    }
    public ResponseEntity<StandedResponce> getStudentFindById(int studentId) {
        try{
            Optional<student> student = studentrepo.findById(studentId);
            StudentResponseDto studentResponseDto = new StudentResponseDto(student.get().getName(), student.get().getDateOfBirth(), student.get().getAverage());
            return new ResponseEntity<StandedResponce>(new StandedResponce(201,"success",studentResponseDto), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<StandedResponce>(new StandedResponce(401,"notfound",e.getMessage()),HttpStatus.NOT_FOUND);
        }
    }

    public String addStudent(StudentRequestDto student) {
        student student1 = new student(student.getId(), student.getName(), student.getDateOfBirth(), student.getAverage());
        studentrepo.save(student1);
        if (studentrepo.existsById(student1.getId())) {
            return "add new student";
        }else {
            throw new RuntimeException("did not save");
        }
    }

    public String deleteStudentById(int id) {
        if (studentrepo.existsById(id)) {
            studentrepo.deleteById(id);
            return "delete id";
        } else {
            throw new RuntimeException("id is not in database");
        }
    }

}
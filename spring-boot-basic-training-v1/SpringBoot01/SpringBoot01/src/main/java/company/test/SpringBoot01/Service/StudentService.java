package company.test.SpringBoot01.Service;

import company.test.SpringBoot01.Module.student;
import company.test.SpringBoot01.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentrepo;

    public List<student> getallStudent() {
        return studentrepo.findAll();
    }

    public Optional<student> getStudentFindById(int studentId) {
        if(studentrepo.existsById(studentId)) {
            return studentrepo.findById(studentId);

        }else{
            throw new RuntimeException("Id not in the data base ");
        }
    }

    public student addStudent(student student) {
        student student1 = new student(student.getId(),student.getName(),student.getDateOfBirth(),student.getAverage());
        studentrepo.save(student1);
        return student1;
    }

    public String deleteStudentById(int id) {
        if(studentrepo.existsById(id)){
            studentrepo.deleteById(id);
            return "delete id";
        }else{
            throw new RuntimeException("id is not in database");
        }
    }
}

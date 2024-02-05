import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private List<String> subject;

//    public int getID() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public int getage() {
//        return age;
//    }
//    public void setage(int age) {
//        this.age = age;
//    }
//    public List<String> getsubject() {
//        return subject;
//    }
//    public void setId(List<String> subject) {
//        this.subject = subject;
//    }
//
//    public Student(int id,String name,int age, List<String> subject){
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.subject = subject;
//    }


}

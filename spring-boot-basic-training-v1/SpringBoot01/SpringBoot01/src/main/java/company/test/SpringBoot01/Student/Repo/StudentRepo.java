package company.test.SpringBoot01.Student.Repo;

import company.test.SpringBoot01.Student.Module.student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface StudentRepo extends MongoRepository<student,Integer> {

}

package company.test.SpringBoot01.Repo;

import company.test.SpringBoot01.Module.student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface StudentRepo extends MongoRepository<student,Integer> {

}

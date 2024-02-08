package company.test.SpringBoot01.Student.Addvice;

import company.test.SpringBoot01.Student.util.StandedResponce;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling extends Throwable {
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<StandedResponce> HaddleNotFoundExeption(ChangeSetPersister.NotFoundException e){
        return new ResponseEntity<StandedResponce>(new StandedResponce(404,"Error massage",e.getMessage()), HttpStatus.NOT_FOUND);
    }
}

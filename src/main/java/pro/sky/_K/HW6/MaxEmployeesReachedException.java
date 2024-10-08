package pro.sky._K.HW6;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MaxEmployeesReachedException extends RuntimeException {
    public MaxEmployeesReachedException(String message) {
        super(message);
    }
}

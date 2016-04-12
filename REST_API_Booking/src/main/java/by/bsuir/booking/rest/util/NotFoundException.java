package by.bsuir.booking.rest.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by User on 21.03.2016.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such node")  // 404
public class NotFoundException extends RuntimeException {
    public NotFoundException(int Id) {
        super(Id + " not found");
    }
}


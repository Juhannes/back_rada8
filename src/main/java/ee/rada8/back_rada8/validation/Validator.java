package ee.rada8.back_rada8.validation;

import ee.rada8.back_rada8.domain.User;
import ee.rada8.back_rada8.infrastructure.exception.DataNotFoundException;

import java.util.Optional;

import static ee.rada8.back_rada8.validation.ErrorMessage.INCORRECT_CREDENTIALS;

public class Validator {
    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new DataNotFoundException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getCode());
        }
        return optionalUser.get();
    }
}

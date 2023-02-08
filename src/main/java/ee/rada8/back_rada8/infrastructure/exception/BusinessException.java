package ee.rada8.back_rada8.infrastructure.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private final String message;
    private final String errorCode;

    public BusinessException(String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}

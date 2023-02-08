package ee.rada8.back_rada8.validation;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    INCORRECT_CREDENTIALS("Vale kasutajanimi/parool", "404");

    private String message;
    private String code;

    ErrorMessage(String message, String code) {

        this.message = message;
        this.code = code;
    }
}

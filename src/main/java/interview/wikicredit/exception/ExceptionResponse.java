package interview.wikicredit.exception;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * Exception representation as JSON object
 */
@Value
@Builder
public class ExceptionResponse {
    Integer status;
    String message;
    LocalDateTime dateTime;
}

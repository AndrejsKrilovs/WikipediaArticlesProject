package interview.wikicredit.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Exception representation as JSON object
 */
@Data
@AllArgsConstructor
public class CompanyExceptionResponse {
    private Integer status;
    private String message;
    private LocalDateTime dateTime;
}

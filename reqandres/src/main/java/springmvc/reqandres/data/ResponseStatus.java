package springmvc.reqandres.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponseStatus {
    private int code;
    private String message;
}

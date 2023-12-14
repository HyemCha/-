package springmvc.reqandres.data;

import lombok.Data;

@Data
public class ResultData<T> {

    private T data;

}

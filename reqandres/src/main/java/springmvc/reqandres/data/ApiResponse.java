package springmvc.reqandres.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ApiResponse<T>{

    private ResponseStatus requestStatus = new ResponseStatus();
    private MetaData metaData = new MetaData();
    private ResultData<T> resultData = new ResultData<>();
    private DetailedData detailedData = new DetailedData();

    public ApiResponse(int code, String message, T data, int count) {
        this.requestStatus.setCode(code);
        this.requestStatus.setMessage(message);
        this.metaData.setResultCount(count);
        this.resultData.setData(data);
    }

    public ApiResponse(int code, String message, int maxGrade) {
        this.requestStatus.setCode(code);
        this.requestStatus.setMessage(message);
        this.detailedData.setMaxGrade(maxGrade);
    }

    public void save(T input, int code, String message) {
        this.getRequestStatus().setCode(code);
        this.getRequestStatus().setMessage(message);
        this.getMetaData().setResultCount(1);
        this.getResultData().setData(input);
    }
}

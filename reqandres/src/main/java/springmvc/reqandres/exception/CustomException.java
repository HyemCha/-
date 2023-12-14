package springmvc.reqandres.exception;

public class CustomException extends RuntimeException{

    private int grade;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }
    public CustomException(String message, int grade) {
        super(message);
        this.setGrade(grade);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    protected CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package top.zw.communtity.exception;

public class CustomizeException extends RuntimeException{
    private String message;

    public CustomizeException(String message){
        this.message = message;
    }

    public CustomizeException(CustomizeErrorCode customizeErrorCode){
        this.message = customizeErrorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}

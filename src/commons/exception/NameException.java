package commons.exception;

public class NameException extends Exception{
    public NameException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

package tvAddicts.exceptions;

public class DuplicateShowException extends TVAddictException {
    public DuplicateShowException() {
    }

    @Override
    public String getMessage(){
        return "Show already exists!";
    }
}

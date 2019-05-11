package tvAddicts.exceptions;

public class NoCurrentShowException extends TVAddictException {
    public NoCurrentShowException() {
    }

    @Override
    public String getMessage(){
        return "No show is selected!";
    }
}

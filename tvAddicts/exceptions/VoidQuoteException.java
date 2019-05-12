package tvAddicts.exceptions;

public class VoidQuoteException extends TVAddictException {
    @Override
    public String getMessage() {
        return "First time I hear that!";
    }
}

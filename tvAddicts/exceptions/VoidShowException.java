package tvAddicts.exceptions;

public class VoidShowException extends TVAddictException {
    @Override
    public String getMessage() {
        return "Unknown show!";
    }
}

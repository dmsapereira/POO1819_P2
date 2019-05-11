package tvAddicts.exceptions;

public class VoidSeasonException extends TVAddictException {
    @Override
    public String getMessage() {
        return "Unknown season!";
    }
}

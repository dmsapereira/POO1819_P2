package tvAddicts.exceptions;

public class InvalidCharacterType extends TVAddictException {
    @Override
    public String getMessage() {
        return "Unknown actor category!";
    }
}

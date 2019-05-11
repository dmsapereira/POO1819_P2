package tvAddicts.exceptions;

public class DuplicateCharacterName extends TVAddictException {
    @Override
    public String getMessage() {
        return "Duplicate character names are not allowed!";
    }
}

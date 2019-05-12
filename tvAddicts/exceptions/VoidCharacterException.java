package tvAddicts.exceptions;

public class VoidCharacterException extends TVAddictException {

    private String character;

    public VoidCharacterException(String character) {
        this.character = character;
    }

    @Override
    public String getMessage() {
        return "Who is " + character + "?";
    }
}

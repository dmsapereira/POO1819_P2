package tvAddicts.exceptions;

public class InvalidRelationshipException extends TVAddictException {
    private String character;
    public InvalidRelationshipException(String character) {
        this.character = character;
    }

    @Override
    public String getMessage() {
        return character + " cannot be parent and child at the same time!";
    }
}

package tvAddicts.exceptions;

public class DuplicateCharacterException extends TVAddictException {
    public DuplicateCharacterException(){}

    @Override
    public String getMessage(){
        return "Duplicate character names are not allowed!";
    }
}

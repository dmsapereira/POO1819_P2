package exceptions;

public class DuplicateCharacterException extends Exception {
    public DuplicateCharacterException(){}

    public String getMessage(){
        return "Duplicate character names are not allowed!";
    }
}

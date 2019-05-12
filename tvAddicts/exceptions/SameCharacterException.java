package tvAddicts.exceptions;

public class SameCharacterException extends TVAddictException {
    public SameCharacterException() {
    }

    @Override
    public String getMessage() {
        return "Like... you know, they are THE SAME character! duuuuh...";
    }
}

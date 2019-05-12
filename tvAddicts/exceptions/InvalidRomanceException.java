package tvAddicts.exceptions;

import tvAddicts.characters.Character;

public class InvalidRomanceException extends TVAddictException {

    private String character;

    public InvalidRomanceException(String character) {
        this.character = character;
    }

    @Override
    public String getMessage() {
        return character + " cannot be in a single person romantic relationship!";
    }
}

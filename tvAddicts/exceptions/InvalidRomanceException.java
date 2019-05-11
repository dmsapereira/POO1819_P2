package tvAddicts.exceptions;

import tvAddicts.characters.Character;

public class InvalidRomanceException extends TVAddictException {

    private Character character;

    public InvalidRomanceException(Character character) {
        this.character = character;
    }

    @Override
    public String getMessage() {
        return this.character + " cannot be in a single person romantic relationship!";
    }
}

package tvAddicts.exceptions;

import tvAddicts.characters.Character;

public class VoidCharacterException extends TVAddictException {

    private Character character;

    public VoidCharacterException(Character character) {
        this.character = character;
    }

    @Override
    public String getMessage() {
        return "Who is " + this.character.getName() + "?";
    }
}

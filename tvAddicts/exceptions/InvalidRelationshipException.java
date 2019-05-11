package tvAddicts.exceptions;

import tvAddicts.characters.Character;

public class InvalidRelationshipException extends TVAddictException {
    private Character character;
    public InvalidRelationshipException(Character character) {
        this.character = character;
    }

    @Override
    public String getMessage() {
        return this.character.getName() + " cannot be parent and child at the same time!";
    }
}

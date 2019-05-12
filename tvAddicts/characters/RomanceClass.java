package tvAddicts.characters;

import java.util.LinkedList;
import java.util.List;

public class RomanceClass implements Romance {
    private List<Character> characters;

    public RomanceClass(Character character1, Character character2){
        this.characters = new LinkedList<>();
        this.characters.add(character1);
        this.characters.add(character2);
        character1.addRomance(character2);
    }
    @Override
    public List<Character> getCharacters() {
        return this.characters;
    }
}

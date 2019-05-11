package tvAddicts.characters;

import java.util.Map;
import java.util.TreeMap;

public class QuoteClass implements Quote {

    private String quote;
    private Map<String, Character> characters;

    public QuoteClass(String quote, Character character) {
        this.quote = quote;
        this.characters= new TreeMap<>();
        this.addCharacter(character);
    }

    @Override
    public String getQuote() {
        return this.quote;
    }

    @Override
    public void addCharacter(Character character) {
        this.characters.put(character.getName(), character);
    }

    @Override
    public Map<String, Character> whoSaidThis() {
        return this.characters;
    }
}

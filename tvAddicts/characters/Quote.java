package tvAddicts.characters;

import java.util.Map;

public interface Quote {

    String getQuote();

    void addCharacter(Character character);

    Map<String, Character> whoSaidThis();
}

package tvAddicts.characters;

import tvAddicts.shows.Show;

public class VirtualCharacterClass extends CharacterClass implements VirtualCharacter {

    private Company company;
    private int cost;

    public VirtualCharacterClass(String name, Show show, Company company, int cost){
        super(name, show);
        this.company=company;
        this.cost=cost;
    }
    @Override
    public Company getCompany() {
        return null;
    }

    @Override
    public int getCost() {
        return 0;
    }
}

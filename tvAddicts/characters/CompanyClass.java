package tvAddicts.characters;

import java.util.LinkedList;
import java.util.List;

public class CompanyClass implements Company {

    private String name;
    private List<VirtualCharacter> cgi;

    public CompanyClass(String name){
        this.name=name;
        this.cgi=new LinkedList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addCGI(VirtualCharacter character) {
        this.cgi.add(character);
    }

    @Override
    public List<VirtualCharacter> getCGI() {
        return this.cgi;
    }

    @Override
    public int getTotalCost() {
        int counter = 0;
        for (VirtualCharacter c : this.cgi)
            counter += c.getCost();
        return counter;
    }
}

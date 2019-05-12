package tvAddicts.characters;

import tvAddicts.shows.Show;

import java.util.LinkedList;
import java.util.List;

public class ActorClass implements Actor {
    private String name;
    private List<RealCharacter> roles;

    public ActorClass(String name) {
        this.name = name;
        this.roles = new LinkedList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addCharacter(RealCharacter character) {
        this.roles.add(character);
    }

    @Override
    public int getNumberOfRomances() {
        int counter = 0;
        for (RealCharacter role : this.roles)
            counter += role.getRomances().size();
        return counter;
    }

    @Override
    public List<RealCharacter> getRoles() {
        return this.roles;
    }

    @Override
    public List<Show> getShowsParticipated() {
        List<Show> shows = new LinkedList<>();
        for (Character role : this.roles)
            if (!shows.contains(role.getShow()))
                shows.add(role.getShow());
        return shows;
    }

    @Override
    public int getNumberOfShowsWithRomance() {
        int counter = 0;
        for (Character role : this.roles)
            if (role.getShow().getNumberOfRomances() != 0)
                counter++;
        return counter;
    }

    @Override
    public int compareTo(Actor o) {
        int a, b, c;
        if ((a = Integer.compare(this.getNumberOfRomances(), o.getNumberOfRomances())) == 0) {
            if ((b = Integer.compare(o.getShowsParticipated().size(), this.getShowsParticipated().size())) == 0) {
                if ((c = Integer.compare(this.getNumberOfShowsWithRomance(), o.getNumberOfShowsWithRomance())) == 0) {
                    return this.name.compareTo(o.getName());
                } else
                    return c;
            } else
                return b;
        } else
            return a;
    }
}

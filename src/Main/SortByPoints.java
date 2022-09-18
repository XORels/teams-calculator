package Main;

import java.util.Comparator;

public class SortByPoints implements Comparator<Team> {
    @Override
    public int compare(Team o1, Team o2) {
        return o2.totalPoints - o1.totalPoints;
    }
}

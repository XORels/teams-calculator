package Main;

import java.io.Serializable;

public class Team implements Serializable {
    public static String[] trophies = {"\uD83C\uDFC6", "\uD83E\uDD48", "\uD83E\uDD49", ""};
    public int totalPoints = 0;
    public int dailyPoints = 0;
    public int difference = 0;
    public int yesterdayPoints = 0;
    public String teamName = "";
    public String trophy = "";
    public int dayBeforePoints = 0;

    public Team(String name) {
        teamName = name;
    }

    public void calcTotal() {
        totalPoints += dailyPoints;
    }

    private double calcDifferencePercentage() {
        if (difference == 0 || yesterdayPoints == 0)
            return 0;
        else
            return (double) difference / yesterdayPoints * 100;
    }

    public String changeFromYesterday() {
        difference = dailyPoints - yesterdayPoints;
        double perc = calcDifferencePercentage();

        dayBeforePoints = yesterdayPoints;
        yesterdayPoints = dailyPoints;

        if (difference > 0)
            return String.format(teamName + ":[b] +%,d (+%,.3f%%)[/b]", difference, perc);
        else
            return String.format(teamName + ": %,d (%,.3f%%)", difference, perc);

    }
}

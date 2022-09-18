package Main;

import java.io.*;
import java.util.Arrays;

public class Teams {
    Team[] teams = new Team[4];
    Team[] placement;

    public Teams() {
        teams[0] = new Team("A Team");
        teams[1] = new Team("B Team");
        teams[2] = new Team("C Team");
        teams[3] = new Team("D Team");
    }

    public Team[] getTeams() {
        return this.teams;
    }

    public void assignPlacements() {
        this.placement = this.teams.clone();
        Arrays.sort(this.placement, new SortByPoints());
        for (int i = 0; i < 4; i++) {
            placement[i].trophy = Team.trophies[i];
        }
    }

    public String differences() {
        StringBuilder differences = new StringBuilder();
        for (int i = 0; i < placement.length - 1; i++) {
            differences.append(String.format("%,d", (placement[i].totalPoints - placement[i + 1].totalPoints)));
            differences.append(" points between ");
            differences.append(placement[i].teamName);
            differences.append(" and ");
            differences.append(placement[i + 1].teamName);
            differences.append("\n");
        }
        return differences.toString();
    }


    File data = new File("Data.txt");
    public int loadData() {
        try {
            FileInputStream inStream = new FileInputStream(data);
            ObjectInputStream o = new ObjectInputStream(inStream);
            this.teams = (Team[]) o.readObject();
            int day = (int) (Integer) o.readObject();
            o.close();
            return day;
        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            System.out.print("Oops!");
            e.printStackTrace();
            return -1;
        }
    }

    public void saveData(int day) {
        try {
            FileOutputStream out = new FileOutputStream(data);
            ObjectOutputStream s = new ObjectOutputStream(out);
            s.writeObject(teams);
            s.writeObject(day);
            s.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

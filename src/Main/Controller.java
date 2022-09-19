package Main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws IOException {
        File data = new File("Data.txt");
        Teams teams = new Teams();
        int day = 0;
        // Image string used to hold URL of image used for blog
        String image = null;
        Scanner in = new Scanner(System.in);

        if (data.createNewFile()){
            System.out.println("New Event! Data file created");
            System.out.println("Continue? y/n");
            char cont = in.next().charAt(0);
            if (cont == 'y') {
                teams = new Teams();
            } else {
                System.exit(1);
            }
        }
        else
            day = teams.loadData(data);

        System.out.println("2021 Game Points Calculator!");

        System.out.println("Undo last day or add new day? u/a");
        char choice = in.next().charAt(0);
        if (choice == 'u') {
            //Undo for correcting errors
            for (Team team : teams.getTeams()
            ) {
                team.undo();
            }
            day--;
        }

        //Entering values
        boolean entered = false;

        while (!entered) {
            System.out.println("Entering values for day " + (day + 1));
            System.out.print("Paste image link: ");
            image = in.next();

            System.out.println("Enter daily values:");

            for (Team team : teams.getTeams()) {
                System.out.println(team.teamName + ": ");
                team.dailyPoints = in.nextInt();
            }

            System.out.println("Are these correct? y/n");
            System.out.println(image);
            for (Team team : teams.getTeams()) {
                System.out.format(team.teamName + ": %,d%n", team.dailyPoints);
            }
            char correct = in.next().charAt(0);
            if (correct == 'y') {
                entered = true;
            }
        }

        for (Team team : teams.getTeams()) {
            team.calcTotal();
        }

        teams.assignPlacements();

        System.out.println("Copy: \n");
        OutputBuilder outputBuilder = new OutputBuilder();
        outputBuilder.add("[b]Day " + (day + 1) + "[/b][img]" + image + "[/img]");
        outputBuilder.add("[b]Total so far:[/b]");

        for (Team team : teams.getTeams()) {
            outputBuilder.add(String.format(team.teamName + ": %,d" + " ", team.totalPoints) + team.trophy);
        }

        outputBuilder.add("\n[b]Change from previous day:[/b]");

        for (Team team : teams.getTeams()) {
            outputBuilder.add(team.changeFromYesterday());
        }

        outputBuilder.add("\n[b]Points separating the teams:[/b]");

        outputBuilder.add(teams.differences());

        System.out.println(outputBuilder.returnOutput());

        System.out.println("Save data? y/n");
        char save = in.next().charAt(0);
        if (save == 'y') {
            day++;
            teams.saveData(day);
            outputBuilder.saveOutput(day);
            System.out.println("Day " + day + " saved!");
        } else {
            System.out.print("Day " + (day + 1) + " not saved!");
        }
    }
}

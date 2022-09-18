package Main;

import java.io.IOException;
import java.io.PrintWriter;

public class OutputBuilder {
    String output = "";

    public void add(String output) {
        this.output += output + "\n";
    }

    public String returnOutput() {
        return output;
    }

    public void saveOutput(int day) {
        try {
            PrintWriter out = new PrintWriter("Output Day " + day + ".txt");
            out.print(output);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

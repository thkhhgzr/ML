package api.AI;

import api.models.Prediction;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AiConnection {
  private static String runScript(int month, int year) throws IOException {
    String path = Paths.get(new File("").getAbsolutePath()) + "\\src\\main\\java\\api\\AI\\main.py";
    Process p = Runtime.getRuntime().exec("python " + path + " " + month + " " + year);
    BufferedReader output = new BufferedReader(new
            InputStreamReader(p.getInputStream()));
    String response = output.readLine();

    return response.substring(1, response.length() - 1);
  }

  public static List<Prediction> predict(int month, int year) throws IOException {
    List<Prediction> predictions = new ArrayList<>();
    String response = runScript(month, year);
    String[] responses = response.split(", ");

    for (int i = 1; i <= 6; i++) {
      predictions.add(new Prediction(i,
              Double.parseDouble(responses[i - 1].substring(1))));
    }

    return predictions;
  }
}

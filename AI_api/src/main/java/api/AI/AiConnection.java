package api.AI;

import api.models.Prediction;
import org.python.antlr.ast.Str;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AiConnection {
  public static List<Prediction> predict(int month, int year) {
    List<Prediction> predictions = new ArrayList<>();
    String[] ids = {
        "22037339-a759-4af4-a2dc-b740713d80bd",
        "806d3b4d-aaae-4dc7-82ae-392ce2eaec27",
        "b2c82f9d-c893-4139-90ef-652c7aca07db",
        "6da1e62b-5f20-43b9-bb16-9f3b5c2ac29a",
        "cb155e7e-7da2-4bc1-b6dc-adf4d5e8218c",
        "6c805466-1d74-4d09-9719-ae5d8a4ad152"
    };

    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    InputStream is = classloader.getResourceAsStream("Predictions.txt");

    List<String> allPredictionsValue =
            new BufferedReader(new InputStreamReader(is,
                    StandardCharsets.UTF_8)).lines().collect(Collectors.toList());

    System.out.println(allPredictionsValue);
    System.out.println(allPredictionsValue.get(month));
    String[] predictionsValue = allPredictionsValue.get(month).split(",");

    for (int i = 0; i <= 5; i++) {
      predictions.add(new Prediction(ids[i],
              Double.parseDouble(predictionsValue[i])));
    }

    return predictions;
  }
}

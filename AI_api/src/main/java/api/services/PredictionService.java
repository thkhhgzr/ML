package api.services;

import api.AI.AiConnection;
import api.models.Prediction;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@Service
public class PredictionService {
  public List<Prediction> allPredictions() throws IOException {
    int month = Calendar.getInstance().get(Calendar.MONTH);
    int year = Calendar.getInstance().get(Calendar.YEAR);

    return AiConnection.predict(month, year);
  }
}

package api.services;

import api.AI.AiConnection;
import api.models.Prediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@Service
public class PredictionService {
  @Autowired private PredictionRepository predictionRepository;

  public List<Prediction> allPredictions() throws IOException {
    int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
    int year = Calendar.getInstance().get(Calendar.YEAR);

    return AiConnection.predict(month, year);
  }
}

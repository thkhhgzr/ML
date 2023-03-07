package api.services;

import api.models.Prediction;
import api.repositories.PredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionService {
  @Autowired private PredictionRepository predictionRepository;

  public List<Prediction> allPredictions() {
    return this.predictionRepository.findAll();
  }
}

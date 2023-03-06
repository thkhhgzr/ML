package api.controllers;

import api.Authentication;
import api.services.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/predictions")
public class PredictionController {
  @Autowired private PredictionService predictionService;

  @GetMapping("/predict")
  public HashMap<String, Double> predict(@RequestHeader String token) {
    if (!Authentication.verifyUser(token)) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }

    HashMap<String, Double> allPredictions = new HashMap<>();
    this.predictionService.allPredictions()
            .forEach(prediction -> allPredictions.put(prediction.area(), prediction.probability()));

    return allPredictions;
  }
}

package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PREDICTION")
public class Prediction {
  @Id
  @JsonProperty
  private String area;

  @JsonProperty
  private double probability;

  public String area() {
    return this.area;
  }

  public double probability() {
    return this.probability;
  }

  private void changeArea(String area) {
    this.area = area;
  }

  private void changeProbability(double probability) {
    this.probability = probability;
  }

  public Prediction() {}

  public Prediction(int area, double probability) {
    this.changeArea(String.valueOf(area));
    this.changeProbability(probability);
  }
}

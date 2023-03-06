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
  @Column(name = "area")
  private String area;

  @JsonProperty
  @Column(name = "probability")
  private double probability;

  public String area() {
    return this.area;
  }

  public double probability() {
    return this.probability;
  }
}

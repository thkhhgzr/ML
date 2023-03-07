package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import java.util.Date;

public class ReceivedEvent {
  @JsonProperty
  private int brigade;
  @JsonProperty
  private Date date;
  @JsonProperty
  private int deads;
  @JsonProperty
  private int easy;
  @JsonProperty
  private int hard;
  @JsonProperty
  private double height;
  @JsonProperty
  private int medium;
  @JsonProperty
  private String[] weapons;
  @JsonProperty
  private double width;

  public int brigade() {
    return this.brigade;
  }

  public Date date() {
    return this.date;
  }

  public int deads() {
    return this.deads;
  }

  public int easy() {
    return this.easy;
  }

  public int hard() {
    return this.hard;
  }

  public double height() {
    return this.height;
  }

  public int medium() {
    return this.medium;
  }

  public String[] weapons() {
    return weapons;
  }

  public double width() {
    return width;
  }
}

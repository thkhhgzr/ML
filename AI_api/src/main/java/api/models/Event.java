package api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(EventKey.class)
@Table(name = "EVENTS")
public class Event implements Serializable {
  @Id
  @JsonProperty
  @Column(name = "brigade")
  private int brigade;

  @JsonProperty
  @Column(name = "date")
  private Date date;

  @JsonProperty
  @Column(name = "deads")
  private int deads;

  @JsonProperty
  @Column(name = "easy")
  private int easy;

  @JsonProperty
  @Column(name = "hard")
  private int hard;

  @Id
  @JsonProperty
  @Column(name = "height")
  private double height;

  @JsonProperty
  @Column(name = "medium")
  private int medium;

  @JsonProperty
  @Column(name = "weapon")
  private String weapon;

  @Id
  @JsonProperty
  @Column(name = "width")
  private double width;

  private void changeBrigade(int brigade) {
    this.brigade = brigade;
  }

  private void changeDate(Date date) {
    this.date = date;
  }

  private void changeDeads(int deads) {
    this.deads = deads;
  }

  private void changeEasy(int easy) {
    this.easy = easy;
  }

  private void changeHard(int hard) {
    this.hard = hard;
  }

  private void changeHeight(double height) {
    this.height = height;
  }

  private void changeMedium(int medium) {
    this.medium = medium;
  }

  private void changeWeapon(String weapon) {
    this.weapon = weapon;
  }

  private void changeWidth(double width) {
    this.width = width;
  }

  public Event() {}

  public Event(ReceivedEvent receivedEvent) {
    this.changeBrigade(receivedEvent.brigade());
    this.changeDate(receivedEvent.date());
    this.changeDeads(receivedEvent.deads());
    this.changeEasy(receivedEvent.easy());
    this.changeHard(receivedEvent.hard());
    this.changeHeight(receivedEvent.height());
    this.changeMedium(receivedEvent.medium());
    this.changeWeapon(receivedEvent.weapons()[0]);
    this.changeWidth(receivedEvent.width());
  }
}

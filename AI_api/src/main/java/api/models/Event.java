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
}

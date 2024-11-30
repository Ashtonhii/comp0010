package uk.ac.ucl.comp0010.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * A class represents rate.
 */
@Entity
public class Rate {

  @Id
  @GeneratedValue
  Integer score;

  @ManyToOne
  @JoinColumn(name = "movie_id")
  Movie movie;

  public Rate() {

  }

  public Rate(int score) {
    this.score = score;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

}

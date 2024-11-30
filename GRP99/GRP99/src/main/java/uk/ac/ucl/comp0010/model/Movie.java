package uk.ac.ucl.comp0010.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import uk.ac.ucl.comp0010.exception.EmptyRateException;

/**
 * A class represents a movie.
 */
@Entity
public class Movie {

  @Id
  @GeneratedValue
  Long id;

  List<Integer> rates;

  public Movie() {
    this.rates = new ArrayList<Integer>();
  }

  /**
   * It returns average rate of the movie.
   *
   * @return double typed value of average rate
   * @throws EmptyRateException it throws if there is no rate
   */

  public Double getAverageRate() throws EmptyRateException {
    if (rates.size() < 1) {
      throw new EmptyRateException();
    }

    Double sum = 0.0;
    for (Integer rate : rates) {
      sum += rate;
    }
    return sum / rates.size();
  }

  public void addRate(int rate) {
    this.rates.add(rate);
  }

}

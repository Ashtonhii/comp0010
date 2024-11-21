package uk.ac.ucl.comp0010.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import uk.ac.ucl.comp0010.exception.EmptyRateException;

@Entity
public class Movie {

  @Id
  @GeneratedValue
  Long id;

  List<Integer> rates;

  public Movie() {
    this.rates = new ArrayList<Integer>();
  }

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

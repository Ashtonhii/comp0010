package uk.ac.ucl.comp0010.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.ucl.comp0010.exception.EmptyRateException;

public class MovieTest {

  Movie movie;

  @BeforeEach
  void beforeEach() {
    Movie movie = new Movie();
    movie.setTitle("Venom");
  }

  @Test
  void computeAverageRateTest() throws EmptyRateException {
    Movie movie = new Movie();
    movie.setTitle("Venom");
    Rate rate = new Rate();
    rate.setScore(3);

    movie.addRate(new Rate(5));
    movie.addRate(rate);
    assertEquals(4.0, movie.computeAverageRate());
    assertEquals("Venom", movie.getTitle());
  }

  @Test
  void computeAverageRateTestWithEmptyRates() {
    Movie movie = new Movie();
    assertThrows(EmptyRateException.class, () -> {
      movie.computeAverageRate();
    });
  }

}

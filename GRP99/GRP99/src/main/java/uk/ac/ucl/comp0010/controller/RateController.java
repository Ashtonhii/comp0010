package uk.ac.ucl.comp0010.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.comp0010.model.Movie;
import uk.ac.ucl.comp0010.model.Rate;
import uk.ac.ucl.comp0010.repository.MovieRepository;
import uk.ac.ucl.comp0010.repository.RateRepository;

@RestController
public class RateController {

  private final MovieRepository movieRepository;

  private final RateRepository rateRepository;

  private RateController(MovieRepository movieRepository, RateRepository rateRepository) {
    this.movieRepository = movieRepository;
    this.rateRepository = rateRepository;
  }

  @PostMapping(value = "/rates/addRate")
  public ResponseEntity<Rate> addRate(@RequestBody Map<String, String> params) {
    Movie movie = movieRepository.findById(Long.valueOf(params.get("movie_id"))).orElseThrow();

    Rate rate = new Rate();
    rate.setScore(Integer.valueOf(params.get("score")));
    rate.setMovie(movie);
    rate = rateRepository.save(rate);

    return ResponseEntity.ok(rate);

  }

}

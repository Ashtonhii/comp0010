DROP TABLE IF EXISTS rate;
DROP TABLE IF EXISTS movie;


CREATE TABLE movie(
  id SERIAL PRIMARY KEY,
  title text
);

CREATE TABLE rate(
  id SERIAL PRIMARY KEY,
  movie_id INT,
  score INT
  FOREIGN KEY (movie_id)
    REFERENCES movie (id)
);
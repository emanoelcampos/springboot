package dev.emanoel.springboot.service;

import dev.emanoel.springboot.domain.Film;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FilmService {

    private static List<Film> films;

    static {
        films = new ArrayList<>(List.of(new Film(1L,"Truman Show"), new Film(2L,"The Dark Knight")));
    }

    //private final FilmRepository filmRepository;

    public List<Film> listAll () {
        return films;
    }

    public Film findById (long id) {
        return films.stream()
                .filter(film -> film.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Film not found"));
    }

    public Film save(Film film) {
        film.setId(ThreadLocalRandom.current().nextLong(3, 100));
        films.add(film);
        return film;
    }

    public void delete(long id) {
        films.remove(findById(id));
    }

    public void replace(Film film) {
        delete(film.getId());
        films.add(film);
    }
}

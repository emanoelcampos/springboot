package dev.emanoel.springboot.controller;

import dev.emanoel.springboot.domain.Film;
import dev.emanoel.springboot.service.FilmService;
import dev.emanoel.springboot.util.DateUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("films")
@Log4j2
@RequiredArgsConstructor
public class FilmController {

    private final DateUtil dateUtil;
    private final FilmService filmService;

    @GetMapping
    public ResponseEntity<List<Film>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(filmService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Film> findById(@PathVariable long id) {
        return ResponseEntity.ok(filmService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Film> save(@RequestBody Film film) {
        return new ResponseEntity<>(filmService.save(film), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        filmService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Film film) {
        filmService.replace(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

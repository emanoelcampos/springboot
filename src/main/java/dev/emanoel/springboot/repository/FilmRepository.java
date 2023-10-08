package dev.emanoel.springboot.repository;

import dev.emanoel.springboot.domain.Film;

import java.util.List;

public interface FilmRepository {

    List<Film> listAll();
}

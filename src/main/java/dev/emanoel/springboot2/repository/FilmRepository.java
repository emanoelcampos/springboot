package dev.emanoel.springboot2.repository;

import dev.emanoel.springboot2.domain.Film;

import java.util.List;

public interface FilmRepository {

    List<Film> listAll();
}

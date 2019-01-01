package com.webservices.scoretrack.repo;

import com.webservices.scoretrack.domain.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
}

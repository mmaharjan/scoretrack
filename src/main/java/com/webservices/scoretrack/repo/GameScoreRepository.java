package com.webservices.scoretrack.repo;

import com.webservices.scoretrack.domain.GameScore;
import org.springframework.data.repository.CrudRepository;

public interface GameScoreRepository extends CrudRepository<GameScore, Long> {
}

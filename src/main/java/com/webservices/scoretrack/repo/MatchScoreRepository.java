package com.webservices.scoretrack.repo;

import com.webservices.scoretrack.domain.MatchScore;
import org.springframework.data.repository.CrudRepository;

public interface MatchScoreRepository extends CrudRepository<MatchScore, Long> {
}

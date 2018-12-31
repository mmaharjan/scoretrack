package com.webservices.scoretrack.repo;

import com.webservices.scoretrack.domain.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {
}

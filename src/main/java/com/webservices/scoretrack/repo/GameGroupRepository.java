package com.webservices.scoretrack.repo;

import com.webservices.scoretrack.domain.GameGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameGroupRepository extends CrudRepository<GameGroup, Long> {
}

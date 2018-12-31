package com.webservices.scoretrack.repo;

import com.webservices.scoretrack.domain.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {

}

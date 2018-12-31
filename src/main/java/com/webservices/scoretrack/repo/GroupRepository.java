package com.webservices.scoretrack.repo;

import com.webservices.scoretrack.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository  extends CrudRepository<Group, Long> {
}

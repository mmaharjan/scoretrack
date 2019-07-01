package com.webservices.scoretrack.repo;

import com.webservices.scoretrack.domain.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

// since we have spring-data-rest in classpath, this respository methods are exposed as REST APIs by default
@RepositoryRestResource(exported=false)
public interface GameRepository extends PagingAndSortingRepository<Game, Long> {

    /**
     * Lookup a Page of Game associated with a GroupDivision
     *
     * @param group group name
     * @param pageable details for finding the correct page
     * @return A page of GameGroups if found, empty otherwise
     */
    //Page<Game> findByGameGroup(@Param("group") String group, Pageable pageable);

    List<Game> findAll();

    boolean existsByGameId(String gameId);
}

package com.vlunn.eventshuffle.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlunn.eventshuffle.persistence.model.Happening;

/**
 * Repository for persisting happenings.
 * 
 * As a JPARepository, has full CRUD, pagination and sorting API of
 * CrudRepository and PagingAndSortingRepository.
 */
@Repository
public interface HappeningRepository extends JpaRepository<Happening, UUID> {

}

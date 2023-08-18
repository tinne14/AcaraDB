package com.metrodata.erdtest.entities.repositories;

import com.metrodata.erdtest.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    // Query Method
    List<Event> findByCapacityLessThan(int capacity);

    // Custom Query JPQL
    @Query("SELECT e FROM Event e WHERE e.capacity < ?1")
    List<Event> getAllEventLessThanCapacity(int capacity);

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_m_events WHERE capacity < ?1", nativeQuery = true)
    List<Event> getAllEventLessThanCapacityNative(int capacity);
}

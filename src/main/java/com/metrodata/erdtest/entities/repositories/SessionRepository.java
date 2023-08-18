package com.metrodata.erdtest.entities.repositories;

import com.metrodata.erdtest.entities.Event;
import com.metrodata.erdtest.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findByName(String name);

    // Custom Query JPQL
    @Query("SELECT s FROM Session s WHERE s.name = ?1")
    List<Session> getAllName(String name);

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_m_sessions WHERE name = ?1", nativeQuery = true)
    List<Session> getAllNameNative(String name);
}

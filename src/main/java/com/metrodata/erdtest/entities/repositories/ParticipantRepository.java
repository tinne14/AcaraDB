package com.metrodata.erdtest.entities.repositories;

import com.metrodata.erdtest.entities.Event;
import com.metrodata.erdtest.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long>{
    // Query Method
    List<Participant> findByUniversity(String university);

    // Custom Query JPQL
    @Query("SELECT p FROM Participant p WHERE p.university = ?1")
    List<Participant> getAllUniversity(String university);

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_m_participant WHERE university = ?1", nativeQuery = true)
    List<Participant> getAllUniversityNative(String university);

}

package com.metrodata.erdtest.entities.repositories;

import com.metrodata.erdtest.entities.SessionRegistrant;
import com.metrodata.erdtest.entities.SessionSpeaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionSpeakerRepository extends JpaRepository<SessionSpeaker, Long> {
    // Query Method
    List<SessionSpeaker> findByIdIs(int id);

    // Custom Query JPQL
    @Query("SELECT s FROM SessionSpeaker s WHERE s.id = ?1")
    List<SessionSpeaker> getIdIs(int id);

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_tr_session_speakers WHERE id = ?1", nativeQuery = true)
    List<SessionSpeaker> getIdIsNative(int id);
}

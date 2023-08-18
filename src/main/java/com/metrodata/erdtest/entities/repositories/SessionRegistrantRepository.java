package com.metrodata.erdtest.entities.repositories;

import com.metrodata.erdtest.entities.Event;
import com.metrodata.erdtest.entities.SessionRegistrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRegistrantRepository extends JpaRepository<SessionRegistrant, Long> {
    List<SessionRegistrant> findByIsAttended(int isAttended);

    // Custom Query JPQL
    @Query("SELECT s FROM SessionRegistrant s WHERE s.isAttended = ?1")
    List<SessionRegistrant> getAllIsAttended(int isAttended);

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_tr_session_registrants WHERE isAttended = ?1", nativeQuery = true)
    List<SessionRegistrant> getAllIsAttendedNative(int isAttended);
}

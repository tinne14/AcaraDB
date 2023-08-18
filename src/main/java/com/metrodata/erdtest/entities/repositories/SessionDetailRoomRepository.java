package com.metrodata.erdtest.entities.repositories;

import com.metrodata.erdtest.entities.SessionDetailRoom;
import com.metrodata.erdtest.entities.SessionSpeaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionDetailRoomRepository extends JpaRepository<SessionDetailRoom, Long> {
    List<SessionDetailRoom> findByIdIs(int id);

    // Custom Query JPQL
    @Query("SELECT s FROM SessionDetailRoom s WHERE s.id = ?1")
    List<SessionDetailRoom> getIdIs(int id);

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_tr_session_detail_rooms WHERE id = ?1", nativeQuery = true)
    List<SessionDetailRoom> getIdIsNative(int id);

}

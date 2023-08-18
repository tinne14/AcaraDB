package com.metrodata.erdtest.entities.repositories;

import com.metrodata.erdtest.entities.Room;
import com.metrodata.erdtest.entities.SessionSpeaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByIdIs(int id);

    // Custom Query JPQL
    @Query("SELECT r FROM Room r WHERE s.id = ?1")
    List<Room> getIdIs(int id);

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_m_rooms WHERE id = ?1", nativeQuery = true)
    List<Room> getIdIsNative(int id);

}

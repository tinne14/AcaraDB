package com.metrodata.erdtest.entities.repositories;

import com.metrodata.erdtest.entities.SessionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionDetailRepository extends JpaRepository<SessionDetail, Long> {
    // Query Method
    List<SessionDetail> findByDescriptionIsNotNull();

    // Custom Query JPQL
    @Query("SELECT s FROM SessionDetail s WHERE s.description IS NOT NULL")
    List<SessionDetail> getAllDescriptionIsNotNull();

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_m_session_details WHERE description IS NOT NULL", nativeQuery = true)
    List<SessionDetail> getAllDescriptionIsNotNullNative();
}

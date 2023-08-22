package com.metrodata.erdtest.entities.repositories;

import com.metrodata.erdtest.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
    // Query Method
    List<Speaker> findByJobTitle(String jobTitle);

    // Custom Query JPQL
    @Query("SELECT s FROM Speaker s WHERE s.jobTitle = ?1")
    List<Speaker> getAllJobTitle(String jobTitle);

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_m_speakers WHERE job_title = ?1", nativeQuery = true)
    List<Speaker> getAllJobTitleNative(String jobTitle);

}

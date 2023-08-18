package com.metrodata.erdtest.entities.repositories;

import com.metrodata.erdtest.entities.Sponsor;
import com.metrodata.erdtest.entities.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long> {

    List<Sponsor> findByName(String name);

    // Custom Query JPQL
    @Query("SELECT s FROM Sponsor s WHERE s.name = ?1")
    List<Sponsor> getAllName(String name);

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_m_sponsors WHERE name = ?1", nativeQuery = true)
    List<Sponsor> getAllNameNative(String name);

}

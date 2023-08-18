package com.metrodata.erdtest.entities.repositories;

import com.metrodata.erdtest.entities.CertificateTemplates;
import com.metrodata.erdtest.entities.SessionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateTemplatesRepository extends JpaRepository<CertificateTemplates, Long> {
    List<CertificateTemplates> findByCertificateUrlIsNotNull();

    // Custom Query JPQL
    @Query("SELECT c FROM CertificateTemplates c ")
    List<CertificateTemplates> getAllCertificateTemplates();

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_m_certificate_templates", nativeQuery = true)
    List<CertificateTemplates> getAllCertificateTemplatesNative();

}

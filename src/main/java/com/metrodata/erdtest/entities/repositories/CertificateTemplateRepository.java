package com.metrodata.erdtest.entities.repositories;

import com.metrodata.erdtest.entities.CertificateTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateTemplateRepository extends JpaRepository<CertificateTemplate, Long> {
    // Query Method
    List<CertificateTemplate> findByCertificateUrlIsNotNull();

    // Custom Query JPQL
    @Query("SELECT c FROM CertificateTemplate c ")
    List<CertificateTemplate> getAllCertificateTemplate();

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_m_certificate_templates", nativeQuery = true)
    List<CertificateTemplate> getAllCertificateTemplateNative();

}

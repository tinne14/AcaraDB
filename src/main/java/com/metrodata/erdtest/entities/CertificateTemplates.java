package com.metrodata.erdtest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_m_certificate_templates")
public class CertificateTemplates {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "certificate_url", columnDefinition = "TEXT", nullable = false)
    private String certificateUrl;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private SessionDetail sessionDetail;
}

package com.metrodata.erdtest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_m_certificate_templates")
public class CertificateTemplate {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "certificate_url", columnDefinition = "TEXT", nullable = false)
    private String certificateUrl;

    @OneToOne
    @JsonIgnore
    @MapsId
    @JoinColumn(name = "id")
    private SessionDetail sessionDetail;
}

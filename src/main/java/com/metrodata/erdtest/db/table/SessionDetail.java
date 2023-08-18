package com.metrodata.erdtest.db.table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_m_details")
public class SessionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(columnDefinition = "INT", nullable = false)
    private int capacity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @OneToMany(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    private List<trSessionRegistrant> trSessionRegistrants;

    @OneToMany(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    private List<trSessionSpeaker> trSessionSpeakers;

    @OneToMany(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    private List<trSessionDetailRoom> trSessionDetailRooms;

    @OneToOne(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CertificateTemplates certificateTemplates;
}

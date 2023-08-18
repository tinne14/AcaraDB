package com.metrodata.erdtest.entities;

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
    private List<SessionRegistrant> SessionRegistrants;

    @OneToMany(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    private List<SessionSpeaker> SessionSpeakers;

    @OneToMany(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    private List<SessionDetailRoom> SessionDetailRooms;

    @OneToOne(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CertificateTemplates certificateTemplates;
}

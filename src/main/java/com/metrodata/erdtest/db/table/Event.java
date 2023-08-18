package com.metrodata.erdtest.db.table;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "tb_m_events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String slug;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "start_registration", nullable = false)
    private LocalDateTime startRegistration;

    @Column(name = "close_registration", nullable = false)
    private LocalDateTime closeRegistration;

    @Column(columnDefinition = "INT", nullable = false)
    private int capacity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String location;

    @Column(name = "image_url", columnDefinition = "TEXT", nullable = false)
    private String imageUrl;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private int status;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Session> sessions;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Participant> participant;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Sponsor> sponsors;


}

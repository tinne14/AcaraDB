package com.metrodata.erdtest.db.table;

import com.metrodata.erdtest.db.enums.category;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_m_sponsors")
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(name = "logo_url", columnDefinition = "TEXT", nullable = false)
    private String logoUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private category category;

    @OneToMany(mappedBy = "sponsor", cascade = CascadeType.ALL)
    private List<Speaker> speakers;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}

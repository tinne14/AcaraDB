package com.metrodata.erdtest.db.table;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_m_rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<trSessionDetailRoom> trSessionDetailRooms;
}

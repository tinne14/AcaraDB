package com.metrodata.erdtest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_m_rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<SessionDetailRoom> SessionDetailRooms;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}

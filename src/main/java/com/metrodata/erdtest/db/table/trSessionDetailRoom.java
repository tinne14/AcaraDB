package com.metrodata.erdtest.db.table;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tr_session_detail_rooms")
public class trSessionDetailRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "session_detail_id")
    private SessionDetail sessionDetail;
}

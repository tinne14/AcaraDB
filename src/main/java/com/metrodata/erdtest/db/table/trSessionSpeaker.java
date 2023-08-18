package com.metrodata.erdtest.db.table;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tr_session_speakers")
public class trSessionSpeaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "speaker_id")
    private Speaker speaker;

    @ManyToOne
    @JoinColumn(name = "session_detail_id")
    private SessionDetail sessionDetail;
}

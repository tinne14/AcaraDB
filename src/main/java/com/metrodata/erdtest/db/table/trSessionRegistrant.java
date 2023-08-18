package com.metrodata.erdtest.db.table;

import com.metrodata.erdtest.db.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_tr_session_registrants")
public class trSessionRegistrant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "attended_at")
    private LocalDateTime attendedAt;

    @Column(name = "is_attended", columnDefinition = "TINYINT")
    private int isAttended;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private com.metrodata.erdtest.db.enums.status status;

    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;

    @Column(name = "is_reminder_sent", columnDefinition = "TINYINT", nullable = false)
    private int isReminderSent;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "session_detail_id")
    private SessionDetail sessionDetail;
}

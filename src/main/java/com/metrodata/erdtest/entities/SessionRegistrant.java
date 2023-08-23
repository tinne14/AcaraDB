package com.metrodata.erdtest.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class SessionRegistrant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "attended_at")
    private LocalDateTime attendedAt;

    @Column(name = "is_attended", columnDefinition = "TINYINT")
    private int isAttended;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private com.metrodata.erdtest.entities.enums.status status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;

    @Column(name = "is_reminder_sent", columnDefinition = "TINYINT", nullable = false)
    private int isReminderSent;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "session_detail_id")
    private SessionDetail sessionDetail;
}

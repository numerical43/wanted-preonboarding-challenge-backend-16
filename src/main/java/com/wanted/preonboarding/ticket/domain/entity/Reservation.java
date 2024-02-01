package com.wanted.preonboarding.ticket.domain.entity;

import com.wanted.preonboarding.ticket.domain.dto.ReserveInfo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"performance_id", "round", "line", "seat"}))
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Reservation {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("예약 id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id", columnDefinition = "BINARY(16)", nullable = false)
    @Comment("공연전시ID")
    private Performance performance;

    @Column(nullable = false)
    @Comment("예약자명")
    private String name;

    @Column(nullable = false, name = "phone_number")
    @Comment("예약자 휴대전화 번호")
    private String phoneNumber;

    @Column(nullable = false)
    @Comment("회차(FK)")
    private int round;

    @Column(nullable = false)
    @Comment("입장 게이트")
    private int gate;

    @Column(nullable = false)
    @Comment("좌석 열")
    private char line;

    @Column(nullable = false)
    @Comment("좌석 행")
    private int seat;

    @CreationTimestamp
    @Column(nullable = false)
    @Comment("생성일")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    @Comment("수정일")
    private LocalDateTime updatedAt;

    @Builder
    public Reservation(int id, Performance performance, String name, String phoneNumber, int round, int gate, char line,
                       int seat, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.performance = performance;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.round = round;
        this.gate = gate;
        this.line = line;
        this.seat = seat;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Reservation of(ReserveInfo info, Performance performance) {
        return Reservation.builder()
                .performance(performance)
                .name(info.getReservationName())
                .phoneNumber(info.getReservationPhoneNumber())
                .round(info.getRound())
                .gate(1)
                .line(info.getLine())
                .seat(info.getSeat())
                .build();
    }

}

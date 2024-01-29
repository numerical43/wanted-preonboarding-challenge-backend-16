package com.wanted.preonboarding.ticket.domain.entity;

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
public class PerformanceSeatInfo {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("공연전시ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "performance_id", columnDefinition = "BINARY(16)")
    @Comment("공연/전시 ID")
    private Performance performance;

    @Column(nullable = false)
    @Comment("회차(FK)")
    private int round;

    @Column(nullable = false)
    @Comment("입장 게이트")
    private int gate;

    @Column(length = 2, nullable = false)
    @Comment("좌석 열")
    private String line;

    @Column(nullable = false)
    @Comment("좌석 행")
    private int seat;

    @Column(nullable = false, columnDefinition = "VARCHAR(255) default 'enable'")
    @Comment("예약 가능 여부")
    private String isReserve;

    @CreationTimestamp
    @Column(nullable = false)
    @Comment("생성일")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    @Comment("수정일")
    private LocalDateTime updatedAt;

    @Builder
    public PerformanceSeatInfo(Long id, int round, Performance performance, int gate, String line, int seat,
                               String isReserve, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.round = round;
        this.performance = performance;
        this.gate = gate;
        this.line = line;
        this.seat = seat;
        this.isReserve = isReserve;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}

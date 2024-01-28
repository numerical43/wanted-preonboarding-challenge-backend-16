package com.wanted.preonboarding.ticket.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
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

    @Column(nullable = false)
    @Comment("생성일")
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @Comment("수정일")
    private LocalDateTime updatedAt;

    public PerformanceSeatInfo(Builder builder) {
        this.id = builder.id;
        this.performance = builder.performance;
        this.gate = builder.gate;
        this.line = builder.line;
        this.seat = builder.seat;
        this.isReserve = builder.isReserve;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static class Builder {
        private Long id;
        private Performance performance;
        private int gate;
        private String line;
        private int seat;
        private String isReserve;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder performance(Performance performance) {
            this.performance = performance;
            return this;
        }

        public Builder gate(int gate) {
            this.gate = gate;
            return this;
        }

        public Builder line(String line) {
            this.line = line;
            return this;
        }

        public Builder seat(int seat) {
            this.seat = seat;
            return this;
        }

        public Builder isReserve(String isReserve) {
            this.isReserve = isReserve;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public PerformanceSeatInfo build() {
            return new PerformanceSeatInfo(this);
        }


    }

}

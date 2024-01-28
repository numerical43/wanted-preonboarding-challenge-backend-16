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

    @Column(nullable = false)
    @Comment("생성일")
    private LocalDateTime createAt;

    @Column(nullable = false)
    @Comment("수정일")
    private LocalDateTime updatedAt;

    public Reservation(Builder builder) {
        this.id = builder.id;
        this.performance = builder.performance;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.round = builder.round;
        this.gate = builder.gate;
        this.line = builder.line;
        this.seat = builder.seat;
        this.createAt = builder.createAt;
        this.updatedAt = builder.updatedAt;
    }

    public static class Builder {
        private int id;
        private Performance performance;
        private String name;
        private String phoneNumber;
        private int round;
        private int gate;
        private char line;
        private int seat;
        private LocalDateTime createAt;
        private LocalDateTime updatedAt;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder performance(Performance performance) {
            this.performance = performance;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder round(int round) {
            this.round = round;
            return this;
        }

        public Builder gate(int gate) {
            this.gate = gate;
            return this;
        }

        public Builder line(char line) {
            this.line = line;
            return this;
        }

        public Builder seat(int seat) {
            this.seat = seat;
            return this;
        }

        public Builder createAt(LocalDateTime createAt) {
            this.createAt = createAt;
            return this;
        }

        public Builder updateAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Reservation builder() {
            return new Reservation(this);
        }

    }

}

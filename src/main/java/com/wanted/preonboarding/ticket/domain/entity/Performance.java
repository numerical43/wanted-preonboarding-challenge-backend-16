package com.wanted.preonboarding.ticket.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Performance {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Comment("공연/전시 ID")
    private UUID id;

    @Column(nullable = false)
    @Comment("공연/전시 이름")
    private String name;

    @Column(nullable = false)
    @Comment("가격")
    private int price;

    @Column(nullable = false)
    @Comment("회차")
    private int round;

    @Column(nullable = false)
    @Comment("NONE, CONCERT, EXHIBITION")
    private int type;

    @Column(nullable = false)
    @Comment("공연 일시")
    private Date startDate;

    @Column(nullable = false, name = "is_reserve", columnDefinition = "VARCHAR(255) default 'enable'")
    @Comment("예약 가능 여부")
    private String isReserve;

    @Column(nullable = false)
    @Comment("생성일")
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @Comment("수정일")
    private LocalDateTime updatedAt;

    public Performance(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.round = builder.round;
        this.type = builder.type;
        this.startDate = builder.startDate;
        this.isReserve = builder.isReserve;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static class Builder {
        private UUID id;
        private String name;
        private int price;
        private int round;
        private int type;
        private Date startDate;
        private String isReserve;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(int price) {
            this.price = price;
            return this;
        }

        public Builder round(int round) {
            this.round = round;
            return this;
        }

        public Builder type(int type) {
            this.type = type;
            return this;
        }

        public Builder startDate(Date startDate) {
            this.startDate = startDate;
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

        public Builder updatedAd(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Performance build() {
            return new Performance(this);
        }
    }

}

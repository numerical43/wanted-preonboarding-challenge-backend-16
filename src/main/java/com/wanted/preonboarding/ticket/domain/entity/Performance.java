package com.wanted.preonboarding.ticket.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id", "round"}))
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

    @CreationTimestamp
    @Column(nullable = false)
    @Comment("생성일")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    @Comment("수정일")
    private LocalDateTime updatedAt;

    @Builder
    public Performance(UUID id, String name, int price, int round, int type, Date startDate, String isReserve,
                       LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.round = round;
        this.type = type;
        this.startDate = startDate;
        this.isReserve = isReserve;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}

package com.wanted.preonboarding.ticket.domain.dto.response;

import com.wanted.preonboarding.ticket.domain.entity.Performance;
import com.wanted.preonboarding.ticket.domain.entity.PerformanceType;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
public class PerformanceListResponse {
    private UUID performanceId;
    private String performanceName;
    private String performanceType;
    private Date startDate;
    private String isReserve;

    public static PerformanceListResponse of(Performance perform) {
        return PerformanceListResponse.builder()
                .performanceId(perform.getId())
                .performanceName(perform.getName())
                .performanceType(convertCodeToName(perform.getType()))
                .startDate(perform.getStartDate())
                .isReserve(perform.getIsReserve())
                .build();
    }

    private static String convertCodeToName(int code){
        return Arrays.stream(PerformanceType.values()).filter(value -> value.getCategory() == code)
                .findFirst()
                .orElse(PerformanceType.NONE)
                .name();
    }
}

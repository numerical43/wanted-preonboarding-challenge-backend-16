package com.wanted.preonboarding.ticket.domain.dto.response;


import com.wanted.preonboarding.ticket.domain.entity.Performance;
import com.wanted.preonboarding.ticket.domain.entity.PerformanceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
public class PerformanceInfoResponse {
    private UUID performanceId;
    private String performanceName;
    private String performanceType;
    private Date startDate;
    private String isReserve;
    private int price;
    private int round;
    private String type;

    public static PerformanceInfoResponse of(Performance performance) {
        return PerformanceInfoResponse.builder()
                .performanceId(performance.getId())
                .performanceName(performance.getName())
                .performanceType(convertCodeToName(performance.getType()))
                .startDate(performance.getStartDate())
                .isReserve(performance.getIsReserve())
                .price(performance.getPrice())
                .round(performance.getRound())
                .type(convertCodeToName(performance.getType()))
                .build();
    }

    private static String convertCodeToName(int code){
        return Arrays.stream(PerformanceType.values()).filter(value -> value.getCategory() == code)
                .findFirst()
                .orElse(PerformanceType.NONE)
                .name();
    }
}

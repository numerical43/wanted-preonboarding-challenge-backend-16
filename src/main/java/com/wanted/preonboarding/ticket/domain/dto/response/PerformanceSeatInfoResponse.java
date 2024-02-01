package com.wanted.preonboarding.ticket.domain.dto.response;

import com.wanted.preonboarding.ticket.domain.entity.Performance;
import com.wanted.preonboarding.ticket.domain.entity.PerformanceSeatInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PerformanceSeatInfoResponse {
        private Long id;
        private int round;
        private int gate;
        private int line;
        private int seat;
        private String isReserve;

    public static PerformanceSeatInfoResponse of(PerformanceSeatInfo performanceSeatInfo) {
        return PerformanceSeatInfoResponse.builder()
                .id(performanceSeatInfo.getId())
                .round(performanceSeatInfo.getRound())
                .gate(performanceSeatInfo.getGate())
                .line(performanceSeatInfo.getGate())
                .seat(performanceSeatInfo.getSeat())
                .isReserve(performanceSeatInfo.getIsReserve())
                .build();
    }


}

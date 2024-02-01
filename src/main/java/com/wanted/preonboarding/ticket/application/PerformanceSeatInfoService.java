package com.wanted.preonboarding.ticket.application;

import com.wanted.preonboarding.ticket.domain.dto.response.PerformanceSeatInfoResponse;
import com.wanted.preonboarding.ticket.infrastructure.repository.PerformanceSeatInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PerformanceSeatInfoService {

    private final PerformanceSeatInfoRepository performanceSeatInfoRepository;

    public List<PerformanceSeatInfoResponse> getPerformanceSeatInfo(UUID performanceId) {

        return performanceSeatInfoRepository.findAllByPerformanceIdAndIsReserve(performanceId, "false")
                .orElseThrow(() -> new EntityNotFoundException(""))
                .stream()
                .map(PerformanceSeatInfoResponse::of)
                .toList();
    }
}

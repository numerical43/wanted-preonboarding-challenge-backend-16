package com.wanted.preonboarding.ticket.application;

import com.wanted.preonboarding.ticket.domain.dto.request.PerformanceInfoRequest;
import com.wanted.preonboarding.ticket.domain.dto.request.PerformanceListRequest;
import com.wanted.preonboarding.ticket.domain.dto.response.PerformanceInfoResponse;
import com.wanted.preonboarding.ticket.domain.dto.response.PerformanceListResponse;
import com.wanted.preonboarding.ticket.domain.entity.Performance;
import com.wanted.preonboarding.ticket.infrastructure.repository.PerformanceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PerformanceService {

    private final PerformanceRepository performanceRepository;

    @Transactional(readOnly = true)
    public Page<PerformanceListResponse> getPerformanceList(PerformanceListRequest request, Pageable pageable) {

        return performanceRepository.findAllByIsReserve(request.getIsReserve(), pageable).map(PerformanceListResponse::of);

    }

    @Transactional(readOnly = true)
    public PerformanceInfoResponse getPerformanceInfo(UUID id, PerformanceInfoRequest request) {

        Performance performance = performanceRepository.findByIdAndIsReserve(id, request.getIsReserve())
                .orElseThrow(() -> new EntityNotFoundException("존재하지않는 공연/전시회입니다."));

        return PerformanceInfoResponse.of(performance);

     }
}

package com.wanted.preonboarding.ticket.application;

import com.wanted.preonboarding.ticket.infrastructure.repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerformanceSeatInfoService {

    private final PerformanceRepository performanceRepository;


}

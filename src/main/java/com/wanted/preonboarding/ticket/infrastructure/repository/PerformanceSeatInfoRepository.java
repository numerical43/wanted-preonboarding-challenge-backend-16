package com.wanted.preonboarding.ticket.infrastructure.repository;

import com.wanted.preonboarding.ticket.domain.entity.PerformanceSeatInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PerformanceSeatInfoRepository extends JpaRepository<PerformanceSeatInfo, Long> {
    Optional<List<PerformanceSeatInfo>> findAllByPerformanceIdAndIsReserve(UUID performanceId, String isReserve);
}

package com.wanted.preonboarding.ticket.infrastructure.repository;

import com.wanted.preonboarding.ticket.domain.dto.response.PerformanceInfoResponse;
import com.wanted.preonboarding.ticket.domain.entity.Performance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PerformanceRepository extends JpaRepository<Performance, UUID> {

    List<Performance> findByIsReserve(String isReserve);

    Page<Performance> findAllByIsReserve(String isReserve, Pageable pageable);

    Optional<Performance> findByIdAndIsReserve(UUID id, String isReserve);

    Performance findByName(String name);

}

package com.wanted.preonboarding.ticket.presentation;

import com.wanted.preonboarding.core.domain.response.ResponseHandler;
import com.wanted.preonboarding.ticket.application.PerformanceService;
import com.wanted.preonboarding.ticket.domain.dto.request.PerformanceInfoRequest;
import com.wanted.preonboarding.ticket.domain.dto.request.PerformanceListRequest;
import com.wanted.preonboarding.ticket.domain.dto.response.PerformanceInfoResponse;
import com.wanted.preonboarding.ticket.domain.dto.response.PerformanceListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/performance")
public class PerformanceController {

    private final PerformanceService performanceService;

    // 공연*전시회 리스트 조회
    @GetMapping("/list")
    public ResponseEntity<ResponseHandler<Page<PerformanceListResponse>>> getPerformanceList(@RequestBody PerformanceListRequest performanceListRequest,
                                                                                             @PageableDefault(sort = "id", size = 20, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PerformanceListResponse> performancePage = performanceService.getPerformanceList(performanceListRequest, pageable);

        return ResponseEntity.ok().body(new ResponseHandler<>(
                HttpStatus.OK, "공연/전시 목록 조회 완료", performancePage));
    }

    // 공연*전시회 상세 조회
    @GetMapping
    public ResponseEntity<ResponseHandler<PerformanceInfoResponse>> getPerformanceInfo(@RequestParam("id") UUID id,
                                                                                       @RequestBody PerformanceInfoRequest performanceInfoRequest) {
        PerformanceInfoResponse performanceInfo = performanceService.getPerformanceInfo(id, performanceInfoRequest);

        return ResponseEntity.ok().body(new ResponseHandler<>(
                HttpStatus.OK, "공연/전시 상세 조회 완료", performanceInfo));

    }

}

package com.wanted.preonboarding.ticket.presentation;

import com.wanted.preonboarding.core.domain.response.ResponseHandler;
import com.wanted.preonboarding.ticket.application.PerformanceSeatInfoService;
import com.wanted.preonboarding.ticket.domain.dto.response.PerformanceSeatInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/seat")
@RequiredArgsConstructor
public class PerformanceSeatInfoController {

    private final PerformanceSeatInfoService performanceSeatInfoService;

    // 좌석 조회
    @GetMapping("/{performanceId}")
    public ResponseEntity<ResponseHandler<List<PerformanceSeatInfoResponse>>> getPerformanceSeatInfo(@PathVariable("performanceId") UUID performanceId) {
        List<PerformanceSeatInfoResponse> performanceSeatInfo = performanceSeatInfoService.getPerformanceSeatInfo(performanceId);

        return ResponseEntity.ok().body(new ResponseHandler<>(
                HttpStatus.OK, "공연/전시 좌석 조회 완료", performanceSeatInfo));

    }
}

package com.als.SMore.study.studyCRUD.controller;

import com.als.SMore.study.studyCRUD.DTO.StudyBoardDTO;
import com.als.SMore.study.studyCRUD.service.StudyBoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class StudyBoardController {

    private final StudyBoardService studyBoardService;

    /**
     * 모든 StudyBoard 엔티티를 조회하는 엔드포인트
     *
     * @return 모든 StudyBoard 엔티티의 DTO 리스트와 함께 OK 응답 반환
     */
    @GetMapping
    public ResponseEntity<List<StudyBoardDTO>> getAllStudyBoards() {
        return ResponseEntity.ok(studyBoardService.getAllStudyBoards());
    }

    /**
     * 특정 ID의 StudyBoard 엔티티를 조회하는 엔드포인트
     *
     * @param id 조회할 StudyBoard 엔티티의 ID
     * @return 조회된 StudyBoard 엔티티의 DTO와 함께 OK 응답 반환
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudyBoardDTO> getStudyBoardById(@PathVariable Long id) {
        return ResponseEntity.ok(studyBoardService.getStudyBoardById(id));
    }

    /**
     * StudyBoard 엔티티를 페이지 단위로 조회하는 엔드포인트
     *
     * @param page 페이지 번호 (1부터 시작)
     * @param size 페이지 크기 (한 페이지당 항목 수)
     * @return 요청된 페이지에 해당하는 StudyBoard 엔티티의 DTO 리스트와 함께 OK 응답 반환
     */
    @GetMapping("/page")
    public ResponseEntity<Page<StudyBoardDTO>> getStudyBoardsPage(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "9") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<StudyBoardDTO> studyBoardPage = studyBoardService.getStudyBoardsPage(pageable);
        return ResponseEntity.ok(studyBoardPage);
    }
}

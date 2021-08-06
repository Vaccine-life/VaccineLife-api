package com.vaccinelife.vaccinelifeapi.controller;


import com.vaccinelife.vaccinelifeapi.dto.CommentRequestDto;
import com.vaccinelife.vaccinelifeapi.dto.VacBoardPostRequestDto;
import com.vaccinelife.vaccinelifeapi.dto.VacBoardRequestDto;
import com.vaccinelife.vaccinelifeapi.dto.VacBoardSimRequestDto;
import com.vaccinelife.vaccinelifeapi.model.VacBoard;
import com.vaccinelife.vaccinelifeapi.service.CommentService;
import com.vaccinelife.vaccinelifeapi.service.VacBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vacBoard")

public class VacBoardController {
    private final VacBoardService vacBoardService;
    private final CommentService commentService;


    //    전체 게시판 조회
    @GetMapping("")
    public ResponseEntity<List<VacBoardSimRequestDto>> getSimpleVacBoard(){
        return ResponseEntity.ok().body(vacBoardService.getSimpleVacBoard());
    }
//
    //    탑 3
    @GetMapping("/topLike")
    public ResponseEntity<List<VacBoardSimRequestDto>> getTopList(){
        return ResponseEntity.ok().body(vacBoardService.getTopList());
    }

    //    상세 게시판 조회
    @GetMapping("/{vacBoardId}")
    public ResponseEntity<VacBoardRequestDto> getDetailVacBoard(@PathVariable Long vacBoardId) {
        vacBoardService.IpChecker(vacBoardId); // 방문자 체크 로직
        return  ResponseEntity.ok().body(vacBoardService.getDetailVacBoard(vacBoardId));
    }


    //    게시글 작성
    @PostMapping("")
    public ResponseEntity<Void> createVacBoard(@RequestBody VacBoardPostRequestDto requestDto) {
        vacBoardService.createVacBoard(requestDto);
        return ResponseEntity.created(URI.create("/api/vacBoard")).build();
    }

    //    게시글 수정
    @PutMapping("/{vacBoardId}")
    public ResponseEntity<Void> updateVacBoard(@PathVariable Long vacBoardId, @RequestBody VacBoardRequestDto requestDto) {
        vacBoardService.update(vacBoardId, requestDto);
        return ResponseEntity.ok().build();
    }

    //    게시글 삭제
    @DeleteMapping("/{vacBoardId}")
    public Long deleteVacBoard(@PathVariable Long vacBoardId) {
        vacBoardService.deleteVacBoard(vacBoardId);
        return vacBoardId;
    }

    //    댓글조회
    @GetMapping("/{vacBoardId}/comments")
    public ResponseEntity<List<CommentRequestDto>> getComment(@PathVariable Long vacBoardId) {
        commentService.getComment(vacBoardId);
        return  ResponseEntity.ok().body(commentService.getComment(vacBoardId));
    }

    //페이지 구현

    @GetMapping("/api/vacBoard/page")
    public Page<VacBoard> readVacBoard(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc

    ) {

        page = page - 1;
        return vacBoardService.readVacBoard(page , size, sortBy, isAsc);
    }


}


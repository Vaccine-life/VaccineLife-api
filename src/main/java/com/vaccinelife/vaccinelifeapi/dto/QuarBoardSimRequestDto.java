package com.vaccinelife.vaccinelifeapi.dto;

import com.vaccinelife.vaccinelifeapi.model.QuarBoard;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class QuarBoardSimRequestDto {
    private Long quarBoardId;
    private String title;
    private int likeCount;
    private int totalVisitors;
    private int commentCount;

    @Builder
    public QuarBoardSimRequestDto(Long quarBoardId, String title, int likeCount, int totalVisitors, int commentCount) {
        this.quarBoardId = quarBoardId;
        this.title = title;
        this.likeCount = likeCount;
        this.totalVisitors = totalVisitors;
        this.commentCount = commentCount;
    }
    public static QuarBoardSimRequestDto of(QuarBoard quarBoard){
        return QuarBoardSimRequestDto.builder()
                .quarBoardId(quarBoard.getId())
                .title(quarBoard.getTitle())
                .likeCount(quarBoard.getLikeCount())
                .totalVisitors(quarBoard.getTotalVisitors())
                .commentCount(quarBoard.getCommentCount())
                .build();
    }
    public static List<QuarBoardSimRequestDto> list(List<QuarBoard> boards){
        ArrayList<QuarBoardSimRequestDto> QuarBoardSimRequestDto = new ArrayList<>();
        for(QuarBoard quarBoard : boards){
            QuarBoardSimRequestDto.add(of(quarBoard));
        }
        return QuarBoardSimRequestDto;
    }
}

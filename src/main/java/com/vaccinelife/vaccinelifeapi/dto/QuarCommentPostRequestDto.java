package com.vaccinelife.vaccinelifeapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuarCommentPostRequestDto {

    private Long quarBoardId;
    private Long userId;
    private String quarcomment;
}

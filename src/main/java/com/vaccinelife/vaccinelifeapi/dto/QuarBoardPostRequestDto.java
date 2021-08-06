package com.vaccinelife.vaccinelifeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuarBoardPostRequestDto {
    private Long userId;
    private String title;
    private String contents;
}

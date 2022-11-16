package com.gamego.chatting.model.dto.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBoardDTO {

    private String title;

    private String contents;

/*
    private String imgUrl;
*/

    private String category;

    private String type;

    private String[] imgArray;
}

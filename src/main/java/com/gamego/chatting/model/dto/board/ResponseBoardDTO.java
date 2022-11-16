package com.gamego.chatting.model.dto.board;

import com.gamego.chatting.model.dto.ImageDTO;
import com.gamego.chatting.model.dto.LikeDTO;
import com.gamego.chatting.model.dto.MemberDTO;
import com.gamego.chatting.model.dto.UnlikeDTO;
import com.gamego.chatting.model.dto.reply.ReplyDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ResponseBoardDTO {

    private Long boardId;

    private String title;

    private String contents;

    private String category;

    private String type;

    private List<LikeDTO> likes;

    private List<UnlikeDTO> unlike;

    private MemberDTO memberDTO;

    private List<ReplyDTO> replyList;

    private List<ImageDTO> imageList;

    private int checkLikes;

    private int checkUnlike;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;
}

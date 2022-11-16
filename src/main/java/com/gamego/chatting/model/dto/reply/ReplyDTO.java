package com.gamego.chatting.model.dto.reply;

import com.gamego.chatting.model.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {

    private Long id;

    private String content;

    private MemberDTO memberDTO;

    private int checkMyReply;
    
    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;
}

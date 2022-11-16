package com.gamego.chatting.model.dto.chat;

import com.gamego.chatting.model.dto.MemberDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ResChatMessageDTO {

    private Long id;
    private String content;
    private MemberDTO member;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}

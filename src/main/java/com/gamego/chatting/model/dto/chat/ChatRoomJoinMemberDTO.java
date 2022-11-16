package com.gamego.chatting.model.dto.chat;

import com.gamego.chatting.model.dto.MemberDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChatRoomJoinMemberDTO {

    private Long id;
    private MemberDTO member;
    private ResChatRoomDTO chatRoom;
    private Long checkPoint;
}

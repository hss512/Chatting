package com.gamego.chatting.model.entity;

import com.gamego.chatting.model.dto.chat.ChatRoomJoinMemberDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class ChatRoomJoinMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chatRoomJoinMemberId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatRoomId")
    private ChatRoom chatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    private Long checkPoint;

    public ChatRoomJoinMemberDTO toDTO(){
        return ChatRoomJoinMemberDTO.builder()
                .id(this.id)
                .member(this.member.toDTO())
                .chatRoom(this.chatRoom.toDTO())
                .checkPoint(this.checkPoint)
                .build();
    }

    public void updateCheckPoint(Long checkPoint){
        this.checkPoint = checkPoint;
    }

    public void setChatRoom(ChatRoom chatRoom){
        this.chatRoom = chatRoom;
    }
}

package com.gamego.chatting.repository.chat;

import com.gamego.chatting.model.entity.ChatRoomJoinMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomJoinMemberRepository extends JpaRepository<ChatRoomJoinMember, Long> {

    ChatRoomJoinMember findChatRoomJoinMemberByChatRoomIdAndMemberId(Long chatRoomId, Long memberId);
}

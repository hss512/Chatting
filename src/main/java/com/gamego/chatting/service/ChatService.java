package com.gamego.chatting.service;

import com.gamego.chatting.model.dto.MemberDTO;
import com.gamego.chatting.model.dto.chat.ReqChatMessageDTO;
import com.gamego.chatting.model.dto.chat.ResChatMessageDTO;
import com.gamego.chatting.model.entity.ChatMessage;
import com.gamego.chatting.model.entity.ChatRoom;
import com.gamego.chatting.model.entity.ChatRoomJoinMember;
import com.gamego.chatting.model.entity.Member;
import com.gamego.chatting.repository.MemberRepository;
import com.gamego.chatting.repository.chat.ChatMessageRepository;
import com.gamego.chatting.repository.chat.ChatRoomJoinMemberRepository;
import com.gamego.chatting.repository.chat.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Log
@RequiredArgsConstructor
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;
    private final MemberRepository memberRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomJoinMemberRepository joinMemberRepository;

    public ResChatMessageDTO createChat(Long roomId, Long memberId, ReqChatMessageDTO dto) {

        ChatRoom chatRoom = chatRoomRepository.findById(roomId).get();

        Member member = memberRepository.findById(memberId).get();

        ChatMessage chat = ChatMessage.builder()
                .content(dto.getMessage())
                .member(member)
                .chatRoom(chatRoom)
                .build();

        ChatMessage savedChat = chatMessageRepository.save(chat);

        ChatRoomJoinMember chatRoomJoinMember = joinMemberRepository.findChatRoomJoinMemberByChatRoomIdAndMemberId(chatRoom.getId(), memberId);

        chatRoomJoinMember.updateCheckPoint(chat.getId());

        return savedChat.toDTO();
    }

    public MemberDTO chatRoomEnter(Long memberId) {

        Member member = memberRepository.findById(memberId).get();

        return member.toDTO();
    }
}

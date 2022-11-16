/*
package com.gamego.chatting.controller;

import com.gamego.chatting.dto.ReqChatMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ChattingController {

    private final SimpMessagingTemplate template;

    @MessageMapping("/notice/chat/room/{roomId}")  // /app/notice/chat/room/{roomId}
    public void chatNotice(@DestinationVariable String roomId){
        template.convertAndSend("/topic/chat/room/" + roomId, "메세지 알림 추가");
    }

    @MessageMapping("/chatting/room/{roomId}")
    public void chatting(@DestinationVariable String roomId, ReqChatMessageDTO dto, @Header("Authorization") String token, SimpMessageHeaderAccessor accessor){

        log.info("===========================================");

        log.info("채팅 api 호출");

        String jwt = token.substring(7, token.length());

        log.info("jwt = " + jwt);

        log.info("===========================================");

        String username = jwtService.extractUsername(jwt).get();

        log.info("username = " + username);

//         log.info("chatting.sessionID = " + accessor.getSessionId());

//         String username = SESSIONS.get(accessor.getSessionId());

        Member member = memberRepository.findByUsername(username).get();

        ResChatMessageDTO chatMessage = chatService.createChat(Long.parseLong(roomId), member.getId(), dto);

        template.convertAndSend("/topic/chat/room/" + roomId, new MessageDTO<>(1, chatMessage));
    }

    @MessageMapping("/chat/room/{roomId}/enter")
    public void chatRoomEnter(@DestinationVariable String roomId, ReqChatMessageDTO dto, @Header("Authorization") String token, SimpMessageHeaderAccessor accessor){

        log.info("===========================================");

        log.info("Enter_message = " , dto.getContent());

        log.info("ChatController.chatRoomEnter 호출");

        String jwt = token.substring(7, token.length());

        log.info("jwt = " + jwt);

        log.info("roomId = " + roomId);

        log.info("===========================================");

        String username = jwtService.extractUsername(jwt).get();

        log.info("username = " + username);

//         String username = SESSIONS.get(accessor.getSessionId());

        Member member = memberRepository.findByUsername(username).get();

        log.info("member.id = " + member.getId());

        MemberDTO memberDTO = chatService.chatRoomEnter(member.getId());

        template.convertAndSend("/topic/chat/room/" + roomId, new MessageDTO<>(2, memberDTO));
    }
}
*/

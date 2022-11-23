package com.gamego.chatting.repository.chat;

public interface ChatRoomCustomRepository {

    Long getNoticeCount(Long roomId, Long messageId);
}

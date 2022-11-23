package com.gamego.chatting.repository.chat;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

import com.gamego.chatting.model.entity.QChatMessage;
import com.gamego.chatting.model.entity.QChatRoom;

import static com.gamego.chatting.model.entity.QChatMessage.*;
import static com.gamego.chatting.model.entity.QChatRoom.*;

public class ChatRoomCustomRepositoryImpl implements ChatRoomCustomRepository{

    private final JPAQueryFactory queryFactory;

    public ChatRoomCustomRepositoryImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Long getNoticeCount(Long roomId, Long messageId) {

        return queryFactory.selectFrom(chatMessage)
                .where(chatMessage.chatRoom.id.eq(roomId))
                .orderBy(chatMessage.id.desc())
                .where(chatMessage.id.gt(messageId))
                .stream().count();
    }
}

package com.gamego.chatting.model.dto;

import com.gamego.chatting.model.entity.Gamer;
import com.gamego.chatting.model.entity.Member;
import com.gamego.chatting.model.entity.RegiTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class GamerDTO {

    @Getter
    @Setter
    public static class GamerRegistationDTO{
        private String gameUsername;
        private String introdution;
        private String game;
        private Member member;
        private RegiTime regiTime;
        private String hashTag;

        public Gamer toEntity(){
            return Gamer.builder()
                    .gameUsername(gameUsername)
                    .member(member)
                    .regiTime(regiTime)
                    .introdution(introdution)
                    .build();
        }

    }




}

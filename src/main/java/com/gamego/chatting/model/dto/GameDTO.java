package com.gamego.chatting.model.dto;

import com.gamego.chatting.model.entity.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class RegistrationDTO{
        private String name;
        private String content;

        public Game toEntity(){
            return Game.builder()
                    .name(name)
                    .content(content)
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ChangeStateDTO{
        private String name;
        private String content;
    }
}

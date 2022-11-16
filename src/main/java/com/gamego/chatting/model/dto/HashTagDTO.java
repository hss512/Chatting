package com.gamego.chatting.model.dto;

import com.gamego.chatting.model.entity.HashTag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HashTagDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class RegistrationDTO{
        private String name;

        public HashTag toEntity(){
            return HashTag.builder()
                    .name(name)
                    .build();
        }
    }
}

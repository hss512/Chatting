package com.gamego.chatting.service.jwt;

import java.util.Optional;

public interface JwtService {

    Optional<String> extractUsername(String accessToken);
}

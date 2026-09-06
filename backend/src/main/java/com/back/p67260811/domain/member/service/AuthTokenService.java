package com.back.p67260811.domain.member.service;

import com.back.p67260811.domain.member.entity.Member;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import standard.Ut;

@Service
class AuthTokenService {
    @Value("${custom.jwt.expireSeconds}")
    private long expireSeconds;
    @Value("${custom.jwt.secretPattern}")
    private String secretPattern;

    String genAccessToken(Member member) {

        return Ut.jwt.toString(secretPattern, expireSeconds,
                Map.of("id", member.getId(), "username", member.getUsername()));
    }

    Map<String, Object> payloadOrNull(String jwt) {
        Map<String, Object> payload = Ut.jwt.payloadOrNull(jwt, secretPattern);

        if (payload == null) {
            return null;
        }

        int id = (int) payload.get("id");
        String username = (String) payload.get("username");

        return Map.of("id", id, "username", username);
    }
}
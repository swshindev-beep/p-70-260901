package com.back.p67260811.domain.member.dto;

import com.back.p67260811.domain.member.entity.Member;

import java.time.LocalDateTime;

public record MemberDto(Integer id, LocalDateTime createDate, LocalDateTime modifyDate, String nickname) {
    public MemberDto(Member member) {
        this(member.getId(), member.getCreateDate(), member.getModifyDate(), member.getNickname());
    }
}
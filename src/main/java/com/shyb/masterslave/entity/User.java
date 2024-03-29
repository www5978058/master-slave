package com.shyb.masterslave.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {
    private Integer id;

    private String nickname;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
}

package com.github.jgzl.business.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDo implements Serializable {
    private Long id;
    private String username;
    private Short sex;
    private String nickname;
    private String comment;
    private List<UserDo> children;
}

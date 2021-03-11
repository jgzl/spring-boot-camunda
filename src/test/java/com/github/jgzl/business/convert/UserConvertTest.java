package com.github.jgzl.business.convert;

import com.github.jgzl.business.domain.UserDo;
import com.github.jgzl.business.vo.UserVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class UserConvertTest {

    private UserDo userDo;

    private Long level = 0L;

    @BeforeEach
    void setUp() {
        userDo = generateDo(userDo,1000L);
    }

    private UserDo generateDo(UserDo userDo, Long i) {
        if (level >= 1000L){
            return userDo;
        }
        level++;
        List<UserDo> children = Lists.newArrayList();
        children.add(generateDo(userDo,level));
        userDo = UserDo.builder()
                .id(i).username("测试用户名"+i).nickname("测试用户名别名"+i).comment("备注信息"+i).children(children).build();
        return userDo;
    }

    @Test
    void convert() {
        log.info("userDo:{}",userDo);
        UserVo userVo = UserConvert.INSTANCE.convert(userDo);
        log.info("userVo:{}",userVo);
    }
}
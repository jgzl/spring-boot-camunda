package com.github.jgzl.business.convert;

import com.github.jgzl.business.domain.UserDo;
import com.github.jgzl.business.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);
    UserVo convert(UserDo userDo);
}

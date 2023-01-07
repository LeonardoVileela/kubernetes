package com.springcloud.msvc.users.mapper.mapping;

import com.springcloud.msvc.users.domain.User;
import com.springcloud.msvc.users.mapper.requests.UserPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    User toUser(UserPostRequestBody userPostRequestBody);


}

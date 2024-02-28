package com.abujava.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

/**
 * This class is not documented :(
 *
 * @author Muhammad Muminov
 * @since 8/29/2023
 */
@Component
public class UserRedisSerializer extends GenericJackson2JsonRedisSerializer {

    public UserRedisSerializer(ObjectMapper mapper) {
        super(mapper);
    }

    @Override
    public Object deserialize(byte[] source) throws SerializationException {
        return super.deserialize(source, User.class);
    }
}

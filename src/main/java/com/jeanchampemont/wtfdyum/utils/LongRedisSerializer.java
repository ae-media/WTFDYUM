/*
 * Copyright (C) 2015, 2016 WTFDYUM
 *
 * This file is part of the WTFDYUM project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jeanchampemont.wtfdyum.utils;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

public class LongRedisSerializer implements RedisSerializer<Long> {

    public LongRedisSerializer() {
        this(Charset.forName("UTF8"));
    }

    public LongRedisSerializer(final Charset charset) {
        this.charset = charset;
    }

    private final Charset charset;

    @Override
    public Long deserialize(final byte[] bytes) throws SerializationException {
        return (bytes == null ? null : Long.parseLong(new String(bytes, charset)));
    }

    @Override
    public byte[] serialize(final Long val) throws SerializationException {
        return (val == null ? null : val.toString().getBytes(charset));
    }
}

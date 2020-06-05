/*
 * Copyright 2012-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.clarkii.core.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Title: IDGenerator
 * Description:
 *
 * @groups: Clarkii Study Group
 * @author: fangdelong
 * @create: 2020/6/4 14:05
 */
public class IDGenerator {
    private static Map<Class, AtomicLong> idMap = new HashMap();

    public void syncId(Class clazz, Long cid) {
        idMap.put(clazz, new AtomicLong(cid));
    }

    public long next(Class clazz) {
        return idMap.get(clazz).addAndGet(1);
    }
}

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
package org.clarkii.core.bean;

import lombok.Data;

/**
 * Title: Attributes
 * Description:
 *
 * @groups: Clarkii Study Group
 * @author: fangdelong
 * @create: 2020/5/27 16:52
 */
@Data
public class Attributes {
    private Attribute[] attributes;

    public static class Attribute {
        private String name;
        private String value;
        private String type;
    }

    public int length() {
        return attributes == null ? 0 : attributes.length;
    }
}
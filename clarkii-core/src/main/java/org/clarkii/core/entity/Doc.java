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
package org.clarkii.core.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Title: Doc
 * Description:
 *
 * @groups: Clarkii Study Group
 * @author: fangdelong
 * @create: 2020/5/27 16:27
 */
@Data
public class Doc implements Serializable {
    private String id;
    private String docId;
    private Serializable value;
    private String condition;
    private Timestamp startTime;
    private Timestamp endTime;
    private long versionId;
}
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
package org.clarkii.core.process;

/**
 * Title: ServerUpProcessor
 * Description:
 *
 *  If run in cluster mode:
 *    Do following asynchronously
 *    1. Join the cluster
 *    2. The Leader election
 *    3. If run as follow, kickoff synchronizer
 *    4. If run as leader, kickoff sweeper
 *
 *  If run in stand alone mode:
 *    1. Kickoff sweeper
 *
 * @groups: Clarkii Study Group
 * @author: fangdelong
 * @create: 2020/6/5 15:15
 */
public class ServerUpProcessor implements Processor {
    @Override
    public void process() {

    }
}

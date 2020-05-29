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
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Title: Condition
 * Description:
 *
 * @groups: Clarkii Study Group
 * @author: fangdelong
 * @create: 2020/5/27 16:53
 */
@Data
public class Condition<L, R> {
    L left;
    Operator operator;
    R[] right;

    private static List<Operator> pos = Arrays.asList(new Operator[]{Operator.eq, Operator.ne, Operator.gt, Operator.gte, Operator.lt, Operator.lte, Operator.in, Operator.bt});

    private Condition(L left, Operator operator, R... right) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public static Condition of() {
        return new NoCondition();
    }

    public static Condition of(String attr, Operator operator, Comparable... values) {
        return new LeafCondition(attr, operator, values);
    }

    public Condition or(Condition other) {
        Assert.notNull(other, "Argument is required; it must not be null");

        if (this instanceof NoCondition) {
            return this;
        }

        if (other instanceof NoCondition) {
            return other;
        }

        return new Condition(this, Operator.or, other);
    }

    public Condition or(String attr, Operator operator, Comparable... values) {
        Assert.hasText(attr, "Argument attr, it must not be null");
        Assert.isTrue(pos.contains(operator), "Argument operator, it must have a valid input");
        Assert.notEmpty(values, "Argument values, it must must not be empty");

        if (this instanceof NoCondition) {
            return this;
        }

        return new Condition(this, Operator.or, new LeafCondition(attr, operator, values));
    }

    public Condition and(Condition other) {
        Assert.notNull(other, "Argument is required; it must not be null");

        if (this instanceof NoCondition) {
            return other;
        }

        if (other instanceof NoCondition) {
            return this;
        }

        return new Condition(this, Operator.and, other);
    }

    public Condition and(String attr, Operator operator, Comparable... values) {
        Assert.hasText(attr, "Argument attr, it must not be null");
        Assert.isTrue(pos.contains(operator), "Argument operator, it must have a valid input");
        Assert.notEmpty(values, "Argument values, it must must not be empty");

        if (this instanceof NoCondition) {
            return new LeafCondition(attr, operator, values);
        }

        return new Condition(this, Operator.and, new LeafCondition(attr, operator, values));
    }

    public Condition negate() {
        return new Condition(this, Operator.not, null);
    }

    public String toJson() {
        // TODO
        return null;
    }

    public static Condition parse(String json) {
        // TODO
        return null;
    }

    private static class NoCondition extends Condition {
        private NoCondition() {
            super(null, null, null);
        }
    }

    private static class LeafCondition extends Condition<String, Comparable> {
        private LeafCondition(String attr, Operator operator, Comparable... values) {
            super(attr, operator, values);
        }

        public String getAttr() {
            return left;
        }

        public Operator getOperator() {
            return operator;
        }

        public Comparable[] getValues() {
            return right;
        }
    }

}

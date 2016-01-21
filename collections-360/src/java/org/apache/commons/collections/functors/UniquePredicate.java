/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.Predicate;

/**
 * Predicate implementation that returns true the first time an object is
 * passed into the predicate.
 *
 * @since Commons Collections 3.0
 * @version $Revision: 814997 $ $Date: 2009-09-15 07:29:56 +0200 (mar., 15 sept. 2009) $
 *
 * @author Stephen Colebourne
 */
public final class UniquePredicate<T> implements Predicate<T>, Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = -3319417438027438040L;

    /** The set of previously seen objects */
    private final Set<T> iSet = new HashSet<T>();

    /**
     * Factory to create the predicate.
     *
     * @return the predicate
     * @throws IllegalArgumentException if the predicate is null
     */
    public static <E> Predicate<E> getInstance() {
        return new UniquePredicate<E>();
    }

    /**
     * Constructor that performs no validation.
     * Use <code>getInstance</code> if you want that.
     */
    public UniquePredicate() {
        super();
    }

    /**
     * Evaluates the predicate returning true if the input object hasn't been
     * received yet.
     *
     * @param object  the input object
     * @return true if this is the first time the object is seen
     */
    public boolean evaluate(T object) {
        return iSet.add(object);
    }

}

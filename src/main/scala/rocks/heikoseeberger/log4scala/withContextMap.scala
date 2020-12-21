/*
 * Copyright 2020 Heiko Seeberger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rocks.heikoseeberger.log4scala

import org.apache.logging.log4j.ThreadContext
import scala.jdk.CollectionConverters.{ IterableHasAsJava, MapHasAsJava }

def withContextMap[A](keyAndValue: (String, String), moreKeyAndValue: (String, String)*)(chunk: => A): Unit =
  val map = moreKeyAndValue.toMap + keyAndValue
  try
    ThreadContext.putAll(map.asJava)
    chunk
  finally 
    ThreadContext.removeAll(map.keys.asJava)

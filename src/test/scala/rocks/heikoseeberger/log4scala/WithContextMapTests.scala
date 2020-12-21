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

import munit.FunSuite

final class WithContextMapTests extends FunSuite:

  private inline val Message = "message"
  private inline val Key1    = "key-1"
  private inline val Key2    = "key-2"
  private inline val Value1  = "value-1"
  private inline val Value2  = "value-2"

  test("withContextMap") {
    val out = 
      withOut {
        withContextMap(Key1 -> Value1, Key2 -> Value2) {
          Logger(getClass).info(Message)
        }
      }
    assertEquals(out.toString, s"INFO  ${getClass.getSimpleName} - $Message$Value1$Value2\n")
  }

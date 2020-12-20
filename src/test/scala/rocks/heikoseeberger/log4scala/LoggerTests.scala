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
import org.mockito.Mockito.{ mock, never, verify, when }
import org.apache.logging.log4j.{ Logger => Underlying }

final class LoggerTests extends FunSuite:
  
  private inline val Message  = "message"
  private inline val Message2 = "message2"
  
  test("info with message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isInfoEnabled).thenReturn(true)
    logger.info(Message)
    verify(underlying).info(Message)

    when(underlying.isInfoEnabled).thenReturn(false)
    logger.info(Message2)
    verify(underlying, never).info(Message2)
  }

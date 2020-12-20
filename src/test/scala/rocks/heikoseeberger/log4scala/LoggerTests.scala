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

import java.io.{ByteArrayOutputStream, PrintStream}
import java.nio.file.{Files, Paths}
import munit.FunSuite
import org.mockito.Mockito.{mock, never, verify, when}
import org.apache.logging.log4j.{MarkerManager, Logger => Underlying}

final class LoggerTests extends FunSuite:
  
  private inline val Message = "message"
  
  private inline val Message2 = "message2"
  
  private val t = new Exception("error")
  
  private val marker = MarkerManager.getMarker("marker")

  test("fatal") {
    val out = withOut { Logger(getClass).fatal(Message) }
    assertEquals(out.toString, s"FATAL ${getClass.getSimpleName} - $Message\n")
  }

  test("fatal with message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isFatalEnabled).thenReturn(true)
    logger.fatal(Message)
    verify(underlying).fatal(Message)

    when(underlying.isFatalEnabled).thenReturn(false)
    logger.fatal(Message2)
    verify(underlying, never).fatal(Message2)
  }

  test("fatal with message and Throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isFatalEnabled).thenReturn(true)
    logger.fatal(Message, t)
    verify(underlying).fatal(Message, t)

    when(underlying.isFatalEnabled).thenReturn(false)
    logger.fatal(Message2, t)
    verify(underlying, never).fatal(Message2, t)
  }

  test("fatal with marker and message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isFatalEnabled(marker)).thenReturn(true)
    logger.fatal(marker, Message)
    verify(underlying).fatal(marker, Message)

    when(underlying.isFatalEnabled(marker)).thenReturn(false)
    logger.fatal(marker, Message2)
    verify(underlying, never).fatal(marker, Message2)
  }

  test("fatal with marker, message and throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isFatalEnabled(marker)).thenReturn(true)
    logger.fatal(marker, Message, t)
    verify(underlying).fatal(marker, Message, t)

    when(underlying.isFatalEnabled(marker)).thenReturn(false)
    logger.fatal(marker, Message2, t)
    verify(underlying, never).fatal(marker, Message2, t)
  }

  test("error") {
    val out = withOut { Logger(getClass).error(Message) }
    assertEquals(out.toString, s"ERROR ${getClass.getSimpleName} - $Message\n")
  }

  test("error with message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isErrorEnabled).thenReturn(true)
    logger.error(Message)
    verify(underlying).error(Message)

    when(underlying.isErrorEnabled).thenReturn(false)
    logger.error(Message2)
    verify(underlying, never).error(Message2)
  }

  test("error with message and Throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isErrorEnabled).thenReturn(true)
    logger.error(Message, t)
    verify(underlying).error(Message, t)

    when(underlying.isErrorEnabled).thenReturn(false)
    logger.error(Message2, t)
    verify(underlying, never).error(Message2, t)
  }

  test("error with marker and message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isErrorEnabled(marker)).thenReturn(true)
    logger.error(marker, Message)
    verify(underlying).error(marker, Message)

    when(underlying.isErrorEnabled(marker)).thenReturn(false)
    logger.error(marker, Message2)
    verify(underlying, never).error(marker, Message2)
  }

  test("error with marker, message and throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isErrorEnabled(marker)).thenReturn(true)
    logger.error(marker, Message, t)
    verify(underlying).error(marker, Message, t)

    when(underlying.isErrorEnabled(marker)).thenReturn(false)
    logger.error(marker, Message2, t)
    verify(underlying, never).error(marker, Message2, t)
  }
  
  test("warn") {
    val out = withOut { Logger(getClass).warn(Message) }
    assertEquals(out.toString, s"WARN  ${getClass.getSimpleName} - $Message\n")
  }
  
  test("warn with message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isWarnEnabled).thenReturn(true)
    logger.warn(Message)
    verify(underlying).warn(Message)

    when(underlying.isWarnEnabled).thenReturn(false)
    logger.warn(Message2)
    verify(underlying, never).warn(Message2)
  }

  test("warn with message and Throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isWarnEnabled).thenReturn(true)
    logger.warn(Message, t)
    verify(underlying).warn(Message, t)

    when(underlying.isWarnEnabled).thenReturn(false)
    logger.warn(Message2, t)
    verify(underlying, never).warn(Message2, t)
  }

  test("warn with marker and message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isWarnEnabled(marker)).thenReturn(true)
    logger.warn(marker, Message)
    verify(underlying).warn(marker, Message)

    when(underlying.isWarnEnabled(marker)).thenReturn(false)
    logger.warn(marker, Message2)
    verify(underlying, never).warn(marker, Message2)
  }

  test("warn with marker, message and throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isWarnEnabled(marker)).thenReturn(true)
    logger.warn(marker, Message, t)
    verify(underlying).warn(marker, Message, t)

    when(underlying.isWarnEnabled(marker)).thenReturn(false)
    logger.warn(marker, Message2, t)
    verify(underlying, never).warn(marker, Message2, t)
  }

  test("info") {
    val out = withOut { Logger(getClass).info(Message) }
    assertEquals(out.toString, s"INFO  ${getClass.getSimpleName} - $Message\n")
  }

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

  test("info with message and Throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isInfoEnabled).thenReturn(true)
    logger.info(Message, t)
    verify(underlying).info(Message, t)

    when(underlying.isInfoEnabled).thenReturn(false)
    logger.info(Message2, t)
    verify(underlying, never).info(Message2, t)
  }

  test("info with marker and message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isInfoEnabled(marker)).thenReturn(true)
    logger.info(marker, Message)
    verify(underlying).info(marker, Message)

    when(underlying.isInfoEnabled(marker)).thenReturn(false)
    logger.info(marker, Message2)
    verify(underlying, never).info(marker, Message2)
  }

  test("info with marker, message and throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isInfoEnabled(marker)).thenReturn(true)
    logger.info(marker, Message, t)
    verify(underlying).info(marker, Message, t)

    when(underlying.isInfoEnabled(marker)).thenReturn(false)
    logger.info(marker, Message2, t)
    verify(underlying, never).info(marker, Message2, t)
  }

  test("debug") {
    val out = withOut { Logger(getClass).debug(Message) }
    assertEquals(out.toString, s"DEBUG ${getClass.getSimpleName} - $Message\n")
  }

  test("debug with message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isDebugEnabled).thenReturn(true)
    logger.debug(Message)
    verify(underlying).debug(Message)

    when(underlying.isDebugEnabled).thenReturn(false)
    logger.debug(Message2)
    verify(underlying, never).debug(Message2)
  }

  test("debug with message and Throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isDebugEnabled).thenReturn(true)
    logger.debug(Message, t)
    verify(underlying).debug(Message, t)

    when(underlying.isDebugEnabled).thenReturn(false)
    logger.debug(Message2, t)
    verify(underlying, never).debug(Message2, t)
  }

  test("debug with marker and message") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isDebugEnabled(marker)).thenReturn(true)
    logger.debug(marker, Message)
    verify(underlying).debug(marker, Message)

    when(underlying.isDebugEnabled(marker)).thenReturn(false)
    logger.debug(marker, Message2)
    verify(underlying, never).debug(marker, Message2)
  }

  test("debug with marker, message and throwable") {
    val underlying = mock(classOf[Underlying])
    val logger     = new Logger(underlying)

    when(underlying.isDebugEnabled(marker)).thenReturn(true)
    logger.debug(marker, Message, t)
    verify(underlying).debug(marker, Message, t)

    when(underlying.isDebugEnabled(marker)).thenReturn(false)
    logger.debug(marker, Message2, t)
    verify(underlying, never).debug(marker, Message2, t)
  }

  private def withOut(chunk: => Unit) =
    val old = System.out
    val out = ByteArrayOutputStream()
    try {
      System.setOut(PrintStream(out))
      chunk
      out
    } finally System.setOut(old)

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

import org.apache.logging.log4j.{ Logger => UnderlyingLog4jLogger }
import org.slf4j.{ Logger => UnderlyingSlf4jLogger }

type Underlying = UnderlyingLog4jLogger | UnderlyingSlf4jLogger

type Logger[U <: Underlying] =
  U match
    case UnderlyingLog4jLogger => Log4jLogger
    case UnderlyingSlf4jLogger => Slf4jLogger

object Logger:

  /**
   * Returns a [[Logger]] wrapping the given underlying logger (Log4j or SLF4J).
   * @param u The underlying logger (Log4j or SLF4J).
   * @return The [[Logger]] for the given underlying logger.
   */
  def apply[U <: Underlying](u: U): Logger[U] =
    u match {
      case log4j: UnderlyingLog4jLogger => Log4jLogger(log4j)
      case slf4j: UnderlyingSlf4jLogger => Slf4jLogger(slf4j)
    }

//  /**
//   * Returns a [[Logger]] using the fully qualified name of the given class as name.
//   * @param `class` The class whose name should be used as name; if null it will default to the calling class.
//   * @return The [[Logger]] for the given class.
//   */
//  def apply[U <: Log4jLogger | Slf4jLogger](`class`: Class[_]): Logger[U] =
//    ??? //new Logger(LogManager.getLogger(`class`))
//
//  /**
//   * Returns a [[Logger]] with the given name.
//   * @param name The logger name. If null the name of the calling class will be used.
//   * @return The [[Logger]] for the given name.
//   */
//  def apply[U <: Log4jLogger | Slf4jLogger](name: String): Logger[U] =
//    ??? //new Logger(LogManager.getLogger(name))

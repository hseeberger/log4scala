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

import org.apache.logging.log4j.{ LogManager, Logger => Underlying, Marker }

object Logger:

  /**
   * Returns a [[Logger]] using the fully qualified name of the given class as name.
   * @param `class` The class whose name should be used as name; if null it will default to the calling class.
   * @return The [[Logger]] for the given class.
   */
  def apply(`class`: Class[_]): Logger =
    new Logger(LogManager.getLogger(`class`))

  /**
   * Returns a [[Logger]] with the given name.
   * @param name The logger name. If null the name of the calling class will be used.
   * @return The [[Logger]] for the given name.
   */
  def apply(name: String): Logger =
    new Logger(LogManager.getLogger(name))

final class Logger private[log4scala] (u: Underlying):

  /**
   * Logs at `INFO` level, if enabled.
   * @param message Log message; only constructed, if `INFO` level enabled. 
   */
  inline def info(message: => String): Unit =
    if (u.isInfoEnabled) u.info(message)

  /**
   * Logs at `INFO` level, if enabled.
   * @param message Log message; only constructed, if `INFO` level enabled.
   * @param t `Throwable` to be logged
   */
  inline def info(message: => String, t: Throwable): Unit =
    if (u.isInfoEnabled) u.info(message, t)

  /**
   * Logs at `INFO` level, if enabled.
   * @param marker `Marker` for this log statement.
   * @param message Log message; only constructed, if `INFO` level enabled.
   */
  inline def info(marker: Marker, message: => String): Unit =
    if (u.isInfoEnabled(marker)) u.info(marker, message)

  /**
   * Logs at `INFO` level, if enabled.
   * @param marker `Marker` for this log statement.
   * @param message Log message; only constructed, if `INFO` level enabled.
   * @param t `Throwable` to be logged.
   */
  inline def info(marker: Marker, message: => String, t: Throwable): Unit =
    if (u.isInfoEnabled(marker)) u.info(marker, message, t)

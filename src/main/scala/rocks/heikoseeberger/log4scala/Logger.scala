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
   * Logs at `FATAL` level, if enabled.
   * @param message Log message; only constructed, if `FATAL` level enabled.
   */
  inline def fatal(message: => String): Unit =
    if (u.isFatalEnabled) u.fatal(message)

  /**
   * Logs at `FATAL` level, if enabled.
   * @param message Log message; only constructed, if `FATAL` level enabled.
   * @param t `Throwable` to be logged
   */
  inline def fatal(message: => String, t: Throwable): Unit =
    if (u.isFatalEnabled) u.fatal(message, t)

  /**
   * Logs at `FATAL` level, if enabled.
   * @param marker `Marker` for this log statement.
   * @param message Log message; only constructed, if `FATAL` level enabled.
   */
  inline def fatal(marker: Marker, message: => String): Unit =
    if (u.isFatalEnabled(marker)) u.fatal(marker, message)

  /**
   * Logs at `FATAL` level, if enabled.
   * @param marker `Marker` for this log statement.
   * @param message Log message; only constructed, if `FATAL` level enabled.
   * @param t `Throwable` to be logged.
   */
  inline def fatal(marker: Marker, message: => String, t: Throwable): Unit =
    if (u.isFatalEnabled(marker)) u.fatal(marker, message, t)

  /**
   * Logs at `ERROR` level, if enabled.
   * @param message Log message; only constructed, if `ERROR` level enabled.
   */
  inline def error(message: => String): Unit =
    if (u.isErrorEnabled) u.error(message)

  /**
   * Logs at `ERROR` level, if enabled.
   * @param message Log message; only constructed, if `ERROR` level enabled.
   * @param t `Throwable` to be logged
   */
  inline def error(message: => String, t: Throwable): Unit =
    if (u.isErrorEnabled) u.error(message, t)

  /**
   * Logs at `ERROR` level, if enabled.
   * @param marker `Marker` for this log statement.
   * @param message Log message; only constructed, if `ERROR` level enabled.
   */
  inline def error(marker: Marker, message: => String): Unit =
    if (u.isErrorEnabled(marker)) u.error(marker, message)

  /**
   * Logs at `ERROR` level, if enabled.
   * @param marker `Marker` for this log statement.
   * @param message Log message; only constructed, if `ERROR` level enabled.
   * @param t `Throwable` to be logged.
   */
  inline def error(marker: Marker, message: => String, t: Throwable): Unit =
    if (u.isErrorEnabled(marker)) u.error(marker, message, t)

  /**
   * Logs at `WARN` level, if enabled.
   * @param message Log message; only constructed, if `WARN` level enabled.
   */
  inline def warn(message: => String): Unit =
    if (u.isWarnEnabled) u.warn(message)

  /**
   * Logs at `WARN` level, if enabled.
   * @param message Log message; only constructed, if `WARN` level enabled.
   * @param t `Throwable` to be logged
   */
  inline def warn(message: => String, t: Throwable): Unit =
    if (u.isWarnEnabled) u.warn(message, t)

  /**
   * Logs at `WARN` level, if enabled.
   * @param marker `Marker` for this log statement.
   * @param message Log message; only constructed, if `WARN` level enabled.
   */
  inline def warn(marker: Marker, message: => String): Unit =
    if (u.isWarnEnabled(marker)) u.warn(marker, message)

  /**
   * Logs at `WARN` level, if enabled.
   * @param marker `Marker` for this log statement.
   * @param message Log message; only constructed, if `WARN` level enabled.
   * @param t `Throwable` to be logged.
   */
  inline def warn(marker: Marker, message: => String, t: Throwable): Unit =
    if (u.isWarnEnabled(marker)) u.warn(marker, message, t)

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

  /**
   * Logs at `DEBUG` level, if enabled.
   * @param message Log message; only constructed, if `DEBUG` level enabled.
   */
  inline def debug(message: => String): Unit =
    if (u.isDebugEnabled) u.debug(message)

  /**
   * Logs at `DEBUG` level, if enabled.
   * @param message Log message; only constructed, if `DEBUG` level enabled.
   * @param t `Throwable` to be logged
   */
  inline def debug(message: => String, t: Throwable): Unit =
    if (u.isDebugEnabled) u.debug(message, t)

  /**
   * Logs at `DEBUG` level, if enabled.
   * @param marker `Marker` for this log statement.
   * @param message Log message; only constructed, if `DEBUG` level enabled.
   */
  inline def debug(marker: Marker, message: => String): Unit =
    if (u.isDebugEnabled(marker)) u.debug(marker, message)

  /**
   * Logs at `DEBUG` level, if enabled.
   * @param marker `Marker` for this log statement.
   * @param message Log message; only constructed, if `DEBUG` level enabled.
   * @param t `Throwable` to be logged.
   */
  inline def debug(marker: Marker, message: => String, t: Throwable): Unit =
    if (u.isDebugEnabled(marker)) u.debug(marker, message, t)

  /**
   * Logs at `TRACE` level, if enabled.
   * @param message Log message; only constructed, if `TRACE` level enabled.
   */
  inline def trace(message: => String): Unit =
    if (u.isTraceEnabled) u.trace(message)

  /**
   * Logs at `TRACE` level, if enabled.
   * @param message Log message; only constructed, if `TRACE` level enabled.
   * @param t `Throwable` to be logged
   */
  inline def trace(message: => String, t: Throwable): Unit =
    if (u.isTraceEnabled) u.trace(message, t)

  /**
   * Logs at `TRACE` level, if enabled.
   * @param marker `Marker` for this log statement.
   * @param message Log message; only constructed, if `TRACE` level enabled.
   */
  inline def trace(marker: Marker, message: => String): Unit =
    if (u.isTraceEnabled(marker)) u.trace(marker, message)

  /**
   * Logs at `TRACE` level, if enabled.
   * @param marker `Marker` for this log statement.
   * @param message Log message; only constructed, if `TRACE` level enabled.
   * @param t `Throwable` to be logged.
   */
  inline def trace(marker: Marker, message: => String, t: Throwable): Unit =
    if (u.isTraceEnabled(marker)) u.trace(marker, message, t)

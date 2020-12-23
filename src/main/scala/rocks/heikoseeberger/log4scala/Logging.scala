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

private transparent trait Logging[U <: Underlying]:
  
  /**
   * [[Logger]] named according to the class or object mixed into.
   * If mixed into an object, the trailing "$" is stripped from the name, i.e. the same name is used as for the companion class.
   * @return The [[Logger]] named according to the class or object mixed into.
   */
  final protected val logger: Logger[U] =
    Logger(createUnderlying(loggerName))

  /**
   * Factory for creating an underlying logger with the given name.
   * @param name The name for the underlying logger to be created.
   * @return The underlying logger with the given name.
   */
  protected def createUnderlying(name: String): U

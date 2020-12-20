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

/**
 * Mixin providing a `Logger`.
 */
transparent trait Logging:

  /**
   * Logger initialized with the name of the class mixed into. If mixed into an object, the 
   * trailing "$" is stripped from the name, i.e. the same name used as for the companion class.
   */
  protected val logger: Logger =
    val name = 
      val className = getClass.getName
      if (className.endsWith("$"))
        className.init
      else
        className
    Logger(name)

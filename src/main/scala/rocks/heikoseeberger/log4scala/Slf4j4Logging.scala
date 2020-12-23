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

import org.slf4j.{ LoggerFactory, Logger => Underlying }

/**
 * Mixin providing a `Logger` wrapping an underlying SLF4J logger.
 */
transparent trait Slf4j4Logging extends Logging[Underlying]:

  final override protected def createUnderlying(name: String): Underlying =
    LoggerFactory.getLogger(name)

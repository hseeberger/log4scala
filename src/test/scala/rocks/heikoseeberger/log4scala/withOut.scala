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

import java.io.{ ByteArrayOutputStream, PrintStream }

private def withOut(chunk: => Unit) =
  val old = System.out
  val out = ByteArrayOutputStream()
  try {
    System.setOut(PrintStream(out))
    chunk
    out
  } finally 
    System.setOut(old)

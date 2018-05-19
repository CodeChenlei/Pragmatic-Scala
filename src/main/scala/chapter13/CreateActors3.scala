/*
 * Copyright 2018 pragmatic-scala.reactiveplatform.xyz
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

package chapter13

import akka.actor._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object CreateActors3 extends App {
  val system = ActorSystem("sample")

  val depp = system.actorOf(Props[HollywoodActor])
  val hanks = system.actorOf(Props[HollywoodActor])

  // #snip
  depp ! "Wonka"
  hanks ! "Gump"

  Thread.sleep(100)

  depp ! "Sparrow"
  hanks ! "Phillips"
  // #snip

  println(s"Calling from ${Thread.currentThread}")
  val terminateFuture = system.terminate()
  Await.ready(terminateFuture, Duration.Inf)
}

package sample


import akka.actor.{ ActorRef, ActorSystem, Props, Actor, Inbox }


case class Greeting(message: String)

class Greeter extends Actor {
  def receive = {
    case Greeting(who)           =>  println(s"hello, $who")
  }
}

object HelloWorldScala extends App {

  // Create the 'helloakka' actor system
  val system = ActorSystem("helloakka")

  // Create the 'greeter' actor
  val greeter = system.actorOf(Props[Greeter], "greeter")

  // Send the 'greeter' the greeting
  greeter ! Greeting("akka")


}

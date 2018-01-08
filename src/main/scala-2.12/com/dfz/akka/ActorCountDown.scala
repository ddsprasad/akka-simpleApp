package com.dfz.akka

import akka.actor.{Props, ActorSystem, ActorRef, Actor}

/**
  * Created by prasad on 1/7/2018.
  */
object ActorCountDown extends App{

  case class StartCountig(n: Int, other:ActorRef)
  case class CountDown(n:Int)
  class CountDownActor extends Actor {

    def receive = {
      case StartCountig(n,other) =>
        println(n)
        other ! CountDown(n-1)
      case CountDown(n) =>
        if(n>0){
          println(n)
          sender ! CountDown(n-1)
        } else {
          context.system.terminate()
        }
    }

    def foo = println("Normal Method")
  }

  val system = ActorSystem("SimpleSystem")
  val actor1  = system.actorOf(Props[CountDownActor],"SampleActor1")
  val actor2  = system.actorOf(Props[CountDownActor],"SampleActor2")

  actor1 ! StartCountig(10,actor2)





}

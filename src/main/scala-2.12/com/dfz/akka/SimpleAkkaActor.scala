package com.dfz.akka

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by prasad on 1/7/2018.
  */
object SimpleAkkaActor extends App{

  class SampleAkkaActor extends Actor {

    def receive ={
      case s:String => println("Sring: "+s)
      case i:Int => println("Int "+i)
    }

    def foo = println("Normal Method")
  }

  val system = ActorSystem("SimpleSystem")
  val  actor = system.actorOf(Props[SampleAkkaActor],"SimpleActor")

//  println("Before Messege")
  actor ! "Hi There"
//  println("After String")
  actor ! 42
//  println("Before Int")
  actor ! 'a'
system.terminate()
}

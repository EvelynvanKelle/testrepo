package com.learnakka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class App {
	@SuppressWarnings({ "unused" })
	public static void main(String[] args) throws InterruptedException {
		ActorSystem system = ActorSystem.create("system");
		ActorRef tokenizer = system.actorOf(Props.create(TokenizerActor.class), "tokenizer");
		ActorRef aggregator = system.actorOf(Props.create(AggregatingActor.class), "aggregator");
		ActorRef counting1 = system.actorOf(Props.create(WorkerActor.class), "worker0");
		ActorRef counting2 = system.actorOf(Props.create(WorkerActor.class), "worker1");
		ActorRef counting3 = system.actorOf(Props.create(WorkerActor.class), "worker2");
		tokenizer.tell("bla bla chi chi exe mmm ohh lala la", ActorRef.noSender());

		Thread.sleep(100);
		system.stop(aggregator);
	}
}

package com.hsenid.tech.talk.reactiveprogramdemo.MonoDemo;

import reactor.core.publisher.Mono;

public class MonoSimpleDemo {
	public static void main(String[] args) {

		// What is the easiest way create flux ???


		// How we subscribe to it ???

		// Explore more about subscriber method


		// ====================================================================
		// ========================= onError ==================================
		// ====================================================================

		Mono<Integer> ex2 = Mono.just("tech-talk")
				.map(s -> s.length())
				.map(i -> i / 0);

		ex2.subscribe(
				item -> System.out.println("Received: " + item),
				err -> System.out.println("Error: " + err.getMessage()),
				() -> System.out.println("Completed")
		);


	}
}

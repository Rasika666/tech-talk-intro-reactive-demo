package com.hsenid.tech.talk.reactiveprogramdemo.MonoDemo;

import reactor.core.publisher.Mono;

public class MonoSimpleDemo {
	public static void main(String[] args) {

		// This is a publisher
		// This publisher emitting data 0..1
		// This is very easy way to create mono when you have already data

		Mono<String> ex1 = Mono.just("tech-talk");

		System.out.println(ex1);

		// Remember the very first rule in the reactive programing is
		// nothing happened until you subscribe
		ex1.subscribe(s -> System.out.println("Received: " + s));


		// let's further explore the subscribe method
		ex1.subscribe(
				item -> System.out.println("Received: " + item),
				err -> System.out.println("Error: " + err.getMessage()),
				() -> System.out.println("Completed")
		);


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

		// let's do some refactoring here
		// let's create some util class with these consumers


	}
}

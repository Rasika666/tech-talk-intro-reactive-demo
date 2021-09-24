package com.hsenid.tech.talk.reactiveprogramdemo.MonoDemo;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

public class MonoSimpleExampleDemo {
	public static void main(String[] args) {
		userRepo(3)
				.subscribe(
						item -> System.out.println("Received: " + item),
						err -> System.out.println("Error: " + err.getMessage()),
						() -> System.out.println("Completed")
				);
	}

	public static Mono<String> userRepo(int userId) {
		if (userId == 1) {
			return Mono.just(Faker.instance().name().firstName());
		} else if(userId == 2) {
			return Mono.empty(); // return null is bad
		} else {
			return Mono.error(new RuntimeException("OUT_OF_RANGE"));
		}
	}
}

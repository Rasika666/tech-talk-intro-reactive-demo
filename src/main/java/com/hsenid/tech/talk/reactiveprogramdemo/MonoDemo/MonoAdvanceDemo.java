package com.hsenid.tech.talk.reactiveprogramdemo.MonoDemo;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Locale;

public class MonoAdvanceDemo {
	public static void main(String[] args) throws InterruptedException {
		// how to lazy load
		// Get the first name and printed with reactive pipeline
//		Mono<String> just = Mono.just(getFirstName());

//		Mono<String> stringMono = Mono.fromCallable(() -> getFirstName());



		getLastName();
		getLastName()
				.subscribe(item -> System.out.println("Received: " + item));
		getLastName();


	}


	public static String getFirstName() {
		System.out.println("Generating firstname ...");
		return Faker.instance().name().firstName();
	}

	// =================================================================
	// ============== pipeline execution vs build ======================
	// =================================================================

	public static Mono<String> getLastName() {
		System.out.println("Entered getLastName method...");

		return Mono.fromCallable(() -> {
			System.out.println("Generating lastname ...");
			Thread.sleep(2*1000);
			return Faker.instance().name().lastName();
		});
	}
}

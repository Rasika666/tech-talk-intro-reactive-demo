package com.hsenid.tech.talk.reactiveprogramdemo.MonoDemo;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Locale;

public class MonoAdvanceDemo {
	public static void main(String[] args) throws InterruptedException {
		// how to lazy load
		// we want to lazily load this fn
		// that means is if there is no subscriber then this method should not be invoked
		// just method use only if data is already there
		// Get the first name and printed with reactive pipeline//
		Mono<String> just = Mono.just(getFirstName());

		// for this we can use callable or supplier interface
		Mono<String> callable = Mono.fromCallable(() -> getFirstName());
		Mono<String> supplier = Mono.fromSupplier(() -> getFirstName());


		// Where is async

		getLastName();
		getLastName()
				.subscribeOn(Schedulers.boundedElastic())
				.subscribe(item -> System.out.println("Received: " + item));
		getLastName();

		Thread.sleep(5*1000);


	}


	public static String getFirstName() {
		System.out.println("Generating firstname ...");
		return Faker.instance().name().firstName();
	}

	// =================================================================
	// ============== pipeline execution vs build ======================
	// =================================================================

	public static Mono<String> getLastName() {
		System.out.println("Entered getLastName method..." + " Thread: " + Thread.currentThread());

		return Mono.fromCallable(() -> {
			System.out.println("Generating lastname ..." + " Thread: " + Thread.currentThread());
			Thread.sleep(2*1000);
			return Faker.instance().name().lastName();
		});
	}
}

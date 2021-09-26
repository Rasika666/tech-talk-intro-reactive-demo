package com.hsenid.tech.talk.reactiveprogramdemo.MonoDemo;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Locale;

public class MonoAdvanceDemo {
	public static void main(String[] args) throws InterruptedException {


		// Get the first name and printed with reactive pipeline

		// Lazily Get the first name and printed with reactive pipeline


		// =================================================================
		// ============== pipeline execution vs build ======================
		// =================================================================


	}


	public static String getFirstName() {
		System.out.println("Generating firstname ...");
		return Faker.instance().name().firstName();
	}



	public static Mono<String> getLastName() {
		System.out.println("Entered getLastName method...");

		return Mono.fromCallable(() -> {
			System.out.println("Generating lastname ...");
			Thread.sleep(2*1000);
			return Faker.instance().name().lastName();
		});
	}
}

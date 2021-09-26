package com.hsenid.tech.talk.reactiveprogramdemo.FluxDemo;

import reactor.core.publisher.Flux;

/**
 * emitting items programmatically
 * emitting items until some condition is met
 * we can use create / generate / push methods
 */

public class FluxAdvanceDemo {

	public static void main(String[] args) {
		// ========================================
		// ========== Flux.create =================
		// ========================================

		// only once instance of fluxSink
		// thread safe

		Flux.create(fluxSink -> {

			fluxSink.next(1);
			fluxSink.next(2);
			fluxSink.complete();

		}).subscribe(
				item -> System.out.println("Received: " + item),
				err -> System.out.println("Error: " + err.getMessage()),
				() -> System.out.println("Completed")
		);

		// ========================================
		// ========== Flux.generate ===============
		// ========================================

		// generate not only one synchronousSink but many

		Flux.generate(synchronousSink -> {
			synchronousSink.next(1);
			synchronousSink.next(2);
			synchronousSink.complete();
		}).subscribe(
				item -> System.out.println("Received: " + item),
				err -> System.out.println("Error: " + err.getMessage()),
				() -> System.out.println("Completed")
		);

		Flux.generate(
				() -> 1,
				(state, sink) -> {
					sink.next(state);
					if (state >= 10) {
						sink.complete();
					}
					return state + 1;
				}
		).subscribe(
				item -> System.out.println("Received: " + item),
				err -> System.out.println("Error: " + err.getMessage()),
				() -> System.out.println("Completed")
		);

	}


	/**
	 *  Read: https://vinsguru.medium.com/java-reactive-programming-flux-create-vs-flux-generate-38a23eb8c053
	 */

}

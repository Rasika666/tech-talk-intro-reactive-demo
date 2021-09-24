package com.hsenid.tech.talk.reactiveprogramdemo.operators;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class LifeCycleHooksDemo {
	public static void main(String[] args) {
		Flux.create(fluxSink -> {
			System.out.println("flux create inside");
			for (int i = 0; i < 5; i++) {
				fluxSink.next(i);
			}
			fluxSink.complete();
		})
		.doOnComplete(() -> System.out.println("doOnComplete"))
		.doOnCancel(() -> System.out.println("doOnCancel"))
		.doOnNext(o -> System.out.println("doOnNext: " + o))
		.doOnSubscribe(subscription -> System.out.println("doOnSubscribe: " + subscription))
		.doOnRequest(value -> System.out.println("doOnRequest: " + value))
		.doOnTerminate(() -> System.out.println("doOnTerminate"))
		.doOnError(throwable -> System.out.println("doOnError: " + throwable))
		.doFirst(() -> System.out.println("doFirst"))

		.doOnDiscard(Object.class, o -> System.out.println("doOnDiscard: " + o))
				.take(2)
				.doFinally(signalType -> System.out.println("doFinally: " + signalType))
		.subscribe(
				item -> System.out.println("Received: " + item),
				err -> System.out.println("Error: " + err.getMessage()),
				() -> System.out.println("Completed")
		);

	}
}

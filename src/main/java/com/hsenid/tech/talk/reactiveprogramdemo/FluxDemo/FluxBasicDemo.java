package com.hsenid.tech.talk.reactiveprogramdemo.FluxDemo;

import com.hsenid.tech.talk.reactiveprogramdemo.util.CommonUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FluxBasicDemo {
	public static void main(String[] args) throws InterruptedException {

		// TODO: simple way to create flux when data is already there
		Flux<Integer> just = Flux.just(1, 2, 3);

		// TODO: make reactive stream using getArray() fn
		Flux<String> fromArray = Flux.fromArray(getArray());

		// TODO: make reactive stream using getIterable() fn
		Flux<String> fromIterable = Flux.fromIterable(getIterable());

		// TODO: make reactive stream using getStream() fn
		Flux<String> fromStream = Flux.fromStream(() -> getStream());

		// TODO: Flux.range()
//		Flux.range(0,5).subscribe(CommonUtil.onNext());

		// TODO: Flux.interval()
		Flux.interval(Duration.ofSeconds(2))
				.subscribe(CommonUtil.onNext());

		Thread.sleep(10*1000);

		// TODO: Mono to Flux
		Flux<String> from = Flux.from(getMono());

		// TODO: Flux to Mono
		Mono<Integer> next = getFlux().next();
		next.subscribe(CommonUtil.onNext());
	}

	private static String[] getArray() {
		return new String[]{"one", "two", "three", "four"};
	}

	private static List<String> getIterable() {
		return Arrays.asList("one", "two", "three");
	}

	private static Stream<String> getStream() {
		return getIterable().stream();
	}

	private static Mono<String> getMono() {
		return Mono.just("abc");
	}

	private static Flux<Integer> getFlux() {
		return Flux.range(1, 10);
	}
}

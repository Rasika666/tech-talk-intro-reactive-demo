package com.hsenid.tech.talk.reactiveprogramdemo.FluxDemo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FluxBasicDemo {
	public static void main(String[] args) {

		// simple way to create flux when data is already there
		Flux<Integer> just = Flux.just(1, 2, 3);

		// TODO: make reactive stream using getArray() fn

		// TODO: make reactive stream using getIterable() fn

		// TODO: make reactive stream using getStream() fn

		// TODO: Flux.range()

		// TODO: Flux.interval()

		// TODO: Mono to Flux

		// TODO: Flux to Mono
	}

	private String[] getArray() {
		return new String[]{"one", "two", "three", "four"};
	}

	private static List<String> getIterable() {
		return Arrays.asList("one", "two", "three");
	}

	private Stream<String> getStream() {
		return getIterable().stream();
	}
}

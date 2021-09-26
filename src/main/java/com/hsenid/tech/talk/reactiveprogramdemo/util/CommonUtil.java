package com.hsenid.tech.talk.reactiveprogramdemo.util;

// TODO: make onNext, onError and onComplete

import java.util.function.Consumer;

public class CommonUtil {

	public static Consumer<Object> onNext() {
		return o -> System.out.println("Received: " + o);
	}

	public static Consumer<Throwable> onError() {
		return err -> System.out.println("Error: " + err);
	}

	public static Runnable onComplete() {
		return () -> System.out.println("Complete");
	}
}

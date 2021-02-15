package org.acme.scheduler;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;

@ApplicationScoped
public class CounterBean {
	private AtomicInteger counter = new AtomicInteger();

	public int get() {
		return counter.get();
	}

	@Scheduled(every = "10s")
	void increment() {
		counter.incrementAndGet();
	}

	@Scheduled(cron = "0 15 10 * * ?")
	void cronJob(ScheduledExecution execution) {
		counter.incrementAndGet();
		System.out.println(execution.getScheduledFireTime() + "count =" + counter.get());
	}

	@Scheduled(cron = "{cron.expr}")
	void cronJobWithExpressionInConfig() {
		counter.incrementAndGet();
		System.out.println("Cron expression configured in application.properties count=" + counter.get());
	}
}

package test.love.moon;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author dongnan
 * @date 2020/8/13 16:49
 */
@Slf4j
public class Flux100 {


    @Test
    public void testCreate1() {
        Flux.create(sink -> {
            for (char i = 'a'; i <= 'z'; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(e->{
            System.out.println(Thread.currentThread().getName()+":"+e);
        });
    }

    @Test
    public void testCreate2() {
        Flux.just("Hello", "World").subscribe(System.out::println);
        Flux.fromArray(new Integer[]{1, 2, 3}).subscribe(System.out::println);
        Flux.empty().subscribe(System.out::println);
        Flux.range(1, 5).subscribe(System.out::println);
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
    }

    @Test
    public void testException() {
        Flux.just(1, 2)
                .concatWith(Mono.error(new IllegalStateException()))
                .subscribe(System.out::println, System.err::println);
    }

    @Test
    public void testScheduler() {
        Flux.create(sink -> {
            sink.next(Thread.currentThread().getName());
            sink.complete();
        })
                .publishOn(Schedulers.single())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .publishOn(Schedulers.elastic())
                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
                .subscribeOn(Schedulers.parallel())
                .toStream()
                .forEach(System.out::println);
    }

    @Test
    public void testHandler() {
        System.out.println("filter/map");
        Flux.range(1, 10)
                .filter(i -> i % 2 == 0).map(x -> x*x).subscribe(System.out::println);

        System.out.println("合并");
        Flux.just("I", "You")
                .zipWith(Flux.just("Win", "Lose"))
                .subscribe(e->{
                    System.out.println(e);
                });

        System.out.println("累积reduce");
        Flux.range(1, 2).reduce((x, y) -> x + y).subscribe(System.out::println);
    }

    @Test
    public void testHandleOrder() {
        Flux.just("a", "b", "c")
                .map(e -> {
                    System.out.println("thread:"+Thread.currentThread().getName()+" map");
                    return e + "-map";
                })
                .subscribe(e -> System.out.println("thread:"+Thread.currentThread().getName()+" subscribe:" + e));
    }
}

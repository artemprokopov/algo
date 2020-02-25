package ru.prokopov.algo.sort.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.prokopov.algo.sort.BubbleSort;
import ru.prokopov.algo.sort.CocktailSort;
import ru.prokopov.algo.sort.CombSort;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx6G"})
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class SortBenchmarkTest {

    @Param({ "10000"})
    private int N;

    private int[] testArray;

    @Setup
    public void setup() {
        testArray = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            testArray[i] = random.nextInt();
        }
    }

    @Benchmark
    public void bubbleSortBenchmark() {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(testArray);
    }

    @Benchmark
    public void cocktailSortBenchmark() {
        CocktailSort cocktailSort = new CocktailSort();
        cocktailSort.sort(testArray);
    }

    @Benchmark
    public void combSortBenchmark() {
        CombSort combSort = new CombSort();
        combSort.sort(testArray);
    }

    public static void main(String[] args) throws RunnerException {
        final Options options = new OptionsBuilder()
                .include(SortBenchmarkTest.class.getSimpleName())
                .build();

        new Runner(options).run();
    }
}

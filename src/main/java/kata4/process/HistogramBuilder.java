package kata4.process;

import kata4.model.Histogram;

import static java.util.Arrays.stream;

public class HistogramBuilder<T> {

    public Histogram<T> build(T[] vector) {
        Histogram<T> histogram = new Histogram<>();
        stream(vector).forEach(histogram::increment);
        return histogram;
    }

}

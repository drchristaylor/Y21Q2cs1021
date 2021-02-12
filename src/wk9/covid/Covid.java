package wk9.covid;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Covid {
    private List<Entry> entries;

    public static final String URL = "https://covidtracking.com/data/download/all-states-history.csv";

    public static void main(String[] args) {
        try {
            Covid covid = new Covid(URL);
            System.out.println(covid.getPercentagePositivePCR());
            System.out.println(covid.questions());
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
    }

    private String questions() {
        Optional<Entry> badDayInState = entries.parallelStream()
                .filter(e -> e.onVentilatorCurrently.isPresent())
                .max((e, f) -> e.onVentilatorCurrently.getAsInt()-f.onVentilatorCurrently.getAsInt());
        Entry bdis = badDayInState.orElse(null);
        return bdis!=null ? bdis.state : "";
    }

    private double getPercentagePositivePCR() {
        return 100.0 * entries.stream()
                .filter(e -> e.date.equals(entries.get(0).date))
                .filter(e -> e.positiveCasesViral.isPresent())
                .mapToInt(e -> e.positiveCasesViral.getAsInt())
                .sum()
                /
                entries.stream()
                .filter(e -> e.date.equals(entries.get(0).date))
                .filter(e -> e.totalTestsViral.isPresent())
                .mapToInt(e -> e.totalTestsViral.getAsInt())
                .sum() ;
    }

    private int getTotalEntries() {
        return entries.size();
    }

    public Covid(String url) throws IOException {
        try (InputStream is = new URL(url).openConnection().getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is));
             Stream<String> lines = reader.lines()) {
            entries = lines.skip(1)
                            .map(line -> new Entry(line))
                           .collect(Collectors.toList());
        }
    }
}

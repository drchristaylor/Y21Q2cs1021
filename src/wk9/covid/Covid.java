package wk9.covid;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Covid {
    private List<Entry> entries;

    public static final String URL = "https://covidtracking.com/data/download/all-states-history.csv";

    public static void main(String[] args) {
        try {
            Covid covid = new Covid(URL);
            System.out.println(covid.getTotalEntries());
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL");
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
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

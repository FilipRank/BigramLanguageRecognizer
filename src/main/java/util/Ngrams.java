package util;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ngrams {

    public static  Map<String, Double> extractBigramProbability(File file) {
        Map<String, Double> bigramFrequency = extractBigramFrequency(file);
        return calculategNgramProbability(bigramFrequency);
    }

    public static Map<String, Double> extractBigramProbability(String text) {
        Map<String, Double> bigramFrequency = extractBigramFrequency(text);
        return calculategNgramProbability(bigramFrequency);
    }

    public static Map<String, Double> extractBigramFrequency(File file) {
        Map<String, Double> bigramFrequency = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null) {
                String text = reader.readLine().toLowerCase().replaceAll("[^a-z]", "");

                for (int i = 0; i < text.length() - 1; i++) {
                    String currentBigram = text.substring(i, i + 2);

                    bigramFrequency.put(
                            currentBigram,
                            bigramFrequency.getOrDefault(currentBigram, 0.0) + 1
                    );
                }
            }
            return bigramFrequency;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Double> extractBigramFrequency(String text) {
        Map<String, Double> bigramFrequency = new HashMap<>();

        text = text.toLowerCase().replaceAll("[^a-z]", "");

        for (int i = 0; i < text.length() - 1; i++) {
            String currentBigram = text.substring(i, i + 2);

            bigramFrequency.put(
                    currentBigram,
                    bigramFrequency.getOrDefault(currentBigram, 0.0) + 1
            );
        }
        return bigramFrequency;
    }

    private static Map<String, Double> calculategNgramProbability
            (Map<String, Double> ngramFrequency) {
        Double frequencySum = getFrequencySum(ngramFrequency);

        return ngramFrequency.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() / frequencySum
                ));
    }

    private static Double getFrequencySum(Map<String, Double> hashMap) {
        return hashMap.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public static Map<String, Double> sortDataDescending(
            Map<String, Double> data) {

        return data.entrySet().stream().sorted((val1, val2) -> val2.getValue().compareTo(val1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (val1, val2) -> val1,
                        LinkedHashMap::new
                ));
    }
}

package pairmatching.repository;

import pairmatching.constant.FileConstant;
import pairmatching.exception.InvalidInputException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CrewRepository {
    private final List<String> frontCrewNames;
    private final List<String> backCrewNames;

    private CrewRepository() {
        this.frontCrewNames = readData(FileConstant.FRONTEND_PATH);
        this.backCrewNames = readData(FileConstant.BACKEND_PATH);
    }

    private static BufferedReader getBufferedFileReader(String path) throws IOException {
        InputStreamReader isr;
        try (InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(path)) {
            isr = new InputStreamReader(Objects.requireNonNull(is));
        }
        return new BufferedReader(isr);
    }

    public static CrewRepository getInstance() {
        return CrewRepository.RepositoryHolder.INSTANCE;
    }

    private List<String> readData(String path) {
        try (BufferedReader br = getBufferedFileReader(path)) {
            List<String> list = new ArrayList<>();
            while (br.ready()) {
                String line = br.readLine().trim();
                list.add(line);
            }

            return list;
        } catch (IOException e) {
            throw new InvalidInputException();
        }
    }

    private static class RepositoryHolder {
        private static final CrewRepository INSTANCE = new CrewRepository();
    }
}

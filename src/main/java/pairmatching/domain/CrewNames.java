package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.exception.ErrorMessage;
import pairmatching.exception.MatchingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CrewNames {
    private final List<String> crewNames;

    private CrewNames(List<String> crewNames) {
        this.crewNames = crewNames;
    }

    public static CrewNames fromFileName(String fileName) {
        List<String> crewNames = new ArrayList<>();

        try (InputStream is = CrewNames.class.getClassLoader().getResourceAsStream(fileName);
             InputStreamReader isr = new InputStreamReader(Objects.requireNonNull(is));
             BufferedReader br = new BufferedReader(isr)) {
            readCrewNames(br, crewNames);
            return new CrewNames(crewNames);
        } catch (IOException e) {
            throw new MatchingException(ErrorMessage.FILE_READING_FAILED);
        }
    }

    public CrewNames shuffle() {
        return new CrewNames(Randoms.shuffle(crewNames));
    }

    public Iterator<String> getIterator() {
        return crewNames.iterator();
    }

    private static void readCrewNames(BufferedReader br, List<String> crewNames) throws IOException {
        while (br.ready()) {
            String line = br.readLine().trim();
            crewNames.add(line);
        }
    }
}

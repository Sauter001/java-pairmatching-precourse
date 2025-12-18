package pairmatching.domain.dto;

import java.util.List;

public class PairNameDto {
    private final List<String> pairNames;

    public PairNameDto(List<String> pairNames) {
        this.pairNames = pairNames;
    }

    public List<String> getPairNames() {
        return pairNames;
    }
}

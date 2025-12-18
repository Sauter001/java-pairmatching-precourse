package pairmatching.domain;

import pairmatching.domain.dto.PairNameDto;

import java.util.List;
import java.util.stream.Collectors;

public class Pairs {
    private final List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

    public List<PairNameDto> getPairNameDtos() {
        List<String> pairNames = this.pairs.stream()
                .map(Pair::getCrews)
                .collect(Collectors.toList());
        return new PairNameDto(pairNames);
    }
}

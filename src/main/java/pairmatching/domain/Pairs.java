package pairmatching.domain;

import pairmatching.domain.dto.PairNameDto;

import java.util.List;
import java.util.stream.Collectors;

public class Pairs {
    private final List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = pairs;
    }

}

package pairmatching.parser;

import pairmatching.exception.ErrorMessage;
import pairmatching.exception.MatchingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static pairmatching.constant.MatchingConstant.*;

public class FunctionCommandParser implements Parser<String> {
    private static final List<String> commands = new ArrayList<>();

    static  {
        commands.add(MATCHING_COMMAND);
        commands.add(READ_PAIR_COMMAND);
        commands.add(INIT_PAIR_COMMAND);
        commands.add(QUIT_COMMAND);
    }

    @Override
    public String parse(String input) {
        String trimmedInput = input.trim().toUpperCase();
        if (!commands.contains(trimmedInput)) {
            throw new MatchingException(ErrorMessage.INVALID_COMMAND);
        }

        return trimmedInput;
    }
}

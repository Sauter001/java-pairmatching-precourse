package pairmatching.domain.input;

import pairmatching.exception.InvalidInputException;
import pairmatching.handler.*;

import java.util.Arrays;

public enum UserCommand {
    PAIR_MATCHING("1", HandlerFactory.createPairMatchHandler()),
    PAIR_VIEW("2", new PairViewHandler()),
    PAIR_INIT("3", new PairInitHandler()),
    QUIT("Q", new ExitHandler());

    private final String key;
    private final CommandHandler commandHandler;

    UserCommand(String key, CommandHandler commandHandler) {
        this.key = key;
        this.commandHandler = commandHandler;
    }

    public static UserCommand from(String targetKey) {
        String upperTargetKey = targetKey.toUpperCase().trim();
        return Arrays.stream(values())
                .filter(u -> u.getKey().equals(upperTargetKey))
                .findFirst()
                .orElseThrow(InvalidInputException::new);
    }

    public String getKey() {
        return key;
    }

    public void handle() {
        commandHandler.handle();
    }
}

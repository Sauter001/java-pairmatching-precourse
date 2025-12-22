package pairmatching.parser;

import pairmatching.domain.input.UserCommand;

public class UserCommandParser implements Parser<UserCommand> {
    @Override
    public UserCommand parse(String input) {
        return UserCommand.from(input);
    }
}

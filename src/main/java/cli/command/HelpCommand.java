package cli.command;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Welcome to the bigram language recognizer tool!\n" +
                "\n" +
                "Here are some useful commands:\n" +
                "\n" +
                "start - start the language recognition process\n" +
                "calculate-probability - calculate the probability of all bigrams in a text" +
                "calculate-frequency - calculate the bigram frequency of some text\n" +
                "help - show this reminder\n" +
                "ls-languages - show a list of available languages for recognition\n" +
                "exit - stop the program");
    }
}

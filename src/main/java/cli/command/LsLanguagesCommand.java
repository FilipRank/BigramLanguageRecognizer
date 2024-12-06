package cli.command;

public class LsLanguagesCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Here is a list of languages available for recognition: \n" +
                "- English\n" +
                "- French\n" +
                "- German\n" +
                "- Spanish");
    }
}

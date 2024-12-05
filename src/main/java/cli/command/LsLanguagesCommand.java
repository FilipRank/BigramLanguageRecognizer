package cli.command;

public class LsLanguagesCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Here is a list of detectable languages: \n" +
                "- English\n" +
                "- French \n" +
                "- German");
    }
}

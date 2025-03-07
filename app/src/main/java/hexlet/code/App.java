package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = false,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.",
        synopsisHeading = "Usage: ",
        customSynopsis = "gendiff [-hV]"
)
public class App implements Runnable {

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean help;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean version;

    @Override
    public void run() {
        System.out.println("Gendiff is running...");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

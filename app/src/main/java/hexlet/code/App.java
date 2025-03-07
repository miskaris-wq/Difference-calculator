package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = false,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.",
        synopsisHeading = "Usage: ",
        customSynopsis = "gendiff [-hV] [-f=format] filepath1 filepath2"
)
public class App implements Runnable {

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean help;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean version;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish", description = "output format [default: stylish]")
    String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    String filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    String filepath2;


    @Override
    public void run() {
        System.out.println("Gendiff is running...");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

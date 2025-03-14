package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.",
        synopsisHeading = "Usage: ",
        customSynopsis = "gendiff [-hV] [-f=format] filepath1 filepath2"
)
public final class App implements Callable<String> {

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean help;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private boolean version;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    @Override
    public String call() {
        try {
            String diff = Differ.generate(filepath1, filepath2, format);
            System.out.println(diff);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public boolean isVersion() {
        return version;
    }

    public void setVersion(boolean version) {
        this.version = version;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFilepath1() {
        return filepath1;
    }

    public void setFilepath1(String filepath1) {
        this.filepath1 = filepath1;
    }

    public String getFilepath2() {
        return filepath2;
    }

    public void setFilepath2(String filepath2) {
        this.filepath2 = filepath2;
    }
}

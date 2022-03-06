import app.appenders.Appender;
import app.appenders.console.ConsoleAppender;
import app.appenders.file.FileAppender;
import app.appenders.file.LogFile;
import app.enums.ReportLevel;
import app.layouts.Layout;
import app.layouts.SimpleLayout;
import app.layouts.XmlLayout;
import app.loggers.Logger;
import app.loggers.MessageLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Appender> appenders = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] appenderInfo = scan.nextLine().split("\\s+");
            appenders.add(makeAppender(appenderInfo));
        }

        Logger logger = new MessageLogger(appenders.toArray(new Appender[n]));
        String message = scan.nextLine();
        while (!message.equals("END")) {
            String[] tokens = message.split("\\|");
            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);

            switch (reportLevel) {
                case INFO:
                    logger.logInfo(tokens[1], tokens[2]);
                    break;
                case WARNING:
                    logger.logWarning(tokens[1], tokens[2]);
                    break;
                case ERROR:
                    logger.logError(tokens[1], tokens[2]);
                    break;
                case CRITICAL:
                    logger.logCritical(tokens[1], tokens[2]);
                    break;
                case FATAL:
                    logger.logFatal(tokens[1], tokens[2]);
                    break;

            }
            message = scan.nextLine();
        }

        logger.log();
    }

    private static Appender makeAppender(String[] tokens) {
        String appenderType = tokens[0];
        String layoutType = tokens[1];
        ReportLevel reportLevel;
        if (tokens.length == 3) {
            reportLevel = ReportLevel.valueOf(tokens[2].toUpperCase());

        } else {
            reportLevel = ReportLevel.INFO;
        }

        switch (appenderType) {
            case "ConsoleAppender":
                ConsoleAppender consoleAppender = new ConsoleAppender(makeLayout(layoutType));
                consoleAppender.setReportLevel(reportLevel);
                return consoleAppender;
            case "FileAppender":
                FileAppender fileAppender = new FileAppender(makeLayout(layoutType));
                fileAppender.setReportLevel(reportLevel);
                fileAppender.setFile(new LogFile());
                return fileAppender;
            default:
                throw new IllegalArgumentException("Invalid appender type!");
        }
    }

    private static Layout makeLayout(String layoutType) {
        Layout layout;
        switch (layoutType) {
            case "SimpleLayout":
                return new SimpleLayout();
            case "XmlLayout":
                return new XmlLayout();
            default:
                throw new IllegalArgumentException("Invalid layout type!");
        }
    }
}

package app.loggers;

import app.appenders.Appender;
import app.enums.ReportLevel;

import java.util.ArrayList;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = new ArrayList<>(List.of(appenders));
    }


    @Override
    public void logInfo(String dateTime, String message) {
        this.appenders.forEach(a -> a.append(dateTime, ReportLevel.INFO, message));
    }

    @Override
    public void logWarning(String dateTime, String message) {
        this.appenders.forEach(a -> a.append(dateTime, ReportLevel.WARNING, message));
    }

    @Override
    public void logError(String dateTime, String message) {
        this.appenders.forEach(a -> a.append(dateTime, ReportLevel.ERROR, message));
    }

    @Override
    public void logCritical(String dateTime, String message) {
        this.appenders.forEach(a -> a.append(dateTime, ReportLevel.CRITICAL, message));
    }

    @Override
    public void logFatal(String dateTime, String message) {
        this.appenders.forEach(a -> a.append(dateTime, ReportLevel.FATAL, message));
    }

    @Override
    public void log() {
        System.out.println("Logger info");
        this.appenders.forEach(System.out::println);
    }
}

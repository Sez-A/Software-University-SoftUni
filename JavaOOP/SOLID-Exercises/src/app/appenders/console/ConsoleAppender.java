package app.appenders.console;

import app.appenders.Appender;
import app.enums.ReportLevel;
import app.layouts.Layout;

public class ConsoleAppender extends Appender {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String message) {
        if (isValidReportLevel(reportLevel)) {
            super.setAppendedMessages(super.getAppendedMessages() + 1);
            System.out.println(super.getLayout().format(dateTime, reportLevel, message));
        }
    }
}

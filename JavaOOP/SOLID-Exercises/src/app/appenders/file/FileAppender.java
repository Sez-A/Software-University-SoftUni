package app.appenders.file;

import app.appenders.Appender;
import app.enums.ReportLevel;
import app.layouts.Layout;

public class FileAppender extends Appender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String message) {
        if (isValidReportLevel(reportLevel)) {
            super.setAppendedMessages(super.getAppendedMessages() + 1);
            this.file.write(super.getLayout().format(dateTime, reportLevel, message));
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", File size: %d", this.file.getSize());
    }
}

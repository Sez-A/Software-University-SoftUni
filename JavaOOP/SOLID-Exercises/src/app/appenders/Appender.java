package app.appenders;

import app.enums.ReportLevel;
import app.layouts.Layout;

public abstract class Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    private int appendedMessages;

    public Appender(Layout layout) {
        this.layout = layout;
        this.appendedMessages = 0;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public void setAppendedMessages(int appendedMessages) {
        this.appendedMessages = appendedMessages;
    }

    public int getAppendedMessages() {
        return appendedMessages;
    }


    protected boolean isValidReportLevel(ReportLevel reportLevel) {
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }

    public abstract void append(String dateTime, ReportLevel reportLevel, String message);

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d"
                , this.getClass().getSimpleName()
                , this.getLayout().getClass().getSimpleName()
                , this.reportLevel
                , this.getAppendedMessages());
    }
}

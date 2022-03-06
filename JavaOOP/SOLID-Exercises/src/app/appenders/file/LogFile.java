package app.appenders.file;

public class LogFile implements File {
    private StringBuilder messages;

    public LogFile() {
        this.messages = new StringBuilder();
    }

    @Override
    public void write(String message) {
        this.messages.append(message).append(System.lineSeparator());
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (int i = 0; i < messages.toString().length(); i++) {
            char symbol = messages.charAt(i);
            if (Character.isLetter(symbol)) {
                sum += symbol;
            }
        }
        return sum;
    }
}

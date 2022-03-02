package problem5;

import java.util.List;

public class Smartphone implements Callable,Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if(isValidUrl(url)) {
                sb.append(String.format("Browsing: %s!",url));
            }else {
                sb.append("Invalid URL!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if(isValidPhoneNumber(number)) {
                sb.append(String.format("Calling... %s",number));
            }else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();

    }

    private boolean isValidUrl(String url) {
        for (int i = 0; i < url.length() ; i++) {
            if(Character.isDigit(url.charAt(i)))
                return false;
        }
        return true;
    }

    private boolean isValidPhoneNumber(String number) {
        for (int i = 0; i < number.length() ; i++) {
            if(!Character.isDigit(number.charAt(i)))
                return false;
        }
        return true;
    }

}

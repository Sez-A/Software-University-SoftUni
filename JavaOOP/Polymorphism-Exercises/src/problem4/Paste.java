package problem4;

public class Paste implements TextTransform {
    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {

        //text.insert(startIndex, LastCut.getLastCut());
        text.replace(startIndex, endIndex , LastCut.getLastCut());

    }
}


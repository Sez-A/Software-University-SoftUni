package problem4;


public class Cut implements TextTransform {


    public Cut() {

    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        StringBuilder lastCutText = new StringBuilder();
        if (startIndex == endIndex) {
            LastCut.clearBuff();
        } else {
            for (int i = startIndex; i < endIndex; i++) {
//                String[] newText = text.toString().split("");
//                newText[i] = "
                lastCutText.append(text.charAt(i));
            }
            text.replace(startIndex, endIndex, "");
        }
        if (LastCut.isEmpty())
            LastCut.saveTheLastCut(lastCutText.toString());
        else {
            LastCut.removeContent();
            LastCut.saveTheLastCut(lastCutText.toString());
        }
    }

}

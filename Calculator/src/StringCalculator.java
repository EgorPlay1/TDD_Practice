import java.util.ArrayList;
import java.util.Arrays;

public class StringCalculator {

    public boolean isEmpty() {
        return true;
    }

    public int add(String s) {
        if (!"".equals(s)) {
            ArrayList<Integer> inputs = parseInputs(s);
            int out = 0;
            for (int val : inputs) {
                out += val;
            }
            return out;
        } else {
            return 0;
        }
    }

    private ArrayList<Integer> parseInputs(String s) {
        ArrayList<String> newInputs = getStrings(s);
        return getIntegers(newInputs);
    }

    private ArrayList<String> getStrings(String s) {
        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(s.split(",")));
        ArrayList<String> newInputs = new ArrayList<>();
        for (String str : inputs) {
            ArrayList<String> otherInputs = new ArrayList<>(Arrays.asList(str.split("\n")));
            newInputs.addAll(otherInputs);
        }
        return newInputs;
    }

    private ArrayList<Integer> getIntegers(ArrayList<String> newInputs) {
        ArrayList<Integer> out = new ArrayList<>();
        for (String input : newInputs) {
            int val = Integer.parseInt(input);
                out.add(val);
        }
        validate(out);
        return out;
    }

    private void validate(ArrayList<Integer> out) {
        ArrayList<Integer> negatives = new ArrayList<>();
        for (int val : out) {
            if (val < 0) {
                negatives.add(val);
            }
        }
        if (!negatives.isEmpty()) {
            throw new RuntimeException("negatives not allowed " + negatives.toString());
        }
    }
}

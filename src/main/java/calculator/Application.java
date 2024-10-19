package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Application {
    static final String CUSTOM_DELIM_START = "//";
    static final String CUSTOM_DELIM_END = "\n";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String[] parsedStrings = parse(input);

        int sum = calculateSum(parsedStrings);

        StringBuilder result = new StringBuilder("결과 : ");
        result.append(sum);

        System.out.println(result);
    }

    static String[] parse(String input) {
        StringBuilder delimiter = new StringBuilder(",|:");

        if(input.startsWith(CUSTOM_DELIM_START)) {
            int delimiterIndex = input.indexOf(CUSTOM_DELIM_END);
            String customDelimiter = input.substring(CUSTOM_DELIM_START.length(), delimiterIndex);
            delimiter.append('|');
            delimiter.append(customDelimiter);
            input = input.substring(delimiterIndex + CUSTOM_DELIM_END.length());
        }

        String[] result = input.split(delimiter.toString());

        return result;
    }

    static int calculateSum(String[] parsedStrings) {
        int sum = 0;

        for (String parsedString: parsedStrings) {
            int positiveNumber = toPositiveNumber(parsedString);
            sum += positiveNumber;
        }

        return sum;
    }

    static int toPositiveNumber(String input) {
        int result = Integer.parseInt(input);

        return result;
    }
}

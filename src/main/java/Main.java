
public class Main {

     public static void main(String[] args) {
        Main calculator = new Main();
        System.out.println(calculator.add(""));
        System.out.println(calculator.add("1"));
        System.out.println(calculator.add("1,2"));
        System.out.println(calculator.add("1\n2,3"));
        System.out.println(calculator.add("//;\n1;2"));

        try {
            System.out.println(calculator.add("1,-2,-3"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        String numberPart = numbers;

        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numberPart = numbers.substring(delimiterIndex + 1);
        }
        delimiter = delimiter + "|\n";
        String[] tokens = numberPart.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                int num = Integer.parseInt(token.trim());
                sum += num;
            }
        }

        return sum;
    }
}

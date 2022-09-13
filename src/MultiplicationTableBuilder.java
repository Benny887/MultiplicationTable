public class MultiplicationTableBuilder {
    private static final int MAX_VALUE = 32;
    private static final int MIN_VALUE = 1;
    private static final String VERTICAL = "|";
    private static final String DASH = "–";
    private static final String PLUS = "+";

    public static int getMaxValue() {
        return MAX_VALUE;
    }

    public static int getMinValue() {
        return MIN_VALUE;
    }

    public void tablePainter(int tableSize, int narrowColumn, int wideColumn) {
        String delimiter = "\n" + DASH.repeat(narrowColumn) + (PLUS + DASH.repeat(wideColumn)).repeat(tableSize) + "\n";
        for(int i = 0; i <= tableSize; i++) {
            System.out.print(makeLine(narrowColumn, wideColumn, tableSize, i));
            System.out.print(delimiter);
        }
    }

    public static int makeCellSize(int num) {
        return String.valueOf(num).length();
    }

    public String makeLine(int narrowColumn, int wideColumn, int maxValue, int iteration){
        String myFormat = "%" + (wideColumn + 1) + "s";
        int multiple = 0;
        int sum = iteration;
        StringBuilder sb = new StringBuilder(64);
        for(int i = 0; i <= maxValue; i++, multiple += iteration, sum++)
            sb.append(String.format(myFormat, ((multiple == 0 ? sum == 0 ? "" : sum : multiple) + VERTICAL)));
        return sb.substring(wideColumn - narrowColumn, sb.toString().length()-1);
    }

    public static int checkErrors(String enteredData) {
        int tableSize;
        try {
            tableSize = Integer.parseInt(enteredData.trim());
            if (tableSize < MIN_VALUE || tableSize > MAX_VALUE) {
                System.out.println("Выход за пределы указанного диапазона.");
                tableSize = -1;
            }
        } catch (Exception e) {
            System.out.println("Используйте только целые положительные числа " +
                    "в диапазоне от " + MIN_VALUE + " до " + MAX_VALUE);
            tableSize = -1;
        }
        return tableSize;
    }
}

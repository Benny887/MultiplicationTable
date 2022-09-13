import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int tableSize;
        System.out.println("Введите размер таблицы от " + MultiplicationTableBuilder.getMinValue() +
                " до " + MultiplicationTableBuilder.getMaxValue());
        try(Scanner scanner = new Scanner(System.in)) {
            if ((tableSize = MultiplicationTableBuilder.checkErrors(scanner.nextLine())) < 0)
                System.out.println("Введены некорректные данные.Программа завершена.");
            else {
                int firstSellSize = MultiplicationTableBuilder.makeCellSize(tableSize);
                int sellSize = MultiplicationTableBuilder.makeCellSize(tableSize * tableSize);
                MultiplicationTableBuilder mT = new MultiplicationTableBuilder();
                mT.tablePainter(tableSize, firstSellSize, sellSize);
            }
        } catch (Throwable e) {
            System.out.println("Выполнение программы остановлено. Проверьте корректность вводимых данных.");
        }
    }
}

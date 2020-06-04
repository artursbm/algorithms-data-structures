import problems.MoveZeroes;
import problems.PlusOne;
import problems.StockPriceII;

public class Main {

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] teste = {4,2,4,0,0,3,0,5,1,0};
        mz.moveZeroes(teste);
        for (int t : teste) {
            System.out.println(t);
        }
    }
}

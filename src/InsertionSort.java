import java.util.StringTokenizer;

/**
 * Created by noble on 2017-09-14.
 */
public class InsertionSort {
    private StringTokenizer token;
    private int[] array;
    private boolean sorted;

    //Getter & Setter
    private void setToken(StringTokenizer newToken) {
        this.token = newToken;
    }
    private StringTokenizer getToken() {
        return this.token;
    }
    private void setArray(int[] numarray) {
        this.array = numarray;
    }
    private int[] getArray() {
        return this.array;
    }
    private void setSorted(boolean newSorted) {
        this.sorted = newSorted;
    }
    public boolean isSorted() {
        return this.sorted;
    }

    // Constructor
    public InsertionSort(String target) {
        this.setToken(new StringTokenizer(target));
        this.setArray(new int[this.getToken().countTokens()]);
        this.setSorted(false);

    }
    public boolean sort() {
        int num1;
        int i;
        int count = 0;
        while ( this.getToken().hasMoreTokens() ) {
            num1 = Integer.parseInt(this.getToken().nextToken());
            i = count;
            while(i > 0) {
                if (this.getArray()[i-1] > num1) {
                    this.getArray()[i] = this.getArray()[i-1];
                    i--;
                }else break;
            }
            this.getArray()[i] = num1;
            count++;
        }
        this.setSorted(true);
        return true;
    }

    public int search(int targetNumber) {
        if (!this.isSorted()) {
            System.out.println("sorting이 되지 않았습니다!!");
            return -1;
        }
        int p= 0;
        int q = this.getArray().length;
        int bipivot = q / 2;
        while (p < q) {
            int number = this.getArray()[bipivot];
            if ( number > targetNumber) {
                q= bipivot;
            }else if( number < targetNumber) {
                p = bipivot;
            }else return bipivot;

            bipivot = (q + p)/2;
        }
        System.out.println("존재하지 않습니다!!");
        return -1;
    }
    public String toString() {
        String result = Integer.toString(this.getArray()[0]);
        for (int i=1; i<this.getArray().length; i++) {
            result += " "+ this.getArray()[i];
        }
        return result;
    }
}

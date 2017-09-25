import java.util.StringTokenizer;

/**
 * Created by noble on 2017-09-19.
 */
public class MergeSort {
    private StringTokenizer token;
    private int[] array;
    private boolean sorted;

    // Getter & Setter
    private void setToken(StringTokenizer newToken) {
        this.token = newToken;
    }
    private StringTokenizer getToken() {
        return this.token;
    }
    private void setArray(int[] newArray) {
        this.array = newArray;
    }
    public int[] getArray() {
        return this.array;
    }

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

    // Constructor
    public MergeSort(String target) {
        this.setToken(new StringTokenizer(target));
        this.setArray(new int[this.getToken().countTokens()]);
        this.setSorted(false);
        for(int i=0; this.getToken().hasMoreTokens(); i++) {
            this.getArray()[i] = Integer.parseInt(this.getToken().nextToken());
        }
    }
    public boolean sort() {

        try {
            this.setArray(this.returnArraySort(this.getArray()));
            this.setSorted(true);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private int[] returnArraySort(int[] array) {
        int[] a = new int[array.length/2];
        int[] b = new int[array.length- a.length];
        int[] mergeArray = new int[array.length];

        System.arraycopy(array, 0, a, 0, a.length);
        System.arraycopy(array, a.length, b, 0, b.length);
        if (a.length > 1) {
            a = this.returnArraySort(a);
        }
        if (b.length > 1) {
            b = this.returnArraySort(b);
        }
        int i = 0, j = 0, count = 0;
        while (i < a.length) {
            if (j >= b.length) {
                mergeArray[count++] = a[i++];
                continue;
            }
            if (a[i] > b[j])
                mergeArray[count++] = b[j++];
            else
                mergeArray[count++] = a[i++];
        }
        while (j < b.length) {
            mergeArray[count++] = b[j++];
        }
        return mergeArray;
    }

    public String toString() {
        String result = Integer.toString(this.getArray()[0]);
        for (int i=1; i<this.getArray().length; i++) {
            result += " "+ this.getArray()[i];
        }
        return result;
    }
}

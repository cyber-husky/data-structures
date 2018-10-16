package Arrays;

class LowArray {
    private long[] a;
    public LowArray(int size) {
        a = new long[size];
    }
    public void setElement(int index, long value) {
        a[index] = value;
    }
    public long getElement(int index) {
        return a[index];
    }
}

class LowArrayApp {
    public static void main(String[] args) {
        LowArray arr;
        arr = new LowArray(10);
        int nElems = 0;
        int j;

        arr.setElement(0, 10);
        arr.setElement(1, 8);
        arr.setElement(2, 16);
        arr.setElement(3, 5);

        nElems = 4;

        for (j = 0; j < nElems; j++) {
            System.out.println(arr.getElement(j) + " ");
        }

        int searchKey = 16;
        for (j = 0; j < nElems; j++) {
            if (arr.getElement(j) == searchKey)
                break;
        }
        if (j == nElems)
            System.out.println("Can not find " + searchKey);
        else
            System.out.println("Element " + searchKey + " was founded by index " + j);

        for (j=0; j < nElems; j++) {
            if (arr.getElement(j) == 16)
                break;
        }
        for (int k=j; k< nElems; k++)
            arr.setElement(k, arr.getElement(k+1));
        nElems--;
        for (j=0;j<nElems;j++)
            System.out.println(arr.getElement(j)+ " ");
    }
}

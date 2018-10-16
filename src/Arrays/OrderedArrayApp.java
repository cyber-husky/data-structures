package Arrays;

class OrderedArray {
    private long[] a;
    private int nElems;

    public OrderedArray(int maxSize) {
        a = new long[maxSize];
        nElems = 0;
    }

    public int size () {
        return nElems;
    }

    public int find (long searchKey){
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIndex;

        while (true) {
            curIndex = (lowerBound + upperBound) / 2;
            if (a[curIndex] == searchKey)
                return curIndex;
            else if (lowerBound > upperBound)
                return nElems;
            else {
                if (a[curIndex] < searchKey)
                    lowerBound = curIndex + 1;
                else
                    upperBound = curIndex - 1;
            }
        }
    }

    public void insert (long value) {
        int j;
        for (j=0;j<nElems;j++)
            if (a[j]> value)
                break;
         for (int k=nElems; k > j; k--)
             a[k] = a[k - 1];
         a[j]= value;
         nElems++;
    }

    public boolean delete (long value) {
        int j = find(value);
        if (j == nElems)
            return false;
        else {
            for (int k=j; k<nElems;k++)
                a[k]=a[k+1];
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int j=0; j<nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }
}


class OrderedArrayApp {
    public static void main(String[] args) {
        int maxSize = 10;
        OrderedArray arr;
        arr = new OrderedArray(maxSize);

        arr.insert(99);
        arr.insert(1);
        arr.insert(62);
        arr.insert(16);
        arr.insert(7);
        arr.insert(1029);
        arr.insert(2);

        int searchKey = 16;
        if (arr.find(searchKey) != arr.size() )
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey );

        arr.display();

        arr.delete(7);
        arr.delete(62);
        arr.delete(1029);

        arr.display();

    }
}

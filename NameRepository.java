package Iterator_Lab;

import java.util.ArrayList;
import java.util.List;

public class NameRepository implements Aggregate {
    private List<String>[] array;
    private int totalCount;
    private  NameIterator iterator;


    public NameRepository(int rowSize) {
        array = new List[rowSize];
        iterator = new NameIterator();
        for(int i = 0; i < rowSize; i++) {
            array[i] = new ArrayList<>();
        }
    }

    @Override
    public Iterator getIterator() {
        return iterator;
    }

    public void add(int row, String name) {
        array[row].add(name);
        totalCount++;
    }

    public void remove(String name) {
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].size(); j++) {
                if(array[i].get(j).equals(name)) {
                    array[i].set(j, "-");
                    totalCount--;
                    break;
                }
            }
        }
    }

    private class NameIterator implements Iterator {
        int rowIndex;
        int index;
        int totalIndex;

        @Override
        public boolean hasNext() {
            if(totalIndex < totalCount) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                totalIndex++;

               checkRowSize();

                if(array[rowIndex].get(index).equals("-")) {
                        index++;
                }

                checkRowSize();

                String srt = array[rowIndex].get(index);

                index++;
                return srt;
            }
            return null;
        }

        private void checkRowSize() {
            if(index == array[rowIndex].size()) {
                nextRow();
                if(array[rowIndex].isEmpty())
                    nextRow();
            }
        }

        private void nextRow() {
            rowIndex++;
            index = 0;
            System.out.println();
        }
    }
}

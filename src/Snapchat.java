import javax.jws.Oneway;

public class Snapchat {
    // 给一个矩阵，从一个点到另一个点（上下左右对角线都可以走），走k步（可以重复走），有多少种走法。
    // 先用BFS写，写好分析时间空间复杂度。然后小哥让提高空间复杂度。
    final int SIZE = 10;
    Object[] data;
    int size = 0;

    public Snapchat(int size) {
        this.size = size;
        data = new Object[SIZE];
    }

    public void checkCapacity(int index, Object o) {
        if (size > data.length) {
            Object[] newData = new Object[SIZE * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
//            System.arraycopy(data,0,newData,0,size);
//            System.arraycopy(data,0,newData,0,index);
            newData[index] = o;
            data = newData;
            newData = null;
        }
    }

    public int getSize() {
        return this.size;
    }

    public void add(Object o) {
        checkCapacity(this.size + 1, o);
    }

    public Object get (int index) {
        checkRange(index);
        return data[index];
    }
    private void checkRange(int index) {
        if(index > this.size || index < 0) throw new IndexOutOfBoundsException("index is invalid");
    }

    public int indexOf(Object o) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object o){
        return indexOf(o) >= 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public Object remove(int index) {
        Object value = get(index);
        int moveSize = size - index - 1;
        if (moveSize > 0){
            System.arraycopy(data,index + 1, data,index,size - index - 1);
        }
        data[--size] = null;
        return value;
    }

    public boolean remove(Object o){
        if (contains(o)){
            remove(indexOf(o));
            return true;
        }else {
            return false;
        }
    }

    public static int compress(char[] chars) {
            int res = 0, id = 0; //res marks the id of the changed chars
            while(id < chars.length) {
                int count = 0;
                char target = chars[id];
                while(id < chars.length && chars[id] == target) {
                    count++;
                    id++;
                }
                chars[res++] = target;
                if(count != 1) {
                    for(char c : Integer.toString(count).toCharArray()) {
                        chars[res++] = c;
                    }
                }
            }
            return res;
        }
    public static void main(String[] args) {
            char[] arr = {'a','c','b','a','c'};
           compress(arr);
    }
    }


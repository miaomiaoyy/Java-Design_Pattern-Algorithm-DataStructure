import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

public class IteratorEXP implements Iterator<Vector> {

        private List<Vector> examples;  //ArrayList<Vector> will be set here
        private int          index;

        public IteratorEXP(List<Vector> examples) {
            this.examples = examples;
            index = 0;
        }

        @Override
        public Vector next() {
            if(hasNext()) {
                return examples.get(index++);
            } else {
                throw new NoSuchElementException("There are no elements size = " + examples.size());
            }
        }

        @Override
        public boolean hasNext() {
            return !(examples.size() == index);
        }

        @Override
        public void remove() {
            if(index <= 0) {
                throw new IllegalStateException("You can't delete element before first next() method call");
            }
            examples.remove(--index);
        }
    }


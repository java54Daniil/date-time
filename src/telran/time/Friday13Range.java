package telran.time;

import java.time.temporal.Temporal;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Friday13Range implements Iterable<Temporal> {
	Temporal from;
	Temporal to;

    public Friday13Range(Temporal from, Temporal to) {
        this.from = from;
        this.to = to;
    }
	@Override
	public Iterator<Temporal> iterator() {
		return new FridayIterator();
	} 
	private class FridayIterator implements Iterator<Temporal>{
		 private Temporal current = from;
		@Override
		public boolean hasNext() {
			return current!= null &&!current.equals(to);
		}

		@Override
		public Temporal next() {
			 if (!hasNext()) {
	                throw new NoSuchElementException();
	            }
			 Temporal nextFriday13 = current.with(new NextFriday13());
			 current = nextFriday13.plus(1, java.time.temporal.ChronoUnit.MONTHS);
			 return nextFriday13;
		}
		
	}

}

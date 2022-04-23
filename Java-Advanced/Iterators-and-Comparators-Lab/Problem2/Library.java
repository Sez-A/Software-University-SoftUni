import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<Book> {
        private int counter = 0;
        public boolean hasNext() {
            if(this.counter < books.length) { return true; }
            return false;
        }
        public Book next() { return books[counter++]; }
    }


}
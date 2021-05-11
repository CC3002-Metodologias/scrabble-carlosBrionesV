package classes;

import java.util.Objects;

public abstract class AbstractScrab implements Scrabble {
    public abstract boolean equals(Object o);

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

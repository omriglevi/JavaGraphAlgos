package com.omri;

import java.util.Collection;

public interface Traversable <T> {
    public Collection<T> getNeighbors(final T index);
}

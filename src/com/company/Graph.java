package com.company;

import java.util.Collection;

public interface Graph <T> extends Traversable<T> {
    Node<T> getRoot() ;
    Collection<Node<T>> getReachableNodes(Node<T> node);
}

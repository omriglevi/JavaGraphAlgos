package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node <T>{
    private Node parent;
   private T data;

    public Node(@NotNull T data ,  Node parent) {
        this.parent = parent;
        this.data = data;
    }

    public Node(T data) {
      this(data,null);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
       // if (o == null || getClass() != o.getClass()) return false;?
        Node<?> node = (Node<?>) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode() {
        return this.data !=null ? data.hashCode() : 0;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public T getData() {
        return data;
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MatrixAdapter implements Graph<Index>  {
    Index root;
    private Matrix matrix;



    public MatrixAdapter(Matrix matrix) {
        this.matrix=matrix;
        this.root=new Index(0,0);
    }

    public void setRoot(Index root) {
        if(matrix.validateIndexInRangeOfMatrix(root)){
            this.root = root;
        }

    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    @Override
    public Node<Index> getRoot() {
        return new Node<>(this.root);
    }



    @Override
    public Collection<Node<Index>> getReachableNodes(Node<Index> node) {
        List <Node<Index>>  reachableNodes = new ArrayList();
        if (matrix.getValue(node.getData()) == 1){
            for( Index neighbourIndex : matrix.getNeighbors(node.getData())){
                if (matrix.getValue(neighbourIndex) == 1){
                   Node<Index> reachableNode= new Node<Index>(neighbourIndex,node) ;
                   reachableNodes.add(reachableNode);
                }
            }

        }

        return reachableNodes ;

    }

    @Override
    public Collection<Index> getNeighbors(Index index) {
        return this.matrix.getNeighbors(index);
    }
}

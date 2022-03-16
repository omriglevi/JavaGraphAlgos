package com.omri;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
	int [][] anArray=new int[][]{
            {1,0,0,0},
            {1,1,1,0},
            {0,0,1,1}
    };
    Matrix mtrx=new Matrix(anArray);
    MatrixAdapter mtrxAsGraph=new MatrixAdapter(mtrx);
    DFSConnectiveComponents dfsImpl=new DFSConnectiveComponents<>() ;
    Set<Index> dfsOutput= dfsImpl.runTraverse(mtrxAsGraph);
        System.out.println(dfsOutput);
    }
}

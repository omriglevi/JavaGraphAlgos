package com.company;


import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class DFSConnectiveComponents <T> {
    private final Stack<Node<T>> workingStack;
    private final Set<Node<T>> alreadyVisitedEdges;

    public DFSConnectiveComponents() {
        this.workingStack=new Stack();
        this.alreadyVisitedEdges = new LinkedHashSet(); // We chose linked hash set, so we will be able to follow the order of the edges visits.

    }

    public Set<T> runTraverse(@NotNull Graph<T> aGraph){
        workingStack.push(aGraph.getRoot());
        while( ! workingStack.empty()){
           Node<T> currentRemovedNode=workingStack.pop();
            alreadyVisitedEdges.add(currentRemovedNode);
           for (Node<T> reachableNode : aGraph.getReachableNodes(currentRemovedNode)){
               if ( !alreadyVisitedEdges.contains(reachableNode) &&  !workingStack.contains(reachableNode))
               {
                    workingStack.push(reachableNode);
               }
           }



        }
        Set <T> concreteDataSetOfVisitedNodes=new LinkedHashSet();
        for(Node<T> visitedNode : alreadyVisitedEdges){
            concreteDataSetOfVisitedNodes.add(visitedNode.getData());
        }
        alreadyVisitedEdges.clear();
        return concreteDataSetOfVisitedNodes ;
    }



    /*
    1100
    0100
    0111
    For Executing the algo , use method runTravers
    * This class is a Depth For Search Implementation for finding Connective Component from a given Root .
    * It only finds the component which is connected to the given root, so for example :
    * If we execute DFSConnectiveComponent Implementation on a Graph that contains MORE than
    *  a single Connective Component, the algo will only find the component which
    * connected to the given root and not the other component.
    * For finding other components we will have to optimize the algo and run it from two roots seperatly
    * */
}

package com.project.graph.algorithms

import com.project.graph.models.{Edge, TGraph, Vertex}

import scala.collection.mutable.Queue

object HaveCycle {

  def haveCycle(G:TGraph[Any]):Boolean =
  {
    //Tu też trzeba funkcji na wierzcholki w TGrafie :) -> petelka po wierzcholkach wszystkich
    val startVertexID: Int = 1

    var visited = List(startVertexID)
    var result: Boolean = false

    val q = Queue(startVertexID)

    while(q.nonEmpty) {
      val v: Int = q.front
      q.dequeue()
      val neighbours: Set[Edge[Any]] = G.getEdgesForVertex(v)
      val i = neighbours.iterator
      while (i.hasNext){
        val n: Vertex[Any] = i.next().toVertex
        if(!visited.contains(n.id))
        {
          visited = n.id :: visited
          q.enqueue(n.id)
        }
        else
          {
           result = true
          }
      }
    }
    result
  }
}

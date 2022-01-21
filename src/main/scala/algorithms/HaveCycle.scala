package com.project.graph.algorithms

import com.project.graph.models.{Edge, TGraph, Vertex}

import scala.collection.mutable.Queue

object HaveCycle {

  def apply(G:TGraph):Boolean =
  {
    var visited = List[Int]()
    var result: Boolean = false

    for(startVertexID <- G.getVertexesIDs() if !visited.contains(startVertexID)) {
      val q = Queue(startVertexID)

      while(q.nonEmpty) {
        val v: Int = q.front
        q.dequeue()
        val neighbours: Set[Edge] = G.getEdgesForVertex(v)
        val i = neighbours.iterator
        while (i.hasNext){
          val n: Vertex = i.next().toVertex
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
    }
    result
  }
}

package com.project.graph.algorithms

import com.project.graph.models.{Edge, TGraph, Vertex}

import scala.collection.mutable

object BFS {

  def bfs(G:TGraph[Any], startVertexID: Int): List[Any] = {

    var visited = List(startVertexID)
    var result = List(startVertexID)

    val q = mutable.Queue(startVertexID)

    while(q.nonEmpty)
      {
        val v: Int = q.front
        q.dequeue()
        val neighbours: Set[Edge[Any]] = G.getEdgesForVertex(v)
        val i = neighbours.iterator
        while (i.hasNext){
          val n: Vertex[Any] = i.next().toVertex
          if(!visited.contains(n.id))
          {
            visited = n.id :: visited
            result=n.id :: result
            q.enqueue(n.id)
          }
        }
      }

    result.reverse
  }

  def main(args: Array[String]): Unit = {
  }
}

package com.project.graph.algorithms

import com.project.graph.models.{Edge, TGraph, Vertex}

object TopologicalOrder {
  def sort(G:TGraph[Any]): List[Int] = {
    val startVertexID:Int = 5
    var visited = List(startVertexID)
    var result = List[Int]()

    def dfs_iter(startVertexID: Int): Unit = {
      val res : Set[Edge[Any]] = G.getEdgesForVertex(startVertexID)
      val i = res.iterator
      while (i.hasNext){
        val n: Vertex[Any] = i.next().toVertex
        if(!visited.contains(n.id))
        {
          visited = n.id :: visited
          dfs_iter(n.id)
        }
      }
      result = startVertexID::result
    }

    dfs_iter(startVertexID) //tu tez powinien byc for each XD
    result
  }
  def main(args: Array[String]): Unit = {
  }

}

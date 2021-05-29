package com.project.graph.algorithms

import com.project.graph.models.{Edge, TGraph, Vertex}

object DFS {
  def dfs(G:TGraph[Any], startVertexID: Int): List[Any] = {
    var visited = List(startVertexID)
    var result = List(startVertexID)

    def dfs_iter(startVertexID: Int): Unit = {
      val res : Set[Edge[Any]] = G.getEdgesForVertex(startVertexID)
      val i = res.iterator
      while (i.hasNext){
        val n: Vertex[Any] = i.next().toVertex
        if(!visited.contains(n.id))
        {
          visited = n.id :: visited
          result=n.id :: result
          dfs_iter(n.id)
        }
      }
    }
    dfs_iter(startVertexID)
    result.reverse
    }
  def main(args: Array[String]): Unit = {
  }
}

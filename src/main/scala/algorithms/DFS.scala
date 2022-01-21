package com.project.graph
package algorithms

import models.{Edge, TGraph, Vertex}

object DFS {
  def apply(G:TGraph, startVertexID: Int): List[Int] = {
    var visited = List(startVertexID)
    var result = List(startVertexID)

    def dfs_iter(startVertexID: Int): Unit = {
      val res : Set[Edge] = G.getEdgesForVertex(startVertexID)
      val i = res.iterator
      while (i.hasNext){
        val n: Vertex = i.next().toVertex
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
}

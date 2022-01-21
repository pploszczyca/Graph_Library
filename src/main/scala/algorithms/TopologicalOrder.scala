package com.project.graph.algorithms

import com.project.graph.models.{Edge, TGraph, Vertex}

object TopologicalOrder {
  def apply(G:TGraph): List[Int] = {
    var visited = List[Int]()
    var result = List[Int]()

    def dfs_iter(startVertexID: Int): Unit = {
      val res : Set[Edge] = G.getEdgesForVertex(startVertexID)
      val i = res.iterator
      while (i.hasNext){
        val n: Vertex = i.next().toVertex
        if(!visited.contains(n.id))
        {
          visited = n.id :: visited
          dfs_iter(n.id)
        }
      }
      result = startVertexID::result
    }

    for(startVertexID <- G.getVertexesIDs() if !visited.contains(startVertexID)){
      visited = startVertexID :: visited
      dfs_iter(startVertexID)
    }
    result
  }

}

package com.project.graph.algorithms

import com.project.graph.models.{Graph, TGraph}

object IsConnected {
  def apply(G:TGraph):Boolean = {
    val size : Int = G.getVertexesAmount()

    val sizeFound:Int = DFS(G,G.getVertexesIDs().head).length
    size == sizeFound
  }
}

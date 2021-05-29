package com.project.graph.algorithms

import com.project.graph.models.{Graph, TGraph}

object IsConnected {

  def connected(G:TGraph[Any]):Boolean = {
    val size : Int = G.getVertexesAmount()
    val sizeFound:Int = DFS.dfs(G,1).length  //do zmiany, konieczna funkcja zwracajaca wierzcholki/wierzcholek dowolny
    size == sizeFound
  }
  def main(args: Array[String]): Unit = {
  }
}

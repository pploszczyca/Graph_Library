package com.project.graph
package models

import models.GraphType._

object GraphBuilder {
  def apply[V](edges: List[Edge[V]], graphType: GraphType): TGraph[V] = graphType match {
    case Directed => buildGraph(edges, new Graph[V]())
    case Undirected => buildGraph(edges, new UndirectedGraph[V]())
    case _ => null.asInstanceOf[TGraph[V]]
  }

  private def buildGraph[V](edges: List[Edge[V]], graph: TGraph[V]): TGraph[V] = {
    for(edge <- edges){
      graph.addEdge(edge)
    }

    graph
  }
}

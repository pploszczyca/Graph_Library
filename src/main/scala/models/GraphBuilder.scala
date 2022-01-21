package com.project.graph
package models

import models.GraphType._

object GraphBuilder {
  def apply(edges: List[Edge], graphType: GraphType): TGraph = graphType match {
    case Directed => buildGraph(edges, new Graph())
    case Undirected => buildGraph(edges, new UndirectedGraph())
    case _ => null.asInstanceOf[TGraph]
  }

  private def buildGraph[V](edges: List[Edge], graph: TGraph): TGraph = {
    for(edge <- edges){
      graph.addEdge(edge)
    }

    graph
  }
}

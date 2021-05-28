package com.project.graph
package models

class UndirectedGraph extends Graph with TGraph {
  override def addEdge(firstVertexID: Int, secondVertexID: Int): Unit = {
    super.addEdge(firstVertexID, secondVertexID)
    super.addEdge(secondVertexID, firstVertexID)
  }

  override def addEdge(edge: Edge): Unit = {
    super.addEdge(edge)
    super.addEdge(edge.toVertex -> edge.fromVertex)
  }

  override def removeEdge(firstVertexID: Int, secondVertexID: Int): Unit = {
    super.removeEdge(firstVertexID, secondVertexID)
    super.removeEdge(secondVertexID, firstVertexID)
  }

  override def removeEdge(edge: Edge): Unit = {
    super.removeEdge(edge)
    super.removeEdge(edge.toVertex -> edge.fromVertex)
  }
}

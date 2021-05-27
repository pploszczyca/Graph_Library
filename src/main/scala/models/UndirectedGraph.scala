package com.project.graph
package models

class UndirectedGraph[V] extends Graph[V] with TGraph[V] {
  override def addEdge(firstVertexID: Int, secondVertexID: Int): Unit = {
    super.addEdge(firstVertexID, secondVertexID)
    super.addEdge(secondVertexID, firstVertexID)
  }

  override def addEdge(edge: Edge[V]): Unit = {
    super.addEdge(edge)
    super.addEdge(edge.toVertex -> edge.fromVertex)
  }

  override def removeEdge(firstVertexID: Int, secondVertexID: Int): Unit = {
    super.removeEdge(firstVertexID, secondVertexID)
    super.removeEdge(secondVertexID, firstVertexID)
  }

  override def removeEdge(edge: Edge[V]): Unit = {
    super.removeEdge(edge)
    super.removeEdge(edge.toVertex -> edge.fromVertex)
  }
}

package com.project.graph
package models

trait TGraph[V]{
  def addVertex(vertexID: Int): Unit

  def removeVertex(vertexID: Int): Unit

  def addEdgeByLabels(firstVertexID: Int, secondVertexID: Int): Unit

  def removeEdgeByLabels(firstVertexID: Int, secondVertexID: Int): Unit

  def addEdge(edge: Edge[V]): Unit
  def +(edge: Edge[V]): Unit = addEdge(edge)

  def removeEdge(edge: Edge[V]): Unit
  def -(edge: Edge[V]): Unit = removeEdge(edge)

  def getVertex(vertexID: Int): Vertex[V]

  def getVertexesAmount(): Int

  def getEdgesForVertex(vertexID: Int): List[Vertex[V]]

  def hasVertex(vertexID: Int): Boolean
  def hasVertex(vertex: Vertex[V]): Boolean

  def hasEdge(firstVertexID: Int, secondVertexID: Int): Boolean
  def hasEdge(edge: Edge[V]): Boolean

  def printVertex(vertexID: Int): Unit
}

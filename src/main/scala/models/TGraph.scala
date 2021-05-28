package com.project.graph
package models


trait TGraph{
  def addVertex(vertexID: Int): Unit

  def addVertex(vertex: Vertex): Unit

  def removeVertex(vertexID: Int): Unit

  def removeVertex(vertex: Vertex): Unit

  def addEdge(firstVertexID: Int, secondVertexID: Int): Unit
  def addEdge(edge: Edge): Unit
  def +(edge: Edge): Unit = addEdge(edge)

  def removeEdge(firstVertexID: Int, secondVertexID: Int): Unit
  def removeEdge(edge: Edge): Unit
  def -(edge: Edge): Unit = removeEdge(edge)

  def getVertex(vertexID: Int): Vertex

  def getVertexesAmount(): Int

  def getEdgesForVertex(vertexID: Int): Set[Edge]

  def hasVertex(vertexID: Int): Boolean
  def hasVertex(vertex: Vertex): Boolean

  def hasEdge(firstVertexID: Int, secondVertexID: Int): Boolean
  def hasEdge(edge: Edge): Boolean

  def printVertex(vertexID: Int): Unit
}

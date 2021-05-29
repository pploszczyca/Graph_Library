package com.project.graph
package models

import scala.collection.mutable.{Map => MutableMap}
import scala.collection.mutable.{Set => MutableSet}

class Graph[V] extends TGraph[V] {
  var vertexes :MutableMap[Int, Vertex[V]] = MutableMap[Int, Vertex[V]]()
  var edges :MutableMap[Int, MutableSet[Edge[V]]] = MutableMap[Int, MutableSet[Edge[V]]]()    // key is for fromVertex

  override def addVertex(vertexID: Int): Unit = {
    addVertex(new Vertex[V](vertexID))
  }

  override def addVertex(vertex: Vertex[V]): Unit = {
    if (!hasVertex(vertex)){
      vertexes += (vertex.id -> vertex)
      edges += (vertex.id -> MutableSet[Edge[V]]())
    }
  }
  override def removeVertex(vertexID: Int): Unit = {
    vertexes -= vertexID;

    for(anotherVertexID <- edges.keys)  removeEdge(vertexID, anotherVertexID);
  }

  override def removeVertex(vertex: Vertex[V]): Unit = {
    removeVertex(vertex.id)
  }

  override def addEdge(firstVertexID: Int, secondVertexID: Int): Unit = {
    addVertex(firstVertexID);
    addVertex(secondVertexID);
    addEdge(getVertex(firstVertexID) -> getVertex(secondVertexID));
  }

  override def removeEdge(firstVertexID: Int, secondVertexID: Int): Unit = {
    edges(firstVertexID) -= new Edge[V](firstVertexID, secondVertexID)
  }

  override def addEdge(edge: Edge[V]): Unit = {
    addVertex(edge.fromVertex);
    addVertex(edge.toVertex);
    edges(edge.fromVertex.id) += edge
  }

  override def removeEdge(edge: Edge[V]): Unit = {
    edges(edge.fromVertex.id) -= edge
  }

  override def getVertex(vertexID: Int): Vertex[V] = vertexes getOrElse (vertexID, null.asInstanceOf[Vertex[V]])

  override def getVertexesAmount(): Int = vertexes.size

  override def getEdgesForVertex(vertexID: Int): Set[Edge[V]] = edges(vertexID).toSet

  override def hasVertex(vertexID: Int): Boolean = vertexes contains vertexID

  override def hasVertex(vertex: Vertex[V]): Boolean = hasVertex(vertex.id)

  override def hasEdge(edge: Edge[V]): Boolean = getEdgesForVertex(edge.fromVertex.id) contains edge

  override def hasEdge(firstVertexID: Int, secondVertexID: Int): Boolean = hasVertex(firstVertexID) && hasVertex(secondVertexID) && hasEdge(getVertex(firstVertexID)-> getVertex(secondVertexID))

  override def printVertex(vertexID: Int): Unit = vertexes(vertexID).toString

  def BFS(startVertexID: Int):Unit = {

  }

}

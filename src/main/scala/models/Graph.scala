package com.project.graph
package models

import scala.collection.mutable.{Map => MutableMap}
import scala.collection.mutable.{Set => MutableSet}

class Graph extends TGraph {
  var vertexes :MutableMap[Int, Vertex] = MutableMap[Int, Vertex]()
  var edges :MutableMap[Int, MutableSet[Edge]] = MutableMap[Int, MutableSet[Edge]]()    // key is for fromVertex

  override def addVertex(vertexID: Int): Unit = {
    addVertex(new Vertex(vertexID))
  }

  override def addVertex(vertex: Vertex): Unit = {
    if (!hasVertex(vertex)){
      vertexes += (vertex.id -> vertex)
      edges += (vertex.id -> MutableSet[Edge]())
    }
  }

  override def removeVertex(vertexID: Int): Unit = {
    vertexes -= vertexID;

    for(anotherVertexID <- edges.keys)  removeEdge(vertexID, anotherVertexID);
  }

  override def removeVertex(vertex: Vertex): Unit = {
    removeVertex(vertex.id)
  }

  override def addEdge(firstVertexID: Int, secondVertexID: Int): Unit = {
    addVertex(firstVertexID);
    addVertex(secondVertexID);
    addEdge(getVertex(firstVertexID) -> getVertex(secondVertexID));
  }

  override def removeEdge(firstVertexID: Int, secondVertexID: Int): Unit = {
    edges(firstVertexID) -= new Edge(firstVertexID, secondVertexID)
  }

  override def addEdge(edge: Edge): Unit = {
    addVertex(edge.fromVertex);
    addVertex(edge.toVertex);
    edges(edge.fromVertex.id) += edge
  }

  override def removeEdge(edge: Edge): Unit = {
    edges(edge.fromVertex.id) -= edge
  }

  override def getVertex(vertexID: Int): Vertex = vertexes getOrElse (vertexID, null.asInstanceOf[Vertex])

  override def getVertexesAmount(): Int = vertexes.size

  override def getEdgesForVertex(vertexID: Int): Set[Edge] = edges(vertexID).toSet

  override def hasVertex(vertexID: Int): Boolean = vertexes contains vertexID

  override def hasVertex(vertex: Vertex): Boolean = hasVertex(vertex.id)

  override def hasEdge(edge: Edge): Boolean = getEdgesForVertex(edge.fromVertex.id) contains edge

  override def hasEdge(firstVertexID: Int, secondVertexID: Int): Boolean = hasVertex(firstVertexID) && hasVertex(secondVertexID) && hasEdge(getVertex(firstVertexID)-> getVertex(secondVertexID))

  override def printVertex(vertexID: Int): Unit = vertexes(vertexID).toString
}

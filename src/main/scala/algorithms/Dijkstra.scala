package com.project.graph
package algorithms

import models.{Edge, TGraph}

import scala.collection.mutable
import scala.collection.mutable.{Map => MutableMap}

object Dijkstra {
  private val parents = MutableMap[Int, Int]()
  private val distance = MutableMap[Int, Double]()

  private def relax(edge: Edge): Boolean = {
    if (distance(edge.fromVertex.id) + edge.value < distance(edge.toVertex.id)){
      distance(edge.toVertex.id) = distance(edge.fromVertex.id) + edge.value
      parents(edge.toVertex.id) = edge.fromVertex.id
      return true
    }
    false
  }

  private def getParent(endVertexID: Int): List[Int] = {
    var tmpVertex = endVertexID
    var result = List[Int]()

    while(parents(tmpVertex) != -1) {
      result = tmpVertex :: result
      tmpVertex = parents(tmpVertex)
    }
    result = tmpVertex :: result

    result
  }

  def apply(G: TGraph, startVertexID: Int, endVertexID: Int): (List[Int], Double) = {
    val vertexes = G.getVertexesIDs()

    vertexes.foreach(v => {
      parents += (v -> -1)
      distance += (v -> Integer.MAX_VALUE)
    })

    distance(startVertexID) = 0
    val q = mutable.Queue(startVertexID)

    while (q.nonEmpty) {
      val v = q.front
      q.dequeue()

      val vEdges = G.getEdgesForVertex(v)

      vEdges.filter(relax).map(_.toVertex.id).foreach(v => q.enqueue(v) )
    }

    (getParent(endVertexID), distance(endVertexID))

  }
}

package com.project.graph
package models

class Edge(val fromVertex: Vertex, val toVertex: Vertex, val value: Double = 0) {

  def this(fromVertexID: Int, toVertexID: Int){
    this(new Vertex(fromVertexID), new Vertex(toVertexID))
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Edge]

  override def equals(other: Any): Boolean = other match {
    case that: Edge =>
      (that canEqual this) &&
        fromVertex == that.fromVertex &&
        toVertex == that.toVertex
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(fromVertex, toVertex)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString: String = "Edge: " + fromVertex.id.toString + " -> " + toVertex.id.toString
}

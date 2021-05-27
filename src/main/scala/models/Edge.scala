package com.project.graph
package models

class Edge[V](val fromVertex: Vertex[V], val toVertex: Vertex[V], val value: V = null.asInstanceOf[V]) {

  def this(fromVertexID: Int, toVertexID: Int){
    this(new Vertex[V](fromVertexID), new Vertex[V](toVertexID))
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Edge[V]]

  override def equals(other: Any): Boolean = other match {
    case that: Edge[V] =>
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

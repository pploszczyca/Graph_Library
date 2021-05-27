package com.project.graph
package models

class Vertex[V] (val id: Int, val name: String = null, val value: V = null.asInstanceOf[V]){

  def ->(other: Vertex[V]): Edge[V] = new Edge[V](this, other, value)    // for making new Edge

  override def toString: String = "Vertex id: " + id.toString + " name: " + name + " value: " + value.toString

  def canEqual(other: Any): Boolean = other.isInstanceOf[Vertex[V]]

  override def equals(other: Any): Boolean = other match {
    case that: Vertex[V] =>
      (that canEqual this) &&
        id == that.id
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(id)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

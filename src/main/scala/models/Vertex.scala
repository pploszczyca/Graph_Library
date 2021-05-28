package com.project.graph
package models

class Vertex (val id: Int, val name: String = "", val value: Double = 0){

  def ->(other: Vertex): Edge = new Edge(this, other, value)    // for making new Edge

  override def toString: String = "Vertex id: " + id.toString + " name: " + name + " value: " + value.toString

  def canEqual(other: Any): Boolean = other.isInstanceOf[Vertex]

  override def equals(other: Any): Boolean = other match {
    case that: Vertex =>
      (that canEqual this) &&
        id == that.id
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(id)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

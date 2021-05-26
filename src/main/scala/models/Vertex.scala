package com.project.graph
package models

class Vertex[V] (val id: Int, val name: String, val value: V){
  def ->(other: Vertex[V]): Edge[V] = new Edge[V](this, other)
}

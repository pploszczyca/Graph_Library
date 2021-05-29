package com.project.graph
package algorithms

import com.project.graph.models.GraphType.Directed
import com.project.graph.models.{Edge, GraphBuilder}
import org.scalatest.FunSuite

class DijkstraTest extends FunSuite {
  test("Get parents first") {
    val edges: List[Edge] = new Edge(0,1,1) :: new Edge(0,3,3) :: new Edge(0,2,4) :: new Edge(1,3,1) :: new Edge(2,3,3) :: Nil
    val graph = GraphBuilder(edges, Directed)

    assert(Dijkstra(graph, 0,3) === (List(0,1,3), 2))
  }

  test("Get parents second") {
    val edges: List[Edge] = new Edge(0,1,1) :: new Edge(0,3,3) :: new Edge(0,2,4) :: new Edge(1,3,1) :: new Edge(2,3,3) :: new Edge(3,2,1) :: Nil
    val graph = GraphBuilder(edges, Directed)

    assert(Dijkstra(graph, 0,2) === (List(0,1,3,2), 3))
  }
}

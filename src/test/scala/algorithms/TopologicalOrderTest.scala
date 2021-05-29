package com.project.graph.algorithms

import com.project.graph.models.Graph
import org.scalatest.FunSuite

class TopologicalOrderTest extends FunSuite {
  test("Topological sort Test") {
    val graph = new Graph[Any]

    graph.addEdge(5, 0)
    graph.addEdge(5, 2)
    graph.addEdge(2, 3)
    graph.addEdge(3, 1)
    graph.addEdge(4, 0)
    graph.addEdge(4, 1)
    graph.addEdge(5,4)

    assert(TopologicalOrder.sort(graph)==List(5,4,2,3,1,0))
  }
}

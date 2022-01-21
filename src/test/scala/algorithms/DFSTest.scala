package com.project.graph.algorithms

import com.project.graph.models.Graph
import org.scalatest.FunSuite

class DFSTest extends FunSuite {
  test("DFS Test")
  {
    val graph = new Graph
    graph.addEdge(1, 2)
    graph.addEdge(2, 3)
    graph.addEdge(2, 4)
    graph.addEdge(4, 5)

    val res : List[Any] = DFS(graph,1)
    assert(res === List(1,2,3,4,5))
  }
}

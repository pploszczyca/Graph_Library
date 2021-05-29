package com.project.graph.algorithms

import com.project.graph.models.Graph
import org.scalatest.FunSuite

class HaveCycleTest extends FunSuite {
  test("Cyclic Test")
  {
    val cyclicGraph = new Graph[Any]
    cyclicGraph.addEdge(1, 2)
    cyclicGraph.addEdge(2, 3)
    cyclicGraph.addEdge(2, 1)
    cyclicGraph.addEdge(4, 5)

    val notCyclicGraph = new Graph[Any]
    notCyclicGraph.addEdge(1, 2)
    notCyclicGraph.addEdge(2, 3)
    notCyclicGraph.addEdge(2, 4)
    notCyclicGraph.addEdge(4, 5)

    assert(HaveCycle.haveCycle(cyclicGraph) == true)
    assert(HaveCycle.haveCycle(notCyclicGraph) == false)
  }
}

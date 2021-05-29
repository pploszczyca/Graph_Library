package com.project.graph.algorithms

import com.project.graph.models.Graph
import org.scalatest.FunSuite

class IsConnectedTest extends FunSuite {
  test("Connectivity Test")
  {
    val graphConnected = new Graph[Any]

    graphConnected.addEdge(1, 2)
    graphConnected.addEdge(2, 3)
    graphConnected.addEdge(2, 4)
    graphConnected.addEdge(4, 5)

    assert(IsConnected.connected(graphConnected) == true)

    val graphDisconnected = new Graph[Any]

    graphDisconnected.addEdge(1, 2)
    graphDisconnected.addEdge(2, 3)
    graphDisconnected.addEdge(5, 4)
    graphDisconnected.addEdge(4, 5)

    assert(IsConnected.connected(graphDisconnected) == false)
  }
}

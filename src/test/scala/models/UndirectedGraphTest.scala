package com.project.graph
package models

import org.scalatest.FunSuite

class UndirectedGraphTest extends FunSuite{
  test("Adding and removing edges") {
    val undirectedGraph = new UndirectedGraph[Int]()

    undirectedGraph.addEdge(1,2)
    undirectedGraph.addEdge(2,3)
    undirectedGraph.addEdge(1,3)

    assert(undirectedGraph.hasEdge(1,2) === true)
    assert(undirectedGraph.hasEdge(2,1) === true)
    assert(undirectedGraph.hasEdge(2,3) === true)
    assert(undirectedGraph.hasEdge(3,2) === true)
    assert(undirectedGraph.hasEdge(1,3) === true)
    assert(undirectedGraph.hasEdge(3,1) === true)

    assert(undirectedGraph.getVertexesAmount() === 3)

    undirectedGraph.removeEdge(2,1)
    assert(undirectedGraph.hasEdge(1,2) === false)
    assert(undirectedGraph.hasEdge(2,1) === false)
    assert(undirectedGraph.hasEdge(2,3) === true)
    assert(undirectedGraph.hasEdge(3,2) === true)
    assert(undirectedGraph.hasEdge(1,3) === true)
    assert(undirectedGraph.hasEdge(3,1) === true)

    undirectedGraph.removeEdge(2,3)
    assert(undirectedGraph.hasEdge(2,3) === false)
    assert(undirectedGraph.hasEdge(3,2) === false)

    undirectedGraph.addEdge(2,3)
    assert(undirectedGraph.hasEdge(2,3) === true)
    assert(undirectedGraph.hasEdge(3,2) === true)
  }
}

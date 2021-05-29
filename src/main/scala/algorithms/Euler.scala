package com.project.graph
package algorithms

import models.{Edge, TGraph}

object Euler {
  def isEulerian(G: TGraph): Boolean = {
    IsConnected(G) && G.getVertexesIDs().filter(G.getEdgesForVertex(_).size %2 == 1).length == 0
  }

  def eulerCicle(G: TGraph): List[Int] = {
    val GCopy: TGraph = G.cloneGraph()
    var stack = List[Int](GCopy.getVertexesIDs()(0))
    var result = List[Int]()

    def DFSVisit(): Unit = {
      val v = stack.last

      GCopy.getEdgesForVertex(v).map(_.toVertex.id).foreach(n => {
        if(GCopy.hasEdge(n,v)){
          stack = stack :+ n

          GCopy.removeEdge(v,n)
          DFSVisit()
        }

      })

      result = result :+ stack.last
      stack = stack.init
    }

    if (isEulerian(GCopy)) {
      DFSVisit()
    }
    result
  }
}

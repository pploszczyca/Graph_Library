package com.project.graph
package algorithms

import models.TGraph

object Euler {
  def isEulerian(G: TGraph): Boolean = {
    IsConnected(G) && !G.getVertexesIDs().exists(G.getEdgesForVertex(_).size % 2 == 1)
  }

  def eulerCicle(G: TGraph): List[Int] = {
    val GCopy: TGraph = G.cloneGraph()
    var stack = List[Int](GCopy.getVertexesIDs().head)
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

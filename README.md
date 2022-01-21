# Graph Library
## Description
Project for Scala classes, that provides library for Graph operations with basic algorithms.

## Technologies
* Scala
* sbt
* scalatest

## Features
* Implemented models
  * [Vertex](src/main/scala/models/Vertex.scala),
  * [Edge](src/main/scala/models/Edge.scala),
  * [Graph's Trait](src/main/scala/models/TGraph.scala):
    * [Directed Graph](src/main/scala/models/Graph.scala),
    * [Undirected Graph](src/main/scala/models/UndirectedGraph.scala),
* [Build graph from file](src/main/scala/models/GraphBuilder.scala),
* [Save graph to file](src/main/scala/models/GraphBuilder.scala),
* Graph algorithms:
  * [BFS](src/main/scala/algorithms/BFS.scala),
  * [DFS](src/main/scala/algorithms/DFS.scala),
  * [Dijkstra Shortest Path](src/main/scala/algorithms/Dijkstra.scala),
  * [Is the graph Eulerian](src/main/scala/algorithms/Euler.scala),
  * [Eulerian path](src/main/scala/algorithms/Euler.scala),
  * [Check if the graph has a cycle](src/main/scala/algorithms/HaveCycle.scala),
  * [Check if graph is connected](src/main/scala/algorithms/IsConnected.scala),
  * [Topological Order](src/main/scala/algorithms/TopologicalOrder.scala).

## Examples
Examples of using this library are showed in [test folder](src/test/scala/) for [models](src/test/scala/models) and [algorithms](src/test/scala/algorithms).

## Input/Output file format
Every single line is edge with from/to vertex ID with edge's value:
```
[From Vertex ID] [To Vertex ID] [Value]
```
Example:
```
0 1 1
0 2 0
1 2 0
2 3 1
2 4 3
3 4 0
```

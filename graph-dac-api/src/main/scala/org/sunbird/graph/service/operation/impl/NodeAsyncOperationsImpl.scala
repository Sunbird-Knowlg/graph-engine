package org.sunbird.graph.service.operation.impl

import com.fasterxml.jackson.annotation.JsonValue
import org.sunbird.graph.dac.model.Node
import org.sunbird.graph.service.operation.NodeAsyncOperations

import scala.collection.mutable
import scala.util.{Failure, Success, Try}
import scala.concurrent.Future
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.janusgraph.core.JanusGraph
import org.sunbird.graph.dac.util.GraphConnectorUtil

class NodeAsyncOperationsImpl extends NodeAsyncOperations {

  val graphConnection = new GraphConnectorUtil()

  override def addNode(graphId: String, node: Node) = {
    if(graphId.isBlank) { println("Exception for blank graphId")}
    if(node == null) { println("Exception for node value is null ")}
//    val parameterMap = mutable.Map[String, AnyRef]
//    setPrimitiveData(node.getMetadata)

    graphConnection.initialiseGraphClient()
    val g: GraphTraversalSource = graphConnection.getGts
    val graph: JanusGraph = graphConnection.getGraph

    g.addV(node.getGraphId).property("ObjectType","Collection").next()

    val vertex = g.V(node.getGraphId).property("ObjectType","Collection").valueMap()
    println(" vertex details found !"+vertex)

//    graphConnection.closeClient()

  }

  override def upsertNode(graphId: String, node: Node, request: String): Future[Node] = ???

  override def updateNodes(graphId: String, identifiers: List[String], node: Node): Future[Map[String, Node]] = ???

  override def upsertRootNode(graphId: String, node: Node, request: String): Future[Node] = ???

  override def deleteNode(graphId: String, nodeId: String, request: String): Future[Boolean] = ???

  def setPrimitiveData(metadata: mutable.Map[String, AnyRef]): mutable.Map[String, AnyRef] = {
    metadata.map { case (key, value) =>
      val newValue = value match {
        case v: mutable.Map[_, _] => Try("JsonUtils.serialize(v)")
        case v: List[_] if v.nonEmpty && v.head.isInstanceOf[mutable.Map[_, _]] => Try("JsonUtils.serialize(v)")
        case _ => Success(value)
      }
      newValue match {
        case Success(v) => key -> v
        case Failure(e) =>
          println(s"Exception Occurred While Processing Primitive Data Types | Exception is : ${e.getMessage}", e)
          key -> value
      }
    }
  }


}

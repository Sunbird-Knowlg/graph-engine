package org.sunbird.graph.service.operation.impl

import org.sunbird.graph.dac.model.Node
import org.sunbird.graph.service.operation.NodeAsyncOperations
import scala.concurrent.Future

class NodeAsyncOperationsImpl extends NodeAsyncOperations {

  override def addNode(graphId: String, node: Node): Future[Node] = ???

  override def upsertNode(graphId: String, node: Node, request: String): Future[Node] = ???

  override def updateNodes(graphId: String, identifiers: List[String], node: Node): Future[Map[String, Node]] = ???

  override def upsertRootNode(graphId: String, node: Node, request: String): Future[Node] = ???

  override def deleteNode(graphId: String, nodeId: String, request: String): Future[Boolean] = ???


}

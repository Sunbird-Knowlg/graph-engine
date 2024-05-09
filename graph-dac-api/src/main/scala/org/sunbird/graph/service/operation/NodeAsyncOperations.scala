package org.sunbird.graph.service.operation

import scala.concurrent.Future
import org.sunbird.graph.dac.model.Node

trait NodeAsyncOperations {
    def addNode(graphId: String, node: Node): Future[Node]
    def upsertNode(graphId: String, node: Node, request: String): Future[Node]
    def updateNodes(graphId: String, identifiers:List[String], node: Node): Future[Map[String, Node]]
    def upsertRootNode(graphId: String, node: Node, request: String): Future[Node]
    def deleteNode(graphId: String, nodeId: String, request: String): Future[Boolean]


}

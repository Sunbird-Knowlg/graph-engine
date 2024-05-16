package org.sunbird.graph.dac.util

import org.sunbird.graph.dac.model.Node
import org.sunbird.graph.service.operation.NodeAsyncOperations
import org.sunbird.graph.service.operation.impl.NodeAsyncOperationsImpl

import scala.collection.mutable.Map

object NodeUtil {

  val nodeOperations = new NodeAsyncOperationsImpl()

  def main(args: Array[String]): Unit = {

    val graphId :String= "domain-1"
    val metadata: Map[String, AnyRef] = Map("IL_UNIQUE_ID" ->"do_124", "IL_SYS_NODE_TYPE"->"DATA_NODE", "IL_FUNC_OBJECT_TYPE"->"Collection")
    val node = new Node()
    println( "addRelations ->" +node.getAddedRelations +" graphId --> "+node.getGraphId)
    node.setGraphId(graphId)
    node.setMetadata(metadata)

    println( "getMetadata ->" +node.getMetadata +" graphId --> "+node.getGraphId)
    nodeOperations.addNode(graphId, node)

  }
}



package org.sunbird.graph.dac.model

import java.util
import java.util.Map

trait Relation {

  def getRelationType(): String
  def setRelationType(relationType: String): Unit
  def getStartNodeId(): String
  def setStartNodeId(startNodeId: String): Unit
  def getEndNodeId(): String
  def setEndNodeId(endNodeId: String): Unit
  def getMetadata(): Map[String, Object]
  def updateMetadata(metadata: Map[String, Object]): Unit
  def setMetadata(metadata: Map[String, Object]): Unit
  def getGraphId(): String
  def setGraphId(graphId: String): Unit
  def getId(): Long
  def setId(id: Long): Unit
  def getStartNodeName(): String
  def setStartNodeName(startNodeName: String): Unit
  def getEndNodeName(): String
  def setEndNodeName(endNodeName: String): Unit
  def getStartNodeType(): String
  def setStartNodeType(startNodeType: String): Unit
  def getEndNodeType(): String
  def setEndNodeType(endNodeType: String): Unit
  def getStartNodeObjectType(): String
  def setStartNodeObjectType(startNodeObjectType: String): Unit
  def getEndNodeObjectType(): String
  def setEndNodeObjectType(endNodeObjectType: String): Unit
  def getStartNodeMetadata(): Map[String, Object]
  def setStartNodeMetadata(startNodeMetadata: Map[String, Object]): Unit
  def getEndNodeMetadata(): Map[String, Object]
  def setEndNodeMetadata(endNodeMetadata: Map[String, Object]): Unit

}

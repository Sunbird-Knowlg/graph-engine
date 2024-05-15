package org.sunbird.graph.dac.model

import java.util
import java.util.Map

class Relation extends Serializable {

  private var id: Long = _
  private var graphId: String = _
  private var relationType: String = _
  private var startNodeId: String = _
  private var endNodeId: String = _
  private var startNodeName: String = _
  private var endNodeName: String = _
  private var startNodeType: String = _
  private var endNodeType: String = _
  private var startNodeObjectType: String = _
  private var endNodeObjectType: String = _
  private var metadata: util.Map[String, AnyRef] = _
  private var startNodeMetadata: util.Map[String, AnyRef] = _
  private var endNodeMetadata: util.Map[String, AnyRef] = _



}

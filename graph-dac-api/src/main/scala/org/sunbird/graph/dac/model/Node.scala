package org.sunbird.graph.dac.model

import org.apache.commons.lang3.StringUtils

import scala.collection.mutable.{ListBuffer, Map}

class Node extends Serializable {

    private var id: Long = _
    private var graphId: String = _
    private var identifier: String = _
    private var nodeType: String = _
    private var objectType: String = _
    private var metadata: Map[String, AnyRef] = _
    private var outRelations: List[Relation] = _
    private var inRelations: List[Relation] = _
    private var addedRelations: List[Relation] = _
    private var deletedRelations: List[Relation] = _
//    private var addedRelations: ListBuffer[Relation] = ListBuffer()
//    private var deletedRelations: ListBuffer[Relation] = ListBuffer()
    private var relationNodes: Map[String, Node] = _
    private var externalData: Map[String, AnyRef] = _


//    def this() {
//      this()
//      addedRelations = ListBuffer[Relation]
//      deletedRelations = ListBuffer[Relation]
//    }

    def this(identifier: String, nodeType: String, objectType: String) {
      this()
      this.identifier = identifier
      this.nodeType = nodeType
      this.objectType = objectType
    }

    def this(graphId: String, metadata: Map[String, AnyRef]) {
      this()
      this.graphId = graphId
      this.metadata = metadata
      if (null != metadata && metadata.nonEmpty) {
        if (null != metadata("IL_UNIQUE_ID").toString)
          this.identifier = metadata("IL_UNIQUE_ID").toString
        if (null != metadata("IL_SYS_NODE_TYPE").toString)
          this.nodeType = metadata("IL_SYS_NODE_TYPE").toString
        if (null != metadata("IL_FUNC_OBJECT_TYPE").toString)
          this.objectType = metadata("IL_FUNC_OBJECT_TYPE").toString
      }
    }

    def getId: Long = id
    def setId(id: Long): Unit = {
      this.id = id
    }
    def getGraphId: String = graphId
    def setGraphId(graphId: String): Unit = {
      this.graphId = graphId
    }

    def getIdentifier():String= {
      if(StringUtils.isBlank(identifier) && null != metadata)
        this.identifier = metadata.get("IL_UNIQUE_ID").asInstanceOf[String]
      identifier
    }

    def setIdentifier(identifier: String): Unit = {
      this.identifier = identifier
    }

    def getNodeType(): String = {
      if (StringUtils.isBlank(nodeType) && null != metadata)
        this.nodeType = metadata.get("IL_SYS_NODE_TYPE").asInstanceOf[String]
      nodeType
    }

    def setNodeType(nodeType: String): Unit = {
      this.nodeType = nodeType
    }

    def getObjectType(): String = {
      if (StringUtils.isBlank(objectType) && null != metadata)
        this.objectType = metadata.get("IL_FUNC_OBJECT_TYPE").asInstanceOf[String]
      objectType
    }

    def setObjectType(nodeType: String): Unit = {
      this.objectType = nodeType
    }

    def getMetadata: Map[String, AnyRef] = metadata

    def setMetadata(metadata: Map[String, AnyRef]): Unit = {
      this.metadata = metadata
    }

  def getOutRelations(): List[Relation] = {
    if (outRelations != null && outRelations.nonEmpty)
      outRelations
    else
      List.empty[Relation]
  }

  def setOutRelations(outRelations: List[Relation]): Unit = {
    this.outRelations = outRelations
  }

  def getInRelations(): List[Relation] = {
    if (inRelations != null && inRelations.nonEmpty)
      inRelations
    else
      List.empty[Relation]
  }

  def setInRelations(inRelations: List[Relation]): Unit = {
    this.inRelations = inRelations
  }

  def getAddedRelations: List[Relation] = addedRelations

  def setAddedRelations(addedRelations: List[Relation]): Unit = {
    if (this.addedRelations == null || this.addedRelations.isEmpty)
      this.addedRelations = List.empty[Relation]
    this.addedRelations ++= addedRelations
  }

  def getDeletedRelations: List[Relation] = deletedRelations

  def setDeletedRelations(deletedRelations: List[Relation]): Unit = {
    this.deletedRelations = deletedRelations
  }

  def getExternalData: Map[String, Object] = externalData

  def setExternalData(externalData: Map[String, Object]): Unit = {
    this.externalData = externalData
  }

  def getRelationNodes: Map[String, Node] = relationNodes

  def setRelationNodes(relationNodes: Map[String, Node]): Unit = {
    this.relationNodes = relationNodes
  }

  def getNode: Node = this

  def getRelationNode(identifier: String): Node = {
    relationNodes.get(identifier).orNull
  }

  def getArtifactUrl: String = {
    this.metadata.getOrElse("artifactUrl", "").asInstanceOf[String]
  }


}

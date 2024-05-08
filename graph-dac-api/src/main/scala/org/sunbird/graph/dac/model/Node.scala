package org.sunbird.graph.dac.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.apache.commons.collections4.CollectionUtils
import org.apache.commons.lang3.StringUtils
import java.util
class Node extends Serializable {

    var id: Long = _
    var graphId: String = _
    var identifier: String = _
    var nodeType: String = _
    var objectType: String = _
    var metadata: util.Map[String, AnyRef] = _
    var outRelations: util.List[Relation] = _
    var inRelations: util.List[Relation] = _
    var addedRelations: util.List[Relation] = _
    var deletedRelations: util.List[Relation] = _
    var relationNodes: util.Map[String, Node] = _
    var externalData: util.Map[String, AnyRef] = _

    def this(){
        this()
        addedRelations = new util.ArrayList[Relation]()
        deletedRelations = new util.ArrayList[Relation]()
    }

    def this(identifier: String, nodeType: String, objectType: String) {
        this()
        this.identifier = identifier
        this.nodeType = nodeType
        this.objectType = objectType
        addedRelations = new util.ArrayList[Relation]()
        deletedRelations = new util.ArrayList[Relation]()
    }

    def this(graphId: String, metadata: util.Map[String, AnyRef]) {
        this()
        this.graphId = graphId
        this.metadata = metadata
        if (metadata != null && !metadata.isEmpty()) {
            if (null != metadata.get("IL_UNIQUE_ID"))
                this.identifier = metadata.get("IL_UNIQUE_ID").toString
            if (null != metadata.get("IL_SYS_NODE_TYPE"))
                this.nodeType = metadata.get("IL_SYS_NODE_TYPE").toString
            if (null != metadata.get("IL_FUNC_OBJECT_TYPE"))
                this.objectType = metadata.get("IL_FUNC_OBJECT_TYPE").toString
        }
        addedRelations = new util.ArrayList[Relation]()
        deletedRelations = new util.ArrayList[Relation]()
    }

    def getId: Long = id
    @JsonIgnore
    def getGraphId: String = graphId

    def getIdentifier: String = {
        if (StringUtils.isBlank(identifier) && metadata != null)
            this.identifier = metadata.get("IL_UNIQUE_ID").toString
        identifier
    }

    def getNodeType: String = {
        if (StringUtils.isBlank(nodeType) && metadata != null)
            this.nodeType = metadata.get("IL_SYS_NODE_TYPE").toString
        nodeType
    }

    def getAnyRefType: String = {
        if (StringUtils.isBlank(objectType) && metadata != null)
            this.objectType = metadata.get("IL_FUNC_OBJECT_TYPE").toString
        objectType
    }

    def getOutRelations: util.List[Relation] = {
        if (!CollectionUtils.isEmpty(outRelations))
            outRelations
        else new util.ArrayList[Relation]()
    }

    def getInRelations: util.List[Relation] = {
        if (!CollectionUtils.isEmpty(inRelations))
            inRelations
        else new util.ArrayList[Relation]()
    }

    def getAddedRelations: util.List[Relation] = addedRelations

    def getDeletedRelations: util.List[Relation] = deletedRelations

    def getNode: Node = this

    def getRelationNode(identifier: String): Node = relationNodes.get(identifier)

    def getArtifactUrl: String = metadata.getOrDefault("artifactUrl", "").toString
}

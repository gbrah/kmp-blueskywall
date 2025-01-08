package com.worldline.bluesky.network.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateSessionRequest(
    val identifier: String,
    val password: String
)

@Serializable
data class CreateSessionResponse(
    val did: String,
    val didDoc: DidDoc,
    val handle: String,
    val email: String,
    val emailConfirmed: Boolean,
    val accessJwt: String,
    val refreshJwt: String,
    val active: Boolean
)

@Serializable
data class DidDoc(
    val id: String,
    val alsoKnownAs: List<String>,
    val verificationMethod: List<VerificationMethod>,
    val service: List<Service>
)

@Serializable
data class VerificationMethod(
    val id: String,
    val type: String,
    val controller: String,
    val publicKeyMultibase: String
)

@Serializable
data class Service(
    val id: String,
    val type: String,
    val serviceEndpoint: String
)

@Serializable
data class PostData (
  var feed:ArrayList<Feed> = arrayListOf()
)

@Serializable
data class Feed (
    var post: Post?= Post(),
    var reason: Reason?= Reason()
)

@Serializable
data class Post (
    var uri: String? = null,
    var cid: String? = null,
    var author: Author? = Author(),
    var record      : Record?           = Record(),
    var embed       : Embed?            = Embed(),
    @SerialName("replyCount"  ) var replyCount  : Int?              = null,
    @SerialName("repostCount" ) var repostCount : Int?              = null,
    @SerialName("likeCount"   ) var likeCount   : Int?              = null,
    @SerialName("quoteCount"  ) var quoteCount  : Int?              = null,
    @SerialName("indexedAt"   ) var indexedAt   : String?           = null,
    @SerialName("viewer"      ) var viewer      : Viewer?           = Viewer(),
  //@SerialName("labels"      ) var labels      : ArrayList<String> = arrayListOf()
)


@Serializable
data class Author (
    var did:String? = null,
    var handle:String?           = null,
    var displayName : String?           = null,
    var avatar      : String?           = null,
    var viewer      : Viewer?           = Viewer(),
  //var labels      : ArrayList<String> = arrayListOf(),
    var createdAt   : String?           = null
)

@Serializable
data class Record (
    @SerialName("type"     ) var type     : String?           = null,
    @SerialName("createdAt" ) var createdAt : String?           = null,
    @SerialName("facets"    ) var facets    : ArrayList<Facets> = arrayListOf(),
    @SerialName("text"      ) var text      : String?           = null
)

@Serializable
data class Embed (
    @SerialName("\$type"  ) var type  : String?           = null,
    var images : ArrayList<Images> = arrayListOf(),
    var external: External = External()
)



@Serializable
data class External(
    val uri: String? =null,
    val title: String? =null,
    val description: String? = null,
    val thumb: String? = null
)


@Serializable
data class Viewer (
  var repost            : String?  = null,
  var like              : String?  = null,
  var threadMuted       : Boolean? = null,
  var muted      : Boolean? = null,
  var blockedBy  : Boolean? = null,
  var following  : String?  = null,
  var followedBy : String?  = null,
  var embeddingDisabled : Boolean? = null
)





@Serializable
data class Ref (
  @SerialName("\$link" ) var link : String? = null
)

@Serializable
data class Image (
    @SerialName("type"    ) var type    : String? = null,
    @SerialName("ref"      ) var ref      : Ref?    = Ref(),
    @SerialName("mimeType" ) var mimeType : String? = null,
    @SerialName("size"     ) var size     : Int?    = null
)




@Serializable
data class Features (
  @SerialName("type" ) var type : String? = null,
  @SerialName("tag"   ) var tag   : String? = null
)

@Serializable
data class Index (
    @SerialName("byteEnd"   ) var byteEnd   : Int? = null,
    @SerialName("byteStart" ) var byteStart : Int? = null
)

@Serializable
data class Facets (
    @SerialName("features" ) var features : ArrayList<Features> = arrayListOf(),
    @SerialName("index"    ) var index    : Index?              = Index()
)



@Serializable
data class Images (
    @SerialName("thumb"    ) var thumb    : String? = null,
    @SerialName("fullsize" ) var fullsize : String? = null,
    @SerialName("image" ) var image : Image?  = Image(),
    @SerialName("alt"      ) var alt      : String? = null
)




@Serializable
data class By (
    @SerialName("did"         ) var did         : String?           = null,
    @SerialName("handle"      ) var handle      : String?           = null,
    @SerialName("displayName" ) var displayName : String?           = null,
    @SerialName("avatar"      ) var avatar      : String?           = null,
    @SerialName("viewer"      ) var viewer      : Viewer?           = Viewer(),
  //@SerialName("labels"      ) var labels      : ArrayList<String> = arrayListOf(),
    @SerialName("createdAt"   ) var createdAt   : String?           = null
)

@Serializable
data class Reason (
    @SerialName("type"     ) var type     : String? = null,
    @SerialName("by"        ) var by        : By?     = By(),
    @SerialName("indexedAt" ) var indexedAt : String? = null
)





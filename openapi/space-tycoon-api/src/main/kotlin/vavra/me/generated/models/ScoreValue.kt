/**
 * Space Tycoon
 *
 * Space Tycoon server.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package vavra.me.generated.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param money 
 * @param resources 
 * @param ships 
 * @param total 
 */
@JsonClass(generateAdapter = true)
data class ScoreValue (

    @Json(name = "money")
    val money: kotlin.collections.Map<kotlin.String, kotlin.Long>? = null,

    @Json(name = "resources")
    val resources: kotlin.collections.Map<kotlin.String, kotlin.Long>? = null,

    @Json(name = "ships")
    val ships: kotlin.collections.Map<kotlin.String, kotlin.Long>? = null,

    @Json(name = "total")
    val total: kotlin.collections.Map<kotlin.String, kotlin.Long>? = null

)


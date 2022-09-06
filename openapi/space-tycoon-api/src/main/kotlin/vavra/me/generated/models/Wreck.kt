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
 * @param shipClass 
 * @param name 
 * @param player 
 * @param killTick 
 * @param position 
 */
@JsonClass(generateAdapter = true)
data class Wreck (

    @Json(name = "shipClass")
    val shipClass: kotlin.String,

    @Json(name = "name")
    val name: kotlin.String,

    @Json(name = "player")
    val player: kotlin.String,

    @Json(name = "killTick")
    val killTick: kotlin.Long,

    @Json(name = "position")
    val position: kotlin.collections.List<kotlin.Long>?

)

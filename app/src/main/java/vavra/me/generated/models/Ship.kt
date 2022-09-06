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

import vavra.me.generated.models.Command
import vavra.me.generated.models.Resource

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param shipClass 
 * @param life 
 * @param name 
 * @param player 
 * @param position 
 * @param prevPosition 
 * @param resources 
 * @param command 
 */
@JsonClass(generateAdapter = true)
data class Ship (

    @Json(name = "shipClass")
    val shipClass: kotlin.String,

    @Json(name = "life")
    val life: kotlin.Long,

    @Json(name = "name")
    val name: kotlin.String,

    @Json(name = "player")
    val player: kotlin.String,

    @Json(name = "position")
    val position: kotlin.collections.List<kotlin.Long>?,

    @Json(name = "prevPosition")
    val prevPosition: kotlin.collections.List<kotlin.Long>?,

    @Json(name = "resources")
    val resources: kotlin.collections.Map<kotlin.String, Resource>,

    @Json(name = "command")
    val command: Command? = null

)


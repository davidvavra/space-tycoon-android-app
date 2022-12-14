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
 * @param name 
 * @param shipyard whether ships of this class are allowed to construct new ships
 * @param speed 
 * @param cargoCapacity maximum number of resources the ship can carry - sum over all types of resources
 * @param life 
 * @param damage 
 * @param price 
 * @param regen passive regeneration per tick
 * @param repairPrice price for healing repairLife per tick (for repair command)
 * @param repairLife how much is repaired per tick (for repair command)
 */
@JsonClass(generateAdapter = true)
data class ShipClass (

    @Json(name = "name")
    val name: kotlin.String,

    /* whether ships of this class are allowed to construct new ships */
    @Json(name = "shipyard")
    val shipyard: kotlin.Boolean,

    @Json(name = "speed")
    val speed: kotlin.Double,

    /* maximum number of resources the ship can carry - sum over all types of resources */
    @Json(name = "cargoCapacity")
    val cargoCapacity: kotlin.Long,

    @Json(name = "life")
    val life: kotlin.Long,

    @Json(name = "damage")
    val damage: kotlin.Long,

    @Json(name = "price")
    val price: kotlin.Long,

    /* passive regeneration per tick */
    @Json(name = "regen")
    val regen: kotlin.Long,

    /* price for healing repairLife per tick (for repair command) */
    @Json(name = "repairPrice")
    val repairPrice: kotlin.Long,

    /* how much is repaired per tick (for repair command) */
    @Json(name = "repairLife")
    val repairLife: kotlin.Long

)


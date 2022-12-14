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

import vavra.me.generated.models.CurrentTick
import vavra.me.generated.models.DataReports
import vavra.me.generated.models.Planet
import vavra.me.generated.models.Player
import vavra.me.generated.models.Ship
import vavra.me.generated.models.Wreck

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param currentTick 
 * @param planets 
 * @param players 
 * @param ships 
 * @param playerId 
 * @param wrecks 
 * @param reports 
 */
@JsonClass(generateAdapter = true)
data class Data (

    @Json(name = "currentTick")
    val currentTick: CurrentTick,

    @Json(name = "planets")
    val planets: kotlin.collections.Map<kotlin.String, Planet>,

    @Json(name = "players")
    val players: kotlin.collections.Map<kotlin.String, Player>,

    @Json(name = "ships")
    val ships: kotlin.collections.Map<kotlin.String, Ship>,

    @Json(name = "playerId")
    val playerId: kotlin.String? = null,

    @Json(name = "wrecks")
    val wrecks: kotlin.collections.Map<kotlin.String, Wreck>? = null,

    @Json(name = "reports")
    val reports: DataReports? = null

)


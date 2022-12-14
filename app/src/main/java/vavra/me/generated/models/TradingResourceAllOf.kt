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
 * @param buyPrice 
 * @param sellPrice 
 */
@JsonClass(generateAdapter = true)
data class TradingResourceAllOf (

    @Json(name = "buyPrice")
    val buyPrice: kotlin.Double? = null,

    @Json(name = "sellPrice")
    val sellPrice: kotlin.Double? = null

)


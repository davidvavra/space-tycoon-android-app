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
 * @param target 
 * @param type 
 */
@JsonClass(generateAdapter = true)
data class AttackCommand (

    @Json(name = "target")
    val target: kotlin.String?,

    @Json(name = "type")
    val type: kotlin.String? = "attack"

)


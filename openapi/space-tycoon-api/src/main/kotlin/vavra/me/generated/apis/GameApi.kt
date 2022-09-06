package vavra.me.generated.apis

import vavra.me.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody

import vavra.me.generated.models.Command
import vavra.me.generated.models.Credentials
import vavra.me.generated.models.CurrentTick
import vavra.me.generated.models.Data
import vavra.me.generated.models.EndTurn
import vavra.me.generated.models.Error
import vavra.me.generated.models.PlayerId
import vavra.me.generated.models.Reports
import vavra.me.generated.models.StaticData

interface GameApi {
    /**
     * Specify commands for your ships
     * 
     * Responses:
     *  - 200: OK
     *  - 400: Invalid input
     *  - 403: Please login again
     *
     * @param requestBody 
     * @return [Unit]
     */
    @POST("commands")
    suspend fun commandsPost(@Body requestBody: kotlin.collections.Map<kotlin.String, Command>): Response<Unit>

    /**
     * Returns the current tick, season and the approximate time until the next tick.
     * 
     * Responses:
     *  - 200: OK
     *  - 400: Invalid input
     *  - 403: Please login again
     *
     * @return [CurrentTick]
     */
    @GET("current-tick")
    suspend fun currentTickGet(): Response<CurrentTick>

    /**
     * Dynamic game data (scores, prices, spaceship positions)
     * 
     * Responses:
     *  - 200: OK
     *  - 400: Invalid input
     *  - 403: Please login again
     *
     * @param season  (optional)
     * @param tick  (optional)
     * @return [Data]
     */
    @GET("data")
    suspend fun dataGet(@Query("season") season: kotlin.Int? = null, @Query("tick") tick: kotlin.Int? = null): Response<Data>

    /**
     * Signal that your turn is over for the current tick. Returns the current tick and the approximate time until the next tick.
     * 
     * Responses:
     *  - 200: OK
     *  - 400: Invalid input
     *  - 403: Please login again
     *  - 405: Invalid input
     *
     * @param endTurn 
     * @return [CurrentTick]
     */
    @POST("end-turn")
    suspend fun endTurnPost(@Body endTurn: EndTurn): Response<CurrentTick>

    /**
     * Get user session
     * 
     * Responses:
     *  - 200: Successfully authenticated. The session ID is returned in a cookie named `SESSION_ID`. You need to include this cookie in subsequent requests.
     *  - 400: Invalid input
     *  - 403: Invalid name or password
     *  - 405: Invalid input
     *
     * @param credentials 
     * @return [PlayerId]
     */
    @POST("login")
    suspend fun loginPost(@Body credentials: Credentials): Response<PlayerId>

    /**
     * 
     * 
     * Responses:
     *  - 200: OK
     *  - 400: Invalid input
     *
     * @return [Unit]
     */
    @GET("logout")
    suspend fun logoutGet(): Response<Unit>

    /**
     * Fetch statistical data about all players.
     * 
     * Responses:
     *  - 200: OK
     *  - 400: Invalid input
     *  - 403: Please login again
     *
     * @param season  (optional)
     * @param tick  (optional)
     * @return [Reports]
     */
    @GET("reports")
    suspend fun reportsGet(@Query("season") season: kotlin.Int? = null, @Query("tick") tick: kotlin.Int? = null): Response<Reports>

    /**
     * Data that do not change during entire season, such as ships classes.
     * 
     * Responses:
     *  - 200: OK
     *  - 400: Invalid input
     *  - 403: Please login again
     *
     * @param season  (optional)
     * @return [StaticData]
     */
    @GET("static-data")
    suspend fun staticDataGet(@Query("season") season: kotlin.Int? = null): Response<StaticData>

}

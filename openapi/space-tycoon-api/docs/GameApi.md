# GameApi

All URIs are relative to *https://space-tycoon.garage-trip.cz*

Method | HTTP request | Description
------------- | ------------- | -------------
[**commandsPost**](GameApi.md#commandsPost) | **POST** commands | Specify commands for your ships
[**currentTickGet**](GameApi.md#currentTickGet) | **GET** current-tick | Returns the current tick, season and the approximate time until the next tick.
[**dataGet**](GameApi.md#dataGet) | **GET** data | Dynamic game data (scores, prices, spaceship positions)
[**endTurnPost**](GameApi.md#endTurnPost) | **POST** end-turn | Signal that your turn is over for the current tick. Returns the current tick and the approximate time until the next tick.
[**loginPost**](GameApi.md#loginPost) | **POST** login | Get user session
[**logoutGet**](GameApi.md#logoutGet) | **GET** logout | 
[**reportsGet**](GameApi.md#reportsGet) | **GET** reports | Fetch statistical data about all players.
[**staticDataGet**](GameApi.md#staticDataGet) | **GET** static-data | Data that do not change during entire season, such as ships classes.



Specify commands for your ships

### Example
```kotlin
// Import classes:
//import vavra.me.generated.*
//import vavra.me.generated.infrastructure.*
//import vavra.me.generated.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(GameApi::class.java)
val requestBody : kotlin.collections.Map<kotlin.String, Command> =  // kotlin.collections.Map<kotlin.String, Command> | 

launch(Dispatchers.IO) {
    webService.commandsPost(requestBody)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestBody** | [**kotlin.collections.Map&lt;kotlin.String, Command&gt;**](Command.md)|  |

### Return type

null (empty response body)

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Returns the current tick, season and the approximate time until the next tick.

### Example
```kotlin
// Import classes:
//import vavra.me.generated.*
//import vavra.me.generated.infrastructure.*
//import vavra.me.generated.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(GameApi::class.java)

launch(Dispatchers.IO) {
    val result : CurrentTick = webService.currentTickGet()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**CurrentTick**](CurrentTick.md)

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Dynamic game data (scores, prices, spaceship positions)

### Example
```kotlin
// Import classes:
//import vavra.me.generated.*
//import vavra.me.generated.infrastructure.*
//import vavra.me.generated.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(GameApi::class.java)
val season : kotlin.Int = 56 // kotlin.Int | 
val tick : kotlin.Int = 56 // kotlin.Int | 

launch(Dispatchers.IO) {
    val result : Data = webService.dataGet(season, tick)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **season** | **kotlin.Int**|  | [optional]
 **tick** | **kotlin.Int**|  | [optional]

### Return type

[**Data**](Data.md)

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Signal that your turn is over for the current tick. Returns the current tick and the approximate time until the next tick.

### Example
```kotlin
// Import classes:
//import vavra.me.generated.*
//import vavra.me.generated.infrastructure.*
//import vavra.me.generated.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(GameApi::class.java)
val endTurn : EndTurn =  // EndTurn | 

launch(Dispatchers.IO) {
    val result : CurrentTick = webService.endTurnPost(endTurn)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endTurn** | [**EndTurn**](EndTurn.md)|  |

### Return type

[**CurrentTick**](CurrentTick.md)

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get user session

### Example
```kotlin
// Import classes:
//import vavra.me.generated.*
//import vavra.me.generated.infrastructure.*
//import vavra.me.generated.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(GameApi::class.java)
val credentials : Credentials =  // Credentials | 

launch(Dispatchers.IO) {
    val result : PlayerId = webService.loginPost(credentials)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **credentials** | [**Credentials**](Credentials.md)|  |

### Return type

[**PlayerId**](PlayerId.md)

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json




### Example
```kotlin
// Import classes:
//import vavra.me.generated.*
//import vavra.me.generated.infrastructure.*
//import vavra.me.generated.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(GameApi::class.java)

launch(Dispatchers.IO) {
    webService.logoutGet()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


Fetch statistical data about all players.

### Example
```kotlin
// Import classes:
//import vavra.me.generated.*
//import vavra.me.generated.infrastructure.*
//import vavra.me.generated.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(GameApi::class.java)
val season : kotlin.Int = 56 // kotlin.Int | 
val tick : kotlin.Int = 56 // kotlin.Int | 

launch(Dispatchers.IO) {
    val result : Reports = webService.reportsGet(season, tick)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **season** | **kotlin.Int**|  | [optional]
 **tick** | **kotlin.Int**|  | [optional]

### Return type

[**Reports**](Reports.md)

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Data that do not change during entire season, such as ships classes.

### Example
```kotlin
// Import classes:
//import vavra.me.generated.*
//import vavra.me.generated.infrastructure.*
//import vavra.me.generated.models.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(GameApi::class.java)
val season : kotlin.Int = 56 // kotlin.Int | 

launch(Dispatchers.IO) {
    val result : StaticData = webService.staticDataGet(season)
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **season** | **kotlin.Int**|  | [optional]

### Return type

[**StaticData**](StaticData.md)

### Authorization



### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


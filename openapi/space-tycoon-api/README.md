# vavra.me.generated - Kotlin client library for Space Tycoon

## Requires

* Kotlin 1.4.30
* Gradle 6.8.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://space-tycoon.garage-trip.cz*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*GameApi* | [**commandsPost**](docs/GameApi.md#commandspost) | **POST** commands | Specify commands for your ships
*GameApi* | [**currentTickGet**](docs/GameApi.md#currenttickget) | **GET** current-tick | Returns the current tick, season and the approximate time until the next tick.
*GameApi* | [**dataGet**](docs/GameApi.md#dataget) | **GET** data | Dynamic game data (scores, prices, spaceship positions)
*GameApi* | [**endTurnPost**](docs/GameApi.md#endturnpost) | **POST** end-turn | Signal that your turn is over for the current tick. Returns the current tick and the approximate time until the next tick.
*GameApi* | [**loginPost**](docs/GameApi.md#loginpost) | **POST** login | Get user session
*GameApi* | [**logoutGet**](docs/GameApi.md#logoutget) | **GET** logout | 
*GameApi* | [**reportsGet**](docs/GameApi.md#reportsget) | **GET** reports | Fetch statistical data about all players.
*GameApi* | [**staticDataGet**](docs/GameApi.md#staticdataget) | **GET** static-data | Data that do not change during entire season, such as ships classes.


<a name="documentation-for-models"></a>
## Documentation for Models

 - [vavra.me.generated.models.AttackCommand](docs/AttackCommand.md)
 - [vavra.me.generated.models.Combat](docs/Combat.md)
 - [vavra.me.generated.models.Command](docs/Command.md)
 - [vavra.me.generated.models.ConstructCommand](docs/ConstructCommand.md)
 - [vavra.me.generated.models.Credentials](docs/Credentials.md)
 - [vavra.me.generated.models.CurrentTick](docs/CurrentTick.md)
 - [vavra.me.generated.models.Data](docs/Data.md)
 - [vavra.me.generated.models.DataReports](docs/DataReports.md)
 - [vavra.me.generated.models.DecommissionCommand](docs/DecommissionCommand.md)
 - [vavra.me.generated.models.Destination](docs/Destination.md)
 - [vavra.me.generated.models.EndTurn](docs/EndTurn.md)
 - [vavra.me.generated.models.Error](docs/Error.md)
 - [vavra.me.generated.models.MoveCommand](docs/MoveCommand.md)
 - [vavra.me.generated.models.NetWorth](docs/NetWorth.md)
 - [vavra.me.generated.models.Planet](docs/Planet.md)
 - [vavra.me.generated.models.Player](docs/Player.md)
 - [vavra.me.generated.models.PlayerId](docs/PlayerId.md)
 - [vavra.me.generated.models.Profiling](docs/Profiling.md)
 - [vavra.me.generated.models.RenameCommand](docs/RenameCommand.md)
 - [vavra.me.generated.models.RepairCommand](docs/RepairCommand.md)
 - [vavra.me.generated.models.Reports](docs/Reports.md)
 - [vavra.me.generated.models.Resource](docs/Resource.md)
 - [vavra.me.generated.models.ScoreValue](docs/ScoreValue.md)
 - [vavra.me.generated.models.Ship](docs/Ship.md)
 - [vavra.me.generated.models.ShipClass](docs/ShipClass.md)
 - [vavra.me.generated.models.StaticData](docs/StaticData.md)
 - [vavra.me.generated.models.StopCommand](docs/StopCommand.md)
 - [vavra.me.generated.models.Trade](docs/Trade.md)
 - [vavra.me.generated.models.TradeCommand](docs/TradeCommand.md)
 - [vavra.me.generated.models.TradingResource](docs/TradingResource.md)
 - [vavra.me.generated.models.TradingResourceAllOf](docs/TradingResourceAllOf.md)
 - [vavra.me.generated.models.Wreck](docs/Wreck.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="cookieAuth"></a>
### cookieAuth

- **Type**: API key
- **API key parameter name**: SESSION_ID
- **Location**: 


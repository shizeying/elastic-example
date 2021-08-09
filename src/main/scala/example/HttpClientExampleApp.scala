package example
object HttpClientExampleApp extends App {
	//val props = ElasticProperties("http://host1:9200")
	//val client:ElasticClient = ElasticClient(JavaClient(props))
	//import com.sksamuel.elastic4s.ElasticDsl._
	import com.sksamuel.elastic4s.json.XContentFactory
	val  ingestStr="""{
									 |  "description": "update datetime for seats",
									 |  "processors": [
									 |    {
									 |      "script": {
									 |        "source": "String[] dateSplit = ctx.date.splitOnToken('-'); String year = dateSplit[0].trim(); String month = dateSplit[1].trim(); if (month.length() == 1) { month = '0' + month; } String day = dateSplit[2].trim(); if (day.length() == 1) { day = '0' + day; } boolean pm = ctx.time.substring(ctx.time.length() - 2).equals('PM'); String[] timeSplit = ctx.time.substring(0, ctx.time.length() - 2).splitOnToken(':'); int hours = Integer.parseInt(timeSplit[0].trim()); int minutes = Integer.parseInt(timeSplit[1].trim()); if (pm) { hours += 12; } String dts = year + '-' + month + '-' + day + 'T' + (hours < 10 ? '0' + hours : '' + hours) + ':' + (minutes < 10 ? '0' + minutes : '' + minutes) + ':00+08:00'; ZonedDateTime dt = ZonedDateTime.parse(dts, DateTimeFormatter.ISO_OFFSET_DATE_TIME); ctx.datetime = dt.getLong(ChronoField.INSTANT_SECONDS)*1000L;"
									 |      }
									 |    }
									 |  ]
									 |}""".stripMargin
	
	
	val correctJson =
		XContentFactory.parse(ingestStr).string()
	
	println(correctJson)
	
	
	
	//search("tubestops")
	//	.query("wimbledon")
	//	.scriptfields(
	//		scriptField(
	//			"fare_cost",
	//			script("doc['zone'] * fare_per_zone").param("fare_per_zone" -> 3.00)
	//		)
	//	)

	
}
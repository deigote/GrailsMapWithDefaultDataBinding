package grailsmapwithdefaultdatabinding

class LocalizableContent {

   Map contentByLocale = [:].withDefault { locale -> new Text() }
   
   static hasMany = [ contentByLocale : Content ]

}

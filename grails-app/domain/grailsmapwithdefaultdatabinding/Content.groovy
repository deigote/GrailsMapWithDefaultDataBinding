package grailsmapwithdefaultdatabinding

abstract class Content {

   static belongsTo = [ localizableContent : LocalizableContent ]
   
   static constraints = {
      localizableContent nullable:true
   }
}
